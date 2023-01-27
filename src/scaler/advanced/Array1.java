package src.scaler.advanced;

import java.util.ArrayList;
import java.util.List;

public class Array1 {

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

    /**
     * Q1. Rain Water Trapped
     * Problem Description
     * Given a vector A of non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
     * <p>
     * <p>
     * <p>
     * Problem Constraints
     * 1 <= |A| <= 100000
     * <p>
     * <p>
     * <p>
     * Input Format
     * First and only argument is the vector A
     * <p>
     * <p>
     * <p>
     * Output Format
     * Return one integer, the answer to the question
     * <p>
     * <p>
     * <p>
     * Example Input
     * Input 1:
     * <p>
     * A = [0, 1, 0, 2]
     * Input 2:
     * <p>
     * A = [1, 2]
     * <p>
     * <p>
     * Example Output
     * Output 1:
     * <p>
     * 1
     * Output 2:
     * <p>
     * 0
     * <p>
     * <p>
     * Example Explanation
     * Explanation 1:
     * <p>
     * 1 unit is trapped on top of the 3rd element.
     * Explanation 2:
     * <p>
     * No water is trapped.
     */
    

    public static void main(String[] args) {

    }
}
