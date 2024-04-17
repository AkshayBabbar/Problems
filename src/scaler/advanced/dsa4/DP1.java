package src.scaler.advanced.dsa4;

import src.scaler.advanced.StringDemo;

import java.util.ArrayList;
import java.util.Arrays;

public class DP1 {
    private static int fibonacci(int input) {
        int[] fib = new int[input + 1];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i <= input; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[input];
    }

    /**
     * Q2. Max Product Subarray
     * Unsolved
     * character backgroundcharacter
     * Stuck somewhere?
     * Ask for help from a TA and get it resolved.
     * Get help from TA.
     * Problem Description
     * Given an integer array A of size N. Find the contiguous subarray within the given array (containing at least one number) which has the largest product.
     * <p>
     * Return an integer corresponding to the maximum product possible.
     * <p>
     * NOTE: Answer will fit in 32-bit integer value.
     * <p>
     * Problem Constraints
     * 1 <= N <= 5 * 105
     * <p>
     * -100 <= A[i] <= 100
     * <p>
     * Input Format
     * First and only argument is an integer array A.
     * <p>
     * Output Format
     * Return an integer corresponding to the maximum product possible.
     * <p>
     * Example Input
     * Input 1:
     * <p>
     * A = [4, 2, -5, 1]
     * Input 2:
     * <p>
     * A = [-3, 0, -5, 0]
     * <p>
     * Example Output
     * Output 1:
     * <p>
     * 8
     * Output 2:
     * <p>
     * 0
     * <p>
     * Example Explanation
     * Explanation 1:
     * <p>
     * We can choose the subarray [4, 2] such that the maximum product is 8.
     * Explanation 2:
     * <p>
     * 0 will be the maximum product possible.
     */
    public static int maxProduct(ArrayList<Integer> input) {

        /**
         * Approaches:
         *  - Kadanes
         *  - DP.
         */

        if (input.size() < 1) {
            return input.get(0);
        }
        ArrayList<Integer> maxDp = new ArrayList<>(input.size());
        ArrayList<Integer> minDp = new ArrayList<>(input.size());
        maxDp.add(input.get(0));
        minDp.add(input.get(0));
        for (int i = 1; i < input.size(); i++) {
            int element = input.get(i);
            minDp.add(Math.min(element, Math.min(element * minDp.get(i - 1), element * maxDp.get(i - 1))));
            maxDp.add(Math.max(element, Math.max(element * minDp.get(i - 1), element * maxDp.get(i - 1))));
        }
        int max = Integer.MIN_VALUE;
//        Collections.sort(maxDp);
//        System.out.println(maxDp.get(maxDp.size() -1 ));
        for (int j = 0; j < maxDp.size(); j++) {
            if (max < maxDp.get(j)) {
                max = maxDp.get(j);
            }
        }
        return max;
    }

    public static void main(StringDemo[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int input = scanner.nextInt();
//        System.out.println(fibonacci(input));
        ArrayList<Integer> TC1 = new ArrayList<>(Arrays.asList(0, 0, 0, -3, -2, 0, 1, 0, 0, 0, 0, 0, -2, 0, 0, 0, 3, 3, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 3, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, -3, 0, 0, 0, 0, -1, 0, 2, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 2, 0, 0, -2, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, -3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, -1, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
        System.out.println(maxProduct(TC1));

        ArrayList<Integer> TC2 = new ArrayList<>(Arrays.asList(11, -32, 34, 11, -5, -3, -28, 18, 31, 29));
        int B = -28;
        int C = -15;
        int D = 0;


    }

    /**
     * Q1. Maximum Sum Value
     * Unsolved
     * character backgroundcharacter
     * Stuck somewhere?
     * Ask for help from a TA and get it resolved.
     * Get help from TA.
     * Problem Description
     * <p>
     * You are given an array A of N integers and three integers B, C, and D.
     * <p>
     * You have to find the maximum value of A[i]*B + A[j]*C + A[k]*D, where 1 <= i <= j <= k <= N.
     * <p>
     * <p>
     * <p>
     * Problem Constraints
     * <p>
     * 1 <= N <= 105
     * <p>
     * -10000 <= A[i], B, C, D <= 10000
     * <p>
     * <p>
     * <p>
     * Input Format
     * <p>
     * First argument is an array A
     * Second argument is an integer B
     * Third argument is an integer C
     * Fourth argument is an integer D
     * <p>
     * <p>
     * <p>
     * Output Format
     * <p>
     * Return an Integer S, i.e maximum value of (A[i] * B + A[j] * C + A[k] * D), where 1 <= i <= j <= k <= N.
     * <p>
     * <p>
     * <p>
     * Example Input
     * <p>
     * Input 1:
     * <p>
     * A = [1, 5, -3, 4, -2]
     * B = 2
     * C = 1
     * D = -1
     * Input 2:
     * <p>
     * A = [3, 2, 1]
     * B = 1
     * C = -10
     * D = 3
     * <p>
     * <p>
     * Example Output
     * <p>
     * Output 1:
     * <p>
     * 18
     * Output 2:
     * <p>
     * -4
     * <p>
     * <p>
     * Example Explanation
     * <p>
     * Explanation 1:
     * <p>
     * If you choose i = 2, j = 2, and k = 3 then we will get
     * A[2]*B + A[2]*C + A[3]*D = 5*2 + 5*1 + (-3)*(-1) = 10 + 5 + 3 = 18
     * Explanation 2:
     * <p>
     * If you choose i = 1, j = 3, and k = 3 then we will get
     * A[1]*B + A[3]*C + A[3]*D = (3*1) + (-10*1) + (3*1) = 3 - 10 + 3 = -4
     */
    public int maxSum(ArrayList<Integer> input, int B, int C, int D) {

        ArrayList<Integer> dpmaxB = new ArrayList<>();
        ArrayList<Integer> dpmaxC = new ArrayList<>();
        ArrayList<Integer> dpmaxD = new ArrayList<>();
        dpmaxB.add(input.get(0) * B);
        dpmaxC.add(input.get(0) * C);
        dpmaxD.add(input.get(0) * D);
        for (int i = 1; i < input.size(); i++) {
            if (dpmaxB.get(i - 1) < (input.get(i) * B)) {
                dpmaxB.add(input.get(i));
            } else {
                dpmaxB.add(dpmaxB.get(i - 1));
            }
        }
        for (int i = 1; i < input.size(); i++) {
            if (dpmaxC.get(i - 1) < (input.get(i) * C)) {
                dpmaxC.add(input.get(i));
            } else {
                dpmaxC.add(dpmaxC.get(i - 1));
            }
        }
        for (int i = 1; i < input.size(); i++) {
            if (dpmaxD.get(i - 1) < (input.get(i) * D)) {
                dpmaxD.add(input.get(i));
            } else {
                dpmaxD.add(dpmaxD.get(i - 1));
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < input.size(); i++) {
            max = Math.max(max, dpmaxB.get(i) + dpmaxD.get(i) + dpmaxC.get(i));
        }
        return max;

    }
}
