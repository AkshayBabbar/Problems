package src.scaler.advanced;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinarySearch {

    public static int peakElement(List<Integer> input) {

        int low = 0;
        int high = input.size() - 1;
        if (input.size() < 2) {
            return low;
        }
        while (low < high) {
            int mid = (low + high) / 2;
            if (input.get(mid) > input.get(mid + 1) && input.get(mid) > input.get(mid - 1)) {
                return mid;
            }
            if (input.get(mid) < input.get(mid + 1)) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    public static int binSearch(List<Integer> A, int start, int end, int target) {
        boolean isAscending = A.get(start) < A.get(end);
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (A.get(mid) == target) {
                return mid;
            }
            if (isAscending) {
                if (A.get(mid) < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (A.get(mid) < target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }

    public static int descBinSearch(List<Integer> A, int low, int high, int B) {
        int ans = -1;
        while (low <= high) {
            int mid = (high + low) / 2;
            if (A.get(mid) == B) return mid;
            if (A.get(mid) < B) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static int ascBinSearch(List<Integer> A, int low, int high, int B) {
        int ans = -1;
        while (low <= high) {
            int mid = (high + low) / 2;
            if (A.get(mid) == B) return mid;
            if (A.get(mid) > B) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static int search(final List<Integer> A, int B) {
        int output = peakElement(A);
        if (output == 0) {
            return binSearch(A, 0, A.size(), B);
        }
        if (output > 0 && B > A.get(0) && B < A.get(output)) {
            return binSearch(A, 0, output, B);
        } else return binSearch(A, output + 1, A.size() - 1, B);
    }

    public static boolean check(ArrayList<Integer> input, int mid, int totalPainters, int maxElem, int sum, int time) {
        int curr_painter = 0;
        int painter = 0;
        for (Integer integer : input) {
            if (curr_painter + (integer * time) <= mid) {
                curr_painter += (integer * time);
            } else {
                painter++;
                curr_painter = integer * time;
            }
        }
        return painter <= totalPainters;
    }

    public static void main(StringDemo[] args) {

        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11));
        System.out.println(search(input, 12));
    }

    /**
     * Q1. Painter's Partition Problem
     * Solved
     * character backgroundcharacter
     * Stuck somewhere?
     * Ask for help from a TA and get it resolved.
     * Get help from TA.
     * Problem Description
     * Given 2 integers A and B and an array of integers C of size N. Element C[i] represents the length of ith board.
     * You have to paint all N boards [C0, C1, C2, C3 … CN-1]. There are A painters available and each of them takes B units of time to paint 1 unit of the board.
     * <p>
     * Calculate and return the minimum time required to paint all boards under the constraints that any painter will only paint contiguous sections of the board.
     * NOTE:
     * 1. 2 painters cannot share a board to paint. That is to say, a board cannot be painted partially by one painter, and partially by another.
     * 2. A painter will only paint contiguous boards. This means a configuration where painter 1 paints boards 1 and 3 but not 2 is invalid.
     * <p>
     * Return the ans % 10000003.
     * <p>
     * <p>
     * <p>
     * Problem Constraints
     * 1 <= A <= 1000
     * 1 <= B <= 106
     * 1 <= N <= 105
     * 1 <= C[i] <= 106
     * <p>
     * <p>
     * <p>
     * Input Format
     * The first argument given is the integer A.
     * The second argument given is the integer B.
     * The third argument given is the integer array C.
     * <p>
     * <p>
     * <p>
     * Output Format
     * Return minimum time required to paint all boards under the constraints that any painter will only paint contiguous sections of board % 10000003.
     * <p>
     * <p>
     * <p>
     * Example Input
     * Input 1:
     * <p>
     * A = 2
     * B = 5
     * C = [1, 10]
     * Input 2:
     * <p>
     * A = 10
     * B = 1
     * C = [1, 8, 11, 3]
     * <p>
     * <p>
     * Example Output
     * Output 1:
     * <p>
     * 50
     * <p>
     * Output 2:
     * <p>
     * 11
     * <p>
     * <p>
     * Example Explanation
     * Explanation 1:
     * <p>
     * Possibility 1:- One painter paints both blocks, time taken = 55 units.
     * Possibility 2:- Painter 1 paints block 1, painter 2 paints block 2, time take = max(5, 50) = 50
     * There are no other distinct ways to paint boards.
     * ans = 50 % 10000003
     * Explanation 2:
     * <p>
     * Each block is painted by a painter so, Painter 1 paints block 1, painter 2 paints block 2, painter 3 paints block 3
     * and painter 4 paints block 4, time taken = max(1, 8, 11, 3) = 11
     * ans = 11 % 10000003
     */
    public int paint(int worker, int time, ArrayList<Integer> input) {
        int sum = 0;
        int maxElem = Integer.MIN_VALUE;
        for (Integer integer : input) {
            if (integer > maxElem) {
                maxElem = integer;
            }
            sum += integer;
        }
        sum = sum * time;
        maxElem = maxElem * time;

        int ans = 0;

        int left = maxElem;
        int right = sum;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (check(input, mid, worker, maxElem, sum, time)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans % 10000003;
    }
}