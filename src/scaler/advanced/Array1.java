package src.scaler.advanced;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Array1 {

    private static int row;

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


    public static boolean[] sieve(int maxLimit) {
        boolean[] sieve = new boolean[maxLimit + 1];
        for (int i = 0; i <= maxLimit; i++) {
            sieve[i] = true;
        }
        sieve[0] = false;
        sieve[1] = false;

        for (int i = 2; i <= maxLimit; i++) {
            if (sieve[i]) {
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


    public static ArrayList<ArrayList<Integer>> rowSumB(ArrayList<ArrayList<Integer>> inputArray, int B) {
        ArrayList<ArrayList<Integer>> output = new ArrayList<>();
//        populate outputArray;

        Integer row = inputArray.size();
        Integer col = inputArray.get(0).size();
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < col; j++) {
//                output.add(new ArrayList<>(Arrays.asList(0)));
//            }
//        }
        for (int i = 0; i <= row - B; i++) {
            ArrayList<Integer> test = new ArrayList<>();
            for (int j = 0; j < col; j++) {
                int pfSum = 0;
                for (int k = i; k < i + B; k++) {
                    int curr = inputArray.get(k).get(j);
                    pfSum += curr;
                }
                test.add(pfSum);
            }
            output.add(test);
        }
        return output;
    }

    public static ArrayList<ArrayList<Integer>> rowSumB2(ArrayList<ArrayList<Integer>> inputArray, int B) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        // Iterate over each row up to (inputArray.size() - B + 1)
        int row = inputArray.size();
        int col = inputArray.getFirst().size();
        ArrayList<Long> pf = new ArrayList<>();
        for (int i = 0; i <= row - B; i++) {
            ArrayList<Integer> rowSum = new ArrayList<>();
            // Iterate over each column up to index B
            for (int j = 0; j < col; j++) {
                int sum = 0;
                for (int k = i; k < i + B; k++) {
                    sum += inputArray.get(k).get(j);
                }
                // Sum elements in column j for current row i and the next (B - 1) rows
                rowSum.add(sum);
            }
            result.add(rowSum);
        }
        return result;
    }

    public int solve(ArrayList<ArrayList<Integer>> A, int B) {
        int N = A.size();
        int M = A.get(0).size();
        int ans = Integer.MIN_VALUE;

        ArrayList<Long> pf = new ArrayList<Long>();
        for(int k = 0; k <= M-B; k++) {
            for(int row1 = 0; row1 <= N-B; row1++){
                long sumofblock=0;
                int n = row1;
                for(int row2 = row1; row2 < n+B; row2++){
                    for(int col = k; col < k+B; col++){
                        sumofblock += (long) A.get(row2).get(col);
                    }
                }
                ans = Math.max(ans, (int)sumofblock);
            }
        }
        return ans;
    }

    public long kadane( ArrayList<Long> arr){
        long maxsum = Integer.MIN_VALUE;
        long currsum = 0;
        for(int i = 0; i < arr.size(); i++){
            currsum = currsum +arr.get(i);
            if(maxsum < currsum){
                maxsum = currsum;
            }
            if(currsum <0){
                currsum = 0;
            }
        }
        return maxsum;
    }

    public static void main(String[] args) {
        ArrayList<Integer> test1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        ArrayList<Integer> test2 = new ArrayList<>(Arrays.asList(5, 6, 7, 8));
        ArrayList<Integer> test3 = new ArrayList<>(Arrays.asList(9, 10, 11, 12));
        ArrayList<Integer> test4 = new ArrayList<>(Arrays.asList(13, 14, 15, 16));

        ArrayList<ArrayList<Integer>> testOutput = new ArrayList<>();
        testOutput.add(test1);
        testOutput.add(test2);
        testOutput.add(test3);
        testOutput.add(test4);
        ArrayList<ArrayList<Integer>> result = rowSumB(testOutput, 3);

        System.out.println(primesum(16777214));
    }
}
