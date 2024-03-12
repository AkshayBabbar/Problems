package src.scaler.advanced;

public class StringDemo {

    /**
     * Q1. Cyclic Permutations
     * Solved
     * feature icon
     * Get your doubts resolved blazing fast with Chat GPT Help
     * Check Chat GPT
     * feature icon
     * Using hints is now penalty free
     * Use Hint
     * Problem Description
     * Given two binary strings A and B, count how many cyclic shift of B when taken XOR with A give 0.
     * <p>
     * NOTE: If there is a string, S0, S1, ... Sn-1 , then it is a cyclic shift is of the form Sk, Sk+1, ... Sn-1, S0, S1, ... Sk-1 where k can be any integer from 0 to N-1.
     * <p>
     * <p>
     * <p>
     * Problem Constraints
     * 1 ≤ length(A) = length(B) ≤ 105
     * <p>
     * <p>
     * <p>
     * Input Format
     * The first argument is a string A.
     * The second argument is a string B.
     * <p>
     * <p>
     * <p>
     * Output Format
     * Return an integer denoting the required answer.
     * <p>
     * <p>
     * <p>
     * Example Input
     * Input 1:
     * <p>
     * A = "1001"
     * B = "0011"
     * Input 2:
     * <p>
     * A = "111"
     * B = "111"
     * <p>
     * <p>
     * Example Output
     * Output 1:
     * <p>
     * 1
     * Output 2:
     * <p>
     * 3
     * <p>
     * <p>
     * Example Explanation
     * Explanation 1:
     * <p>
     * 4 cyclic shifts of B exists: "0011", "0110", "1100", "1001".
     * There is only one cyclic shift of B i.e. "1001" which has 0 xor with A.
     * Explanation 2:
     * <p>
     * All cyclic shifts of B are same as A and give 0 when taken xor with A. So, the ans is 3.
     *
     * @param A
     * @param B
     * @return
     */
    public static int cyclicPermutationXor(String A, String B) {
        int N = A.length();
        int M = B.length();
        int count = 0;
        String val = B + B;
        int start = 0, end = N;
        while (end < 2 * M) {
            String temp = val.substring(start, end);
            if (temp.equals(A)) count++;
            start++;
            end++;
        }
        return count;
    }

    public static void main(String[] args) {

        System.out.println(cyclicPermutationXor("0111111111","1111111101"));

    }
}
