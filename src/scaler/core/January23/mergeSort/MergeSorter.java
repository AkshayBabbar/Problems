package src.scaler.core.January23.mergeSort;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class MergeSorter implements Callable<List<Integer>> {


    private List<Integer> arrayToSort;
    private ExecutorService executorService;


    MergeSorter(List<Integer> arrayToSort, ExecutorService executorService){
        this.arrayToSort = arrayToSort;
        this.executorService = executorService;
    }
    @Override
    public List<Integer> call() throws Exception {
        System.out.println("Call thread name " + Thread.currentThread().getName());

//        Base case
        if(arrayToSort.size()<=1){
            return arrayToSort;
        }

        int mid = arrayToSort.size()/2;

        List<Integer> leftArray = new ArrayList<>();
        for(int i =0; i<mid; i++){
            leftArray.add(arrayToSort.get(i));
        }
        List<Integer> rightArray = new ArrayList<>();
        for(int i =mid; i< arrayToSort.size(); i++){
            rightArray.add(arrayToSort.get(i));
        }

        MergeSorter leftSorter = new MergeSorter(leftArray, executorService);
        MergeSorter rightSorter = new MergeSorter(rightArray, executorService);

        List<Integer> leftSortedArray = leftSorter.call();
        List<Integer> rightSortedArray = rightSorter.call();

        int i=0,j=0;

        List<Integer> leftSortedArray =

    }
}
