package src.Interview.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.Arrays.*;

/**
 * 646. Maximum Length of Pair Chain
 * <b>Medium</b>
 * company
 * Amazon
 * company
 * Google
 * company
 * Flipkart

 * You are given an array of n pairs pairs where pairs[i] = [lefti, righti] and lefti < righti.
 * <p>
 * A pair p2 = [c, d] follows a pair p1 = [a, b] if b < c. A chain of pairs can be formed in this fashion.
 * <p>
 * Return the length longest chain which can be formed.
 * <p>
 * You do not need to use up all the given intervals. You can select pairs in any order.
 * <p>
 * Example 1:
 * <p>
 * Input: pairs = [[1,2],[2,3],[3,4]]
 * Output: 2
 * Explanation: The longest chain is [1,2] -> [3,4].
 * Example 2:
 * <p>
 * Input: pairs = [[1,2],[7,8],[4,5]]
 * Output: 3
 * Explanation: The longest chain is [1,2] -> [4,5] -> [7,8].
 * <p>
 * <p>
 * Constraints:
 * <p>
 * n == pairs.length
 * 1 <= n <= 1000
 * -1000 <= lefti < righti <= 1000
 *
 */
public class MaxPairLength {
    public static int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[1]));
        int n = pairs.length;
        int[] dp = new int[n];
        fill(dp, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[i][0] > pairs[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int maxChainLength = 0;
        for (int length : dp) {
            maxChainLength = Math.max(maxChainLength, length);
        }

        return maxChainLength;
    }

    public static void main(String[] args) {
        int[][] test = new int[][]{{1,2},{4,7},{3,5}};
        System.out.println(findLongestChain(test));


    }

}
