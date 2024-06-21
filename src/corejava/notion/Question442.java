package src.corejava.notion;

/*
Remove duplicates from an array.
 */
public class Question442 {

    public static void main(String[] args) {

        int[] array = {1, 1, 1, 1, 2, 3, 4, 5, 6, 7};
        System.out.println(removeDuplicates(array));

    }

    public static int removeDuplicates(int[] arr) {

        int i = 0;
        for (int j = 1; j < arr.length; j++) {
            if (arr[i] != arr[j]) {
                i++;
                arr[i] = arr[j];
            }
        }
        return i + 1;
    }
}
