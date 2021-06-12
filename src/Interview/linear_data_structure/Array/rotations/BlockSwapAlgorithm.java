package Interview.linear_data_structure.Array.rotations;

/*
*
* Initialize A = arr[0..d-1] and B = arr[d..n-1]
1) Do following until size of A is equal to size of B

  a)  If A is shorter, divide B into Bl and Br such that Br is of same
       length as A. Swap A and Br to change ABlBr into BrBlA. Now A
       is at its final place, so recur on pieces of B.

   b)  If A is longer, divide A into Al and Ar such that Al is of same
       length as B Swap Al and B to change AlArB into BArAl. Now B
       is at its final place, so recur on pieces of A.

2)  Finally when A and B are of equal size, block swap them.
*
* */

public class BlockSwapAlgorithm {

    public static void leftRotate(int[] arr, int numberOfElementsToBeRotated, int arraySize) {
        leftRotateRecursive(arr, 0, numberOfElementsToBeRotated, arraySize);
    }

    public static void leftRotateRecursive(int[] arr, int i, int numberOfElementsToBeRotated, int arraySize) {
        if (numberOfElementsToBeRotated == 0 || numberOfElementsToBeRotated == arraySize) {
            return;
        }
        if (arraySize - numberOfElementsToBeRotated == numberOfElementsToBeRotated) {
            swap(arr, i, arraySize - numberOfElementsToBeRotated + i, numberOfElementsToBeRotated);
        }

        if (numberOfElementsToBeRotated < arraySize - numberOfElementsToBeRotated) {
            swap(arr, i, numberOfElementsToBeRotated, arraySize - numberOfElementsToBeRotated);
        } else {
            swap(arr, i, numberOfElementsToBeRotated, arraySize - numberOfElementsToBeRotated);
//            leftRotate(arr+arraySize-numberOfElementsToBeRotated,);
        }
    }

    private static void swap(int[] arr, int fi, int si, int numberOfElementsToBeRotated) {
        int temp;
        for (int i = 0; i < numberOfElementsToBeRotated; i++) {
            temp = arr[fi + i];
            arr[fi + i] = arr[si + i];
            arr[si + i] = temp;
        }
    }

    public static void printArray(int[] arr, int arraySize) {
        int i;
        for (i = 0; i < arraySize; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }


    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        leftRotate(arr, 2, 7);
        printArray(arr, 7);
    }
}
