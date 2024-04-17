package src.scaler.advanced.dsa4;

import src.scaler.advanced.StringDemo;

import java.util.ArrayList;
import java.util.Arrays;

public class DP3 {

    public static void main(StringDemo[] args) {

    }

    /**
     * Q2. Unbounded Knapsack
     * Unsolved
     * character backgroundcharacter
     * Stuck somewhere?
     * Ask for help from a TA and get it resolved.
     * Get help from TA.
     * Problem Description
     * Given a knapsack weight A and a set of items with certain value B[i] and weight C[i], we need to calculate maximum amount that could fit in this quantity.
     * <p>
     * This is different from classical Knapsack problem, here we are allowed to use unlimited number of instances of an item.
     * <p>
     * <p>
     * <p>
     * Problem Constraints
     * 1 <= A <= 1000
     * <p>
     * 1 <= |B| <= 1000
     * <p>
     * 1 <= B[i] <= 1000
     * <p>
     * 1 <= C[i] <= 1000
     * <p>
     * <p>
     * <p>
     * Input Format
     * First argument is the Weight of knapsack A
     * <p>
     * Second argument is the vector of values B
     * <p>
     * Third argument is the vector of weights C
     * <p>
     * <p>
     * <p>
     * Output Format
     * Return the maximum value that fills the knapsack completely
     * <p>
     * <p>
     * <p>
     * Example Input
     * Input 1:
     * <p>
     * A = 10
     * B = [5]
     * C = [10]
     * Input 2:
     * <p>
     * A = 10
     * B = [6, 7]
     * C = [5, 5]
     * <p>
     * <p>
     * Example Output
     * Output 1:
     * <p>
     * 5
     * Output 2:
     * <p>
     * 14
     * <p>
     * <p>
     * Example Explanation
     * Explanation 1:
     * <p>
     * Only valid possibility is to take the given item.
     * Explanation 2:
     * <p>
     * Take the second item twice.
     * <p>
     * <p>
     * <p>
     * See Expected Output
     */
    public int unboundedKnapsack(int wtCapacity, ArrayList<Integer> value, ArrayList<Integer> weight) {

        int[][] dp = new int[value.size() + 1][wtCapacity + 1];
        for (int[] d : dp) {
            Arrays.fill(dp, -1);

        }
        return unboundedKnapsackDriver(wtCapacity, weight, value, value.size() - 1, dp);
    }

    public int unboundedKnapsackDriver(int wtCapacity, ArrayList<Integer> weight, ArrayList<Integer> value, int index, int[][] dp) {
        if (index == 0 || wtCapacity == 0) {
            return 0;
        }
        if (dp[index][wtCapacity] != -1) {
            return dp[index][wtCapacity];
        }
        int notTake = unboundedKnapsackDriver(wtCapacity, weight, value, index - 1, dp);
        int take = Integer.MIN_VALUE;
        if (weight.get(index) <= wtCapacity) {
            take = value.get(index) + unboundedKnapsackDriver(wtCapacity - weight.get(index), weight, value, index, dp);
        }
        return dp[index][wtCapacity] = Math.max(take, notTake);
    }
}
