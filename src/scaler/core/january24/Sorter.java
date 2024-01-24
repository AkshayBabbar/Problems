package src.scaler.core.january24;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class Sorter implements Callable<List<Integer>> {
    private ExecutorService executorService;
    private  List<Integer> arrayToSort;
    public Sorter(List<Integer> arrayToSort, ExecutorService es) {
        this.executorService = executorService;
        this.arrayToSort = arrayToSort;
    }


    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public List<Integer> call() throws Exception {
        System.out.println("call ThreadName: " + Thread.currentThread().getName()
                + " Array is:  " + arrayToSort);
//        Base Case S1
        if(arrayToSort.size()<=1){
            return arrayToSort;
        }
        int mid = arrayToSort.size()/2;

        List<Integer> leftArray = new ArrayList<>();
        for (int i = 0; i < mid; i++) {
            leftArray.add(arrayToSort.get(i));
        }List<Integer> rightArray = new ArrayList<>();
        for (int i = 0; i < mid; i++) {
            rightArray.add(arrayToSort.get(i));
        }
        Sorter leftSorter = new Sorter(leftArray,executorService);
        Sorter rightSorter = new Sorter(rightArray,executorService);
        Future<List<Integer>> leftSortedArrayFuture = executorService.submit(leftSorter);
        Future<List<Integer>> rightSortedArrayFuture = executorService.submit(rightSorter);

        // WE have gotten the sorted arrays. We need to merge them Now

        // IT WILL BE BLOCKING CALL AFTER THIS LINE.
        List<Integer> sortedArray = new ArrayList<>();
        // s4 USING TWO POINTERS

        int i=0, j=0;

        List<Integer> leftSortedArray = leftSortedArrayFuture.get();
        List<Integer> rightSortedArray = rightSortedArrayFuture.get();

        while(i < leftSortedArray.size() && j < rightSortedArray.size()){
            if(leftSortedArray.get(i) < rightSortedArray.get(j)){
                sortedArray.add(leftSortedArray.get(i));
                ++i;
            }else{
                sortedArray.add(rightSortedArray.get(j));
                ++j;
            }
        }

        // s5 WHAT ELSE? --> check for remaining half
        while(i < leftSortedArray.size()){
            sortedArray.add(leftSortedArray.get(i)); i++;
        }

        while(j < rightSortedArray.size()){
            sortedArray.add(rightSortedArray.get(j)); j++;
        }

        // s6 now return --> LEts go to CLIENT
        return sortedArray;
    }
}
