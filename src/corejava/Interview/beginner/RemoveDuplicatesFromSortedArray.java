package src.corejava.Interview.beginner;

import java.util.ArrayList;

/**
 * Author: AKshay Babbar
 *
 * @Purpose: Way to remove Duplicates from Sorted Array.
 */
public class RemoveDuplicatesFromSortedArray {

    public static int[] removeDuplicates(int[] arr) {
        ArrayList<Integer> temp = new ArrayList<>();
        if (arr.length < 2) {
            return arr;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == arr[i + 1]) {
                i++;
                temp.add(arr[i]);
            } else {
                temp.add(arr[i]);
            }

        }
//        int[] temp1 = ()temp.toArray();
        int[] temp1 = temp.stream().mapToInt(i -> i).toArray();
        return temp1;
    }


    public static void main(String[] args) {
        int[] duplicateSortedAr = {1, 3, 7, 8, 8, 9, 14, 16, 16, 17, 17};
        int[] nonDuplicateSortedAr = removeDuplicates(duplicateSortedAr);

        System.out.print("Displaying contents of sorted array(with duplicate elements)  : ");
        for (int i = 0; i < duplicateSortedAr.length; i++) {
            System.out.print(duplicateSortedAr[i] + " ");
        }

        System.out.println();
        System.out.print("Displaying contents of sorted array(with non-duplicate elements) : ");
        for (int i = 0; i < nonDuplicateSortedAr.length; i++) {
            System.out.print(nonDuplicateSortedAr[i] + " ");
        }
    }
}
