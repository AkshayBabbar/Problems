package src.Interview.linear_data_structure.Array.rotations;

/**
 * @author Akshay Babbar
 * @version 1.0
 * @Purpose "Rotate the array n number of times in place"
 */
public class Rotation {
    public static int[] rotate(int[] array, int size, int numberOfElements) {
        int[] rotatedArray = {};
        if (numberOfElements == 0) {
            return rotatedArray;
        } else {
            for (int i = 0; i < numberOfElements; i++) {
                rotatedArray = leftRotatebyOne(array);
            }
            return rotatedArray;
        }
    }

    private static int[] leftRotatebyOne(int[] array) {
        int temp = array[0];
        for (int i = 0; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        array[array.length - 1] = temp;
        return array;
    }

    public static void printArray(int[] arr, int n) {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        rotate(arr, arr.length, 2);
        printArray(arr, 7);
    }
}
