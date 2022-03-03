package src.Interview.algorithm.searching;

/**
 * @author Akshay Babbar
 * @purpose Generic Binary Search to be inserted.
 */
public class BinarySearch {

    /**
     * @params: integer array is passed.
     * @Params: integer number passed to be searched.
     */
    public static int binarySearch(int[] arr, int number) {
        int right = arr.length - 1;
        int leftbound = 0;
        while (leftbound <= right) {
            int mid = leftbound + (right - 1) / 2;
            if (arr[mid] == number) {
                return number;
            }
            if (arr[mid] < number) {
                leftbound = mid + 1;
            } else
                right = mid - 1;
        }
        return -1;
    }
}

