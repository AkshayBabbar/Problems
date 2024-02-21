package src.scaler.core.January23.mergeSort;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

public class MergeSorter implements Callable<List<Integer>> {


    private List<Integer> arrayToSort;
    private ExecutorService executorService;


    MergeSorter(List<Integer> arrayToSort, ExecutorService executorService) {
        this.arrayToSort = arrayToSort;
        this.executorService = executorService;
    }

    @Override
    public List<Integer> call() throws Exception {
        System.out.println("Call thread name " + Thread.currentThread().getName());

//        Base case
        if (arrayToSort.size() <= 1) {
            return arrayToSort;
        }

        int mid = arrayToSort.size() / 2;

        List<Integer> leftArray = new ArrayList<>();
        for (int i = 0; i < mid; i++) {
            leftArray.add(arrayToSort.get(i));
        }
        List<Integer> rightArray = new ArrayList<>();
        for (int i = mid; i < arrayToSort.size(); i++) {
            rightArray.add(arrayToSort.get(i));
        }

        MergeSorter leftSorter = new MergeSorter(leftArray, executorService);
        MergeSorter rightSorter = new MergeSorter(rightArray, executorService);

        List<Integer> leftSortedArray = leftSorter.call();
        List<Integer> rightSortedArray = rightSorter.call();
        // Merge the sorted halves
        List<Integer> mergedArray = new ArrayList<>();
        int i = 0, j = 0;
        while (i < leftSortedArray.size() && j < rightSortedArray.size()) {
            if (leftSortedArray.get(i) <= rightSortedArray.get(j)) {
                mergedArray.add(leftSortedArray.get(i));
                i++;
            } else {
                mergedArray.add(rightSortedArray.get(j));
                j++;
            }
        }
        // Add remaining elements from either list
        mergedArray.addAll(leftSortedArray.subList(i, leftSortedArray.size()));
        mergedArray.addAll(rightSortedArray.subList(j, rightSortedArray.size()));
        return mergedArray;
    }
}
