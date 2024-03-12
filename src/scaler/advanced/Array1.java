package src.scaler.advanced;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Array1 {

    private static int row;

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

    public static int kadane(ArrayList<Integer> v) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < (int) v.size(); i++) {
            currSum += v.get(i);
            if (currSum > maxSum) {
                maxSum = currSum;
            }

            if (currSum < 0) {
                currSum = 0;
            }
        }
        return maxSum;
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


    public int maxSumMatrix(int[][] A) {
        int r = A.length;
        int c = A[0].length;
        int[][] prefix = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (j == 0) prefix[i][j] = A[i][j];
                else prefix[i][j] = A[i][j] + prefix[i][j - 1];
            }
        }
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < c; i++) {
            for (int j = i; j < c; j++) {
                ArrayList<Integer> v = new ArrayList();
                for (int k = 0; k < r; k++) {
                    int el = 0;
                    if (i == 0) el = prefix[k][j];
                    else el = prefix[k][j] - prefix[k][i - 1];
                    v.add(el);
                }
                maxSum = Math.max(maxSum, kadane(v));
            }
        }
        return maxSum;
    }

    private static ArrayList<ArrayList<Integer>> getArrayLists(int[][] inputArray) {
        ArrayList<ArrayList<Integer>> intervals = new ArrayList<>();
        for (int[] innerArray : inputArray) {
            // Create a new inner list to store the elements
            ArrayList<Integer> newInnerList = new ArrayList<>();

            // Add each element from the current inner array to the new inner list
            for (int element : innerArray) {
                newInnerList.add(element);
            }

            // Add the new inner list to the intervals list
            intervals.add(newInnerList);
        }
        return intervals;
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
        long sum = 0; // for doing sum
        long maxSum = 0; // to store the final sum

        ArrayList<Integer> maxArray = new ArrayList<>(); // we will store here for each positive subarray
        ArrayList<Integer> outputArray = new ArrayList<>(); // final max subarray

        for (Integer i : A) { // iterate the ArrayList A
            if (i >= 0) { // if element >= 0
                sum += i; // then add them
                maxArray.add(i); // and store the element to the maxArr
            } else {
                sum = 0; // but if element < 0, then update the sum = 0
                maxArray = new ArrayList<>(); // and update the maxArr to new ArrayList again
            }
            if (maxSum < sum || maxSum == sum && (maxArray.size() > outputArray.size())) {
                // when maximum sum < sum, update maxSum = sum and resArr = maxArr .
                // or if maxSum and sum are equal then return the subarray which has maximum length
                maxSum = sum;
                outputArray = maxArray;
            }
        }
        return outputArray; // finally return the resultArray
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

    public static ArrayList<Integer> beggar(int A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<Integer> pfSum = new ArrayList<>();
        ArrayList<Integer> out = new ArrayList<>();

        for (int i = 0; i < A; i++) {
            pfSum.add(0);
            out.add(0);

        }


        for (int i = 0; i < B.size(); i++) {
            ArrayList<Integer> temp = B.get(i);
            int startIndex = temp.get(0);
            int endIndex = temp.get(1);
            int value = temp.get(2);

            pfSum.set(startIndex - 1, pfSum.get(startIndex - 1) + value);
            System.out.println();
            if (endIndex != A) {
                pfSum.set(endIndex, pfSum.get(endIndex) - value);
            }
        }

        out.set(0, pfSum.get(0));

        for (int i = 1; i < pfSum.size(); i++) {
            out.set(i, pfSum.get(i) + out.get(i - 1));
        }

        return out;
    }

    public static int trap(final ArrayList<Integer> A) {

        ArrayList<Integer> leftM = new ArrayList<>();
        leftM.add(A.getFirst());
        ArrayList<Integer> rightM = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            rightM.add(0);
        }
        for (int i = 1; i < A.size(); i++) {
            leftM.add(Math.max(A.get(i), leftM.get(i - 1)));
        }
        rightM.set(A.size() - 1, A.get(A.size() - 1));
        for (int i = A.size() - 2; i > -1; i--) {
            rightM.set(i, Math.max(A.get(i), rightM.get(i + 1)));
        }
        int out = 0;

        for (int i = 0; i < A.size(); i++) {
            out += Math.min(rightM.get(i), leftM.get(i)) - A.get(i);
        }
        return out;
    }


    public static void main(StringDemo[] args) {
//        System.out.println(primesum(16777214));
        ArrayList<Integer> water = new ArrayList<>(Arrays.asList(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1));

        int[][] matrix = new int[][]{{3, 0, 0, 0}, {7, 4, 0, 0}, {2, 4, 6, 0}, {8, 5, 9, 3}};

        int[][] inputArray = new int[][]{
                {1, 2, 100}, {2, 5, 100}, {3, 4, 100}
        };
        System.out.println(trap(water));
        ArrayList<ArrayList<Integer>> intervals = getArrayLists(inputArray);
//        ArrayList<Integer> beggar = (beggar(5, intervals));
//        for (Integer i : beggar) {
//            System.out.print(i + ", ");
//        }
//        System.out.println(maxPathTriangle(matrix));


    }
}
