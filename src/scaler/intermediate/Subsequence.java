package src.scaler.intermediate;

public class Subsequence {

    /**
     * Q1. Little Ponny and 2-Subsequence
     * Attempted
     * character backgroundcharacter
     * Stuck somewhere?
     * Ask for help from a TA and get it resolved.
     * Get help from TA.
     * Problem Description
     * <p>
     * Little Ponny has been given a string A, and he wants to find out the lexicographically minimum subsequence from it of size >= 2. Can you help him?
     * <p>
     * A string a is lexicographically smaller than string b, if the first different letter in a and b is smaller in a. For example, "abc" is lexicographically smaller than "acc" because the first different letter is 'b' and 'c' which is smaller in "abc".
     * Problem Constraints
     * <p>
     * 1 <= |A| <= 105
     * <p>
     * A only contains lowercase alphabets.
     * <p>
     * Input Format
     * <p>
     * The first and the only argument of input contains the string, A.
     * <p>
     * Output Format
     * <p>
     * Return a string representing the answer.
     * <p>
     * Example Input
     * <p>
     * Input 1:
     * <p>
     * A = "abcdsfhjagj"
     * Input 2:
     * <p>
     * A = "ksdjgha"
     * <p>
     * <p>
     * Example Output
     * <p>
     * Output 1:
     * <p>
     * "aa"
     * Output 2:
     * <p>
     * "da"
     * <p>
     * <p>
     * Example Explanation
     * <p>
     * Explanation 1:
     * <p>
     * "aa" is the lexicographically minimum subsequence from A.
     * Explanation 2:
     * <p>
     * "da" is the lexicographically minimum subsequence from A.
     * <p>
     * <p>
     * See Expected Output
     */
    public static String subsequence(String A) {
        StringBuffer sb = new StringBuffer();

        char minChar = 'z';
        char minChar1 = 'z';
        int index = 0;


        for (int i = 0; i < A.length() - 2; i++) {
            if (A.charAt(i) < minChar) {
                minChar = A.charAt(i);
                index = i;
            }
        }
        for (int j = index + 1; j < A.length(); j++) {
            if (A.charAt(j) < minChar1) {
                minChar1 = A.charAt(j);
            }
        }
        sb.append(minChar);
        sb.append(minChar1);
        return sb.toString();
    }

    public static void main(String[] args) {

        System.out.println(subsequence("scsecugqsb"));

    }
}
