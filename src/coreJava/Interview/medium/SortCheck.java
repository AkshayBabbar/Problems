package coreJava.Interview.medium;

public class SortCheck {

    public static boolean isSorted(int[] array) {
//        boolean flag;

//        if()

        if (array.length == 1 || array.length == 0) {
            return true;
        }
        int[] b = new int[array.length - 1];
        for (int i = 1; i < array.length; i++) {
            b[i - 1] = array[i];
        }

        if (array[0] < array[1]) {
            return isSorted(b);
        } else
            return false;

    }

    public static void main(String[] args) {
        System.out.println("Enter the number");
        int arr[] = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = i;
        }
        System.out.println((isSorted(arr)) ? "The array is sorted" : "array is not sorted");
    }
}
