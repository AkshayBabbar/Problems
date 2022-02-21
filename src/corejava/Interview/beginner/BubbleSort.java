package src.corejava.Interview.beginner;


/**
 * @Author: Akshay Babbar
 * @Purpose: To create a sorting solution using Bubble Sort Algorithm.
 */

import java.util.Scanner;

public class BubbleSort {

    public static void display(int[] array) {
        System.out.print("The array that is mentioned is ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static int[] bubbleSort(int[] data) {

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length - i - 1; j++) {
                if (data[j] < data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
        return data;
    }

    public static void main(String[] args) {

        System.out.println("The number of elements to be sorted.");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the size of array");
        int size = scanner.nextInt();
        int[] data = new int[size];

        for (int i = 0; i < size; i++) {
            System.out.println("Please enter the element that is present");
            data[i] = scanner.nextInt();
        }
        int[] sortedarray = bubbleSort(data);

        display(sortedarray);


    }
}
