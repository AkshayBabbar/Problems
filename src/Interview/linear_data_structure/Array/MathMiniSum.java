

package Interview.linear_data_structure.Array;

/**
*   @Author: Akshay Babbar
*   @URL:    https://www.hackerrank.com/challenges/mini-max-sum/problem
*
*   @Problem Statement:
*   Mini-Max Sum
        ```Given five positive integers, find the minimum and maximum values that can be calculated by summing
        exactly four of the five integers. Then print the respective minimum and maximum values as a single line
        of two space-separated long integers.
        For example, . Our minimum sum is and our maximum sum is
        . We would print
        16 24
        Function Description
        Complete the miniMaxSum function in the editor below. It should print two space-separated integers on
        one line: the minimum sum and the maximum sum of of elements.
        miniMaxSum has the following parameter(s):
        arr: an array of integers
        Input Format
        A single line of five space-separated integers.
        Constraints
        Output Format
        Print two space-separated long integers denoting the respective minimum and maximum values that can
        be calculated by summing exactly four of the five integers. (The output can be greater than a 32 bit
        integer.)
        Sample Input
        1 2 3 4 5
        Sample Output
        10 14
        Explanation
        Our initial numbers are , , , , and . We can calculate the following sums using four of the five
        integers:
        1. If we sum everything except , our sum is .
        2. If we sum everything except , our sum is .
        3. If we sum everything except , our sum is .
        4. If we sum everything except , our sum is .
        5. If we sum everything except , our sum is .
        Hints: Beware of integer overflow! Use 64-bit Integer.
        Need help to get started? Try the Solve Me First problem.
* */

import java.util.Arrays;
import java.util.Scanner;

public class MathMiniSum {


    private static final Scanner scanner = new Scanner(System.in);

    static void miniMaxSum(int[] arr) {

        long sum[] = new long[arr.length];
        long totalSum = 0;

        int i = 0;
        while (i < arr.length) {
            totalSum = totalSum + arr[i];
            i++;
        }
        System.out.println(totalSum);
        for (int j = 0; j < arr.length; j++) {
            sum[j] = totalSum - arr[j];
        }
        // for(int z = 0; z<sum.length-1;z++){
        //     System.out.println(sum[z]);
        // }
        Arrays.sort(sum);
        // System.out.println(sum[0]);
        // for(int z = 0; z<sum.length-1;z++){
        //     System.out.println(sum[z]);
        // }
        System.out.println(sum[0] + " " + sum[sum.length - 1]);

    }

    public static void main(String[] args) {
        int[] arr = new int[5];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
    }
}


