package src.scaler.advanced.dsa4;

import src.scaler.advanced.StringDemo;

import java.util.ArrayList;

public class DP {

    public static void main(StringDemo[] args) {
        int[] A = new int[]{60, 100, 120};
        int[] B = new int[]{10, 20, 30};
        int C = 50;

        knapsackZeroOne(A, B, C);

    }

    /**
     * 0-1 Knapsack
     * <p>
     * Problem Description
     * Given two integer arrays A and B of size N each which represent values and weights associated with N items respectively.
     * Also given an integer C which represents knapsack capacity.
     * <p>
     * Find out the maximum value subset of A such that sum of the weights of this subset is smaller than or equal to C.
     * <p>
     * NOTE:
     * <p>
     * You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).
     * <p>
     * Problem Constraints
     * 1 <= N <= 103
     * 1 <= C <= 103
     * 1 <= A[i], B[i] <= 103
     * <p>
     * <p>
     * Input Format
     * First argument is an integer array A of size N denoting the values on N items.
     * Second argument is an integer array B of size N denoting the weights on N items.
     * Third argument is an integer C denoting the knapsack capacity.
     * <p>
     * <p>
     * Output Format
     * Return a single integer denoting the maximum value subset of A such that sum of the weights of this subset is smaller than or equal to C.
     * <p>
     * <p>
     * Example Input
     * Input 1:
     * <p>
     * A = [60, 100, 120]
     * B = [10, 20, 30]
     * C = 50
     * Input 2:
     * <p>
     * A = [10, 20, 30, 40]
     * B = [12, 13, 15, 19]
     * C = 10
     * <p>
     * <p>
     * Example Output
     * Output 1:
     * <p>
     * 220
     * Output 2:
     * <p>
     * 0
     * <p>
     * Example Explanation
     * Explanation 1:
     * <p>
     * Taking items with weight 20 and 30 will give us the maximum value i.e 100 + 120 = 220
     * Explanation 2:
     * <p>
     * Knapsack capacity is 10 but each item has weight greater than 10 so no items can be considered in the knapsack therefore answer is 0.
     */
    public static int knapsackZeroOne(ArrayList<Integer> value, ArrayList<Integer> weight, int maxCapacity) {

        return -1;
    }

    /**
     * 0-1 Knapsack
     * <p>
     * Problem Description
     * Given two integer arrays A and B of size N each which represent values and weights associated with N items respectively.
     * Also given an integer C which represents knapsack capacity.
     * <p>
     * Find out the maximum value subset of A such that sum of the weights of this subset is smaller than or equal to C.
     * <p>
     * NOTE:
     * <p>
     * You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).
     * <p>
     * Problem Constraints
     * 1 <= N <= 103
     * 1 <= C <= 103
     * 1 <= A[i], B[i] <= 103
     * <p>
     * <p>
     * Input Format
     * First argument is an integer array A of size N denoting the values on N items.
     * Second argument is an integer array B of size N denoting the weights on N items.
     * Third argument is an integer C denoting the knapsack capacity.
     * <p>
     * <p>
     * Output Format
     * Return a single integer denoting the maximum value subset of A such that sum of the weights of this subset is smaller than or equal to C.
     * <p>
     * <p>
     * Example Input
     * Input 1:
     * <p>
     * A = [60, 100, 120]
     * B = [10, 20, 30]
     * C = 50
     * Input 2:
     * <p>
     * A = [10, 20, 30, 40]
     * B = [12, 13, 15, 19]
     * C = 10
     * <p>
     * <p>
     * Example Output
     * Output 1:
     * <p>
     * 220
     * Output 2:
     * <p>
     * 0
     * <p>
     * Example Explanation
     * Explanation 1:
     * <p>
     * Taking items with weight 20 and 30 will give us the maximum value i.e 100 + 120 = 220
     * Explanation 2:
     * <p>
     * Knapsack capacity is 10 but each item has weight greater than 10 so no items can be considered in the knapsack therefore answer is 0.
     */
    public static int knapsackZeroOne(int[] value, int[] weight, int maxCapacity) {
        if (value.length <= 0 || weight.length <= 0 || maxCapacity <= 0 || weight.length != value.length) {
            return 0;
        }
        int i = maxCapacity, j = value.length;
        int[][] dp = new int[value.length][maxCapacity + 1];
//        for (int i = 0; i < value.length; i++) {
//            dp[i][0] = 0;
//        }
//        for (int j = 0; j < weight.length; j++) {
//            dp[0][j] = 0;
//        }
//        ArrayList<Integer> items = new ArrayList<>();
//        while (i >= 0 && j >= 0) {
//            if (dp[i][j] == dp[i - 1][j]) {
//                i--;
//            } else {
//                items.add(i);
//                j = j - weight[i - 1];
//                i--;
//            }
//        }
        return dp[value.length][maxCapacity];
    }
}
