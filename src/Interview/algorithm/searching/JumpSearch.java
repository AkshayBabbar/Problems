package Interview.algorithm.searching;

/**
 * @author Akshay Babbar
 * <p>Jump Search is a searching algorithm for sorted arrays.
 * The basic idea is to check fewer elements (than linear search) by jumping ahead by fixed steps
 * or skipping some elements in place of searching all elements.</p>
 */
public class JumpSearch {

    public static int jump(int[] arr, int x) {
        int size = arr.length - 1;
        int jumpBlock = (int) Math.floor(Math.sqrt(size));

        int previousePointer = 0;

        while (arr[Math.min(jumpBlock, size)] < x) {
            previousePointer = jumpBlock;
            jumpBlock = jumpBlock + (int) Math.floor(Math.sqrt(size));
            if (previousePointer >= size) {
                return -1;
            }
        }

        while (arr[previousePointer] < x) {
            previousePointer++;

            // If we reached next block or end of
            // array, element is not present.
            if (previousePointer == Math.min(jumpBlock, size))
                return -1;
        }

        // If element is found
        if (arr[previousePointer] == x)
            return previousePointer;

        return -1;
    }

}
