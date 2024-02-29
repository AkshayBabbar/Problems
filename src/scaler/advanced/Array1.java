package src.scaler.advanced;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Array1 {

    public static boolean[] sieve(int maxLimit) {
        boolean[] sieve = new boolean[maxLimit + 1];
        for (int i = 0; i <= maxLimit; i++) {
            sieve[i] = true;
        }
        sieve[0] = false;
        sieve[1] = false;

        for (int i = 2; i <= maxLimit; i++) {
            if (sieve[i] == true) {
                for (int j = 2 * i; j <= maxLimit; j += i) {
                    sieve[j] = false;
                }
            }
        }
        return sieve;
    }

    /**
     * Prime Sum
     * <p>
     * Problem Description
     * Given an even number A ( greater than 2 ), return two prime numbers whose sum will be equal to the given number.
     * <p>
     * If there is more than one solution possible, return the lexicographically smaller solution.
     * <p>
     * If [a, b] is one solution with a <= b, and [c,d] is another solution with c <= d, then
     * [a, b] < [c, d], If a < c OR a==c AND b < d.
     * NOTE: A solution will always exist. Read Goldbach's conjecture.
     * <p>
     * <p>
     * <p>
     * Problem Constraints
     * 4 <= A <= 2*107
     * <p>
     * <p>
     * <p>
     * Input Format
     * First and only argument of input is an even number A.
     * <p>
     * <p>
     * <p>
     * Output Format
     * Return a integer array of size 2 containing primes whose sum will be equal to given number.
     * <p>
     * <p>
     * <p>
     * Example Input
     * 4
     * <p>
     * <p>
     * Example Output
     * [2, 2]
     * <p>
     * <p>
     * Example Explanation
     * There is only 1 solution for A = 4.
     */
    public static ArrayList<Integer> primesum(int A) {

        boolean[] sieveArray = sieve(A);
        ArrayList<Integer> out = new ArrayList<>(2);
        for (int i = 0; i < sieveArray.length; i++) {
            if (sieveArray[i] && sieveArray[A - i]) {
                out.add(i);
                out.add(A - i);
                break;
            }
        }
        return out;

    }

    /**
     * Q4. Distinct Primes
     * You have given an array A having N integers. Let say G is the product of all elements of A.
     * <p>
     * You have to find the number of distinct prime divisors of G.
     * <p>
     * Input Format
     * <p>
     * The first argument given is an Array A, having N integers.
     * Output Format
     * <p>
     * Return an Integer, i.e number of distinct prime divisors of G.
     * Constraints
     * <p>
     * 1 <= N <= 1e5
     * 1 <= A[i] <= 1e5
     * For Example
     * <p>
     * Input:
     * A = [1, 2, 3, 4]
     * Output:
     * 2
     * <p>
     * Explanation:
     * here G = 1 * 2 * 3 * 4 = 24
     * and distinct prime divisors of G are [2, 3]
     */
    public static int distinctPrime(ArrayList<Integer> A) {
        int max = Integer.MIN_VALUE;
        for (Integer i : A) {
            max = Math.max(max, i);
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i = 2; i < A.size(); i++) {
            boolean[] sieveArray = sieve(A.get(i));
            for (int j = 0; j < sieveArray.length; j++) {
                if (sieveArray[j]) {
                    set.add(j);
                }
            }
        }
        return set.size();
    }

    public static long[][] constructPrefMat(int[][] A) {
        long[][] prefMat = new long[A.length][A[0].length];
        for (int i = 0; i < A.length; i++) {
            prefMat[i][0] = A[i][0];
            //row wise prefix
            for (int j = 1; j < A[0].length; j++) {
                prefMat[i][j] = prefMat[i][j - 1] + A[i][j];
            }
        }
        //col wise prefix
        for (int i = 0; i < A[0].length; i++) {
            for (int j = 1; j < A.length; j++) {
                prefMat[j][i] = prefMat[j][i] + prefMat[j - 1][i];
            }
        }
        return prefMat;
    }

    public static int maxPathTriangle(int[][] input) {

        int row = input.length;
        int col = input[0].length;
        int dp[][] = new int[row + 1][col + 1];
        for (int j = 0; j < row; j++) {
            dp[row - 1][j] = input[row - 1][j];
        }
        for (int[] arr : dp) Arrays.fill(arr, -1);
        for (int i = row - 2; i > 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = input[i][j] + Math.max(dp[i - 1][j], dp[i][j + 1]);
            }
        }
        return dp[0][0];
    }

    public static long calculateSum(long[][] A, int x1, int y1, int x2, int y2) {

        long sum = A[x2][y2];
        if (x1 == 0 && y1 == 0) {
            return sum;
        }
        if (x1 == 0) {
            sum -= A[x2][y1 - 1];
        }
        if (y1 == 0) {
            sum -= A[x1 - 1][y2];
        }
        if (x1 != 0 && y1 != 0) {
            sum = sum - A[x2][y1 - 1] - A[x1 - 1][y2] + A[x1 - 1][y1 - 1];
        }
        return sum;
    }

    public static void main(String[] args) {
//        System.out.println(primesum(16777214));

        int[][] matrix = new int[][]{{3, 0, 0, 0}, {7, 4, 0, 0}, {2, 4, 6, 0}, {8, 5, 9, 3}};
        System.out.println(maxPathTriangle(matrix));

    }

    /**
     * Q2. <B>Max Non Negative SubArray</B>
     * <p>Given an array of integers, A of length N, find out the maximum sum sub-array of non negative numbers from A.
     * The sub-array should be contiguous i.e., a sub-array created by choosing the second and fourth element and skipping the third element is invalid.
     * <p>
     * Maximum sub-array is defined in terms of the sum of the elements in the sub-array.
     * <p>
     * Find and return the required subarray.
     * <p>
     * NOTE:
     * <p>
     * 1. If there is a tie, then compare with segment's length and return segment which has maximum length.
     * 2. If there is still a tie, then return the segment with minimum starting index.
     * <p>
     * <p>
     * Input Format:
     * <p>
     * The first and the only argument of input contains an integer array A, of length N.
     * Output Format:
     * <p>
     * Return an array of integers, that is a subarray of A that satisfies the given conditions.
     * Constraints:
     * <p>
     * 1 <= N <= 1e5
     * -INT_MAX < A[i] <= INT_MAX
     * Examples:
     * <p>
     * Input 1:
     * A = [1, 2, 5, -7, 2, 3]
     * <p>
     * Output 1:
     * [1, 2, 5]
     * <p>
     * Explanation 1:
     * The two sub-arrays are [1, 2, 5] [2, 3].
     * The answer is [1, 2, 5] as its sum is larger than [2, 3].
     * <p>
     * Input 2:
     * A = [10, -1, 2, 3, -4, 100]
     * <p>
     * Output 2:
     * [100]
     * <p>
     * Explanation 2:
     * The three sub-arrays are [10], [2, 3], [100].
     * The answer is [100] as its sum is larger than the other two.
     */
    public ArrayList<Integer> maxset(ArrayList<Integer> A) {
        ArrayList<Integer> output = new ArrayList<>();
        for (Integer i : A) {
            if (i > 0) {
                output.add(i);
            } else {
                output.clear();
            }
        }
        return output;
    }

    public int maxSubSquareMatrix(int[][] A, int B) {
        //get prefix matrix
        long[][] prefMat = constructPrefMat(A);
        long maxSum = Integer.MIN_VALUE, sum;

        //it means the whole matrix is our answer, as there is no other matrix
        if (A.length == B && A[0].length == B) return (int) calculateSum(prefMat, 0, 0, B - 1, B - 1);

        //get top-right using 2 loops
        //get x1
        for (int x1 = 0; x1 <= A.length - B; x1++) {
            //get y1
            for (int y1 = 0; y1 <= A[0].length - B; y1++) {
                //x2=x1+B-1, y2=y1+B-1
                sum = calculateSum(prefMat, x1, y1, x1 + B - 1, y1 + B - 1);
                maxSum = Math.max(maxSum, sum);

            }
        }

        return (int) maxSum;
    }
}
