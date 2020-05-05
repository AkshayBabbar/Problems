package coreJava.Interview.medium;

import java.util.Scanner;

/*
 *
 * Author: Akshay Babbar
 * Purpose: Implementation of Merge Sort for recursion based solution.*/
public class MergeSort {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of array");

        int size = scanner.nextInt();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            System.out.println("Enter the elements");
            array[i] = scanner.nextInt();
        }
        mergeSort(array);


    }

    private static void mergeSort(int[] array) {

        int midpoint = array.length / 2;
        int[] firstHalf = new int[midpoint];
        int[] secondHalf = new int[array.length - midpoint];
//        Copy Data to First Half
        for (int i = 0; i < midpoint; i++) {
            firstHalf[i] = array[i];
        }
//        Copy Data to second Half
        for (int i = midpoint; i < array.length; i++) {
            secondHalf[i] = array[i];
        }
        mergeSort(firstHalf);
        mergeSort(secondHalf);
        merge(firstHalf, secondHalf, array);


    }

    private static void merge(int[] firstHalf, int[] secondHalf, int[] array) {

    }
}
