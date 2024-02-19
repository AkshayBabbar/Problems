package src.scaler.core.January23.mergeSort;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    public static void main(String[] args) {
        List<Integer> arrayToSort = List.of(
                10,2,4,1,24,23,14,55,12,125
        );
        ExecutorService executorService = Executors.newFixedThreadPool(13);
        MergeSorter mergeSorter = new MergeSorter(arrayToSort,executorService);
    }
}
