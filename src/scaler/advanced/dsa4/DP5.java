package src.scaler.advanced.dsa4;

public class DP5 {
    public static int lcsRecursive(String input1, String input2, int i, int j, int[][] dp) {
        if (i < 0 || j < 0) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (input1.charAt(i) == input2.charAt(j)) {
            dp[i][j] = 1 + lcsRecursive(input1, input2, i - 1, j - 1, dp);
        } else {
            dp[i][j] = Math.max(lcsRecursive(input1, input2, i - 1, j, dp), lcsRecursive(input1, input2, i, j - 1, dp));
        }
        return dp[i][j];
    }


    /**
     * Q1. Longest Common Subsequence
     * Unsolved
     * character backgroundcharacter
     * Stuck somewhere?
     * Ask for help from a TA and get it resolved.
     * Get help from TA.
     * Problem Description
     * Given two strings A and B. Find the longest common subsequence ( A sequence which does not need to be contiguous), which is common in both the strings.
     * <p>
     * You need to return the length of such longest common subsequence.
     * <p>
     * <p>
     * <p>
     * Problem Constraints
     * 1 <= Length of A, B <= 1005
     * <p>
     * <p>
     * <p>
     * Input Format
     * First argument is a string A.
     * Second argument is a string B.
     * <p>
     * <p>
     * <p>
     * Output Format
     * Return an integer denoting the length of the longest common subsequence.
     * <p>
     * <p>
     * <p>
     * Example Input
     * Input 1:
     * <p>
     * A = "abbcdgf"
     * B = "bbadcgf"
     * Input 2:
     * <p>
     * A = "aaaaaa"
     * B = "ababab"
     * <p>
     * <p>
     * Example Output
     * Output 1:
     * <p>
     * 5
     * Output 2:
     * <p>
     * 3
     * <p>
     * <p>
     * Example Explanation
     * Explanation 1:
     * <p>
     * The longest common subsequence is "bbcgf", which has a length of 5.
     * Explanation 2:
     * <p>
     * The longest common subsequence is "aaa", which has a length of 3.
     */

    public static int lcsRecursive(String input1, String input2) {
        int[][] dp = new int[input1.length()][input2.length()];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        return lcsRecursive(input1, input2, input1.length() - 1, input2.length() - 1, dp);
    }

    public static int lcsIterative(String input1, String input2, int len1, int len2, int[][] dp) {
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (input1.charAt(i - 1) == input2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[len1][len2];
    }

    public static int lcsIterative(String input1, String input2) {
        int[][] dp = new int[input1.length()][input2.length()];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }

        }
        return lcsIterative(input1, input2, input1.length(), input2.length(), dp);

    }

    public static void main(String[] args) {
        String i1 = "bebdeeedaddecebbbbbabebedc";
        String i2 = "abaaddaabbedeedeacbcdcaaed";
        String t1 = "abcde";
        String t2 = "abcde";
        System.out.println(lcsRecursive(i1, i2));
        System.out.println(lcsIterative(t1, t2));
    }

    public int minDistance(String input1, String input2) {

        int[][] dp = new int[input1.length()][input2.length()];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        return minDistance(input1, input2, input1.length() - 1, input2.length() - 1, dp);
    }

    public int minDistance(String S1, String S2, int len1, int len2, int[][] dp) {
        if (len1 < 0 && len2 < 0) {
            return 0;
        }
        if (len1 < 0) {
            return len2 + 1;

        }
        if (len2 < 0) {
            return len1 + 1;
        }
        if (dp[len1][len2] != Integer.MAX_VALUE) {
            return dp[len1][len2];
        }
        if (dp[len1][len2] == Integer.MAX_VALUE) {
            if (S1.charAt(len1) == S2.charAt(len2)) {
                dp[len1][len2] = minDistance(S1, S2, len1 - 1, len2 - 1, dp);
            } else {
                int insert = 1 + minDistance(S1, S2, len1, len2 - 1, dp);
                int replace = 1 + minDistance(S1, S2, len1 - 1, len2 - 1, dp);
                int delete = 1 + minDistance(S1, S2, len1 - 1, len2, dp);
                dp[len1][len2] = Math.min(insert, Math.min(delete, replace));
            }
        }
        return dp[len1][len2];
    }
}
