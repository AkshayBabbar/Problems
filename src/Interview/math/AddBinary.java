package src.Interview.math;

/**
 * Given two binary strings, return their sum (also a binary string).
 * Example:
 * https://leetcode.com/problems/add-binary
 * https://www.geeksforgeeks.org/program-to-add-two-binary-strings/
 * Input:  a = "11", b = "1"
 * Output: "100"
 */
public class AddBinary {
    public static String addBinary(String a, String b) {

        String result = "";
        int sum = 0;

        int i = a.length() - 1, j = b.length() - 1;

        while (i >= 0 || j >= 0 || sum == 1) {
            sum = sum + ((i >= 0) ? a.charAt(i) - '0' : 0);
            sum = sum + ((j >= 0) ? a.charAt(j) - '0' : 0);

            result = (char) (sum % 2 + '0') + result;

            sum = sum / 2;
            i--;
            j--;
        }
        return result;

    }

    public static void main(String[] args) {
        String a = "1101", b = "100";
    }
}
