package Interview.algorithm.searching;

/**
 * @author Akshay Babbar
 * @version 1.0
 * Given an array arr[] of n elements, write a function to search a given element x in arr[].
 */
public class LinearSearch {
    public static int search(int[] arr, int x) {
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            if (arr[i] == x) {
                return i;
            }
        }
        return -1;
    }

}
