package src.scaler.advanced.dsa4;

import src.scaler.advanced.StringDemo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class QueueDemo {
    /**
     * N integers containing only 1, 2 & 3
     * Problem Description
     * Given an integer, A. Find and Return first positive A integers in ascending order containing only digits 1, 2, and 3.
     * <p>
     * NOTE: All the A integers will fit in 32-bit integers.
     * <p>
     * <b>Problem Constraints</b>
     * 1 <= A <= 29500
     * <p>
     * <p>
     * <b>Input Format</b>
     * The only argument given is integer A.
     * <p>
     * <p>
     * <p>
     * <b>Output Format</b>
     * <p>Return an integer array denoting
     * the first positive A integers in ascending order containing only digits 1, 2 and 3.</p>
     * <p>
     * <p>
     * <p>
     * Example Input
     * Input 1:
     * <p>
     * A = 3
     * Input 2:
     * <p>
     * A = 7
     * <p>
     * <p>
     * Example Output
     * Output 1:
     * <p>
     * [1, 2, 3]
     * Output 2:
     * <p>
     * [1, 2, 3, 11, 12, 13, 21]
     * <p>
     * <p>
     * Example Explanation
     * Explanation 1:
     * <p>
     * Output denotes the first 3 integers that contains only digits 1, 2 and 3.
     * Explanation 2:
     * <p>
     * Output denotes the first 3 integers that contains only digits 1, 2 and 3.
     */
    public static ArrayList<Integer> getPermutation(int n) {
        Deque<Integer> dq = new ArrayDeque<>();
        ArrayList<Integer> output = new ArrayList<>();
        if (n < 3) {
            for (int i = 1; i <= n; i++) {
                output.add(i);
            }
        } else {
            int i = 1;
            while (i <= 3) {
                dq.add(i);
                i++;
            }
            while (output.size() < n) {
                Integer el = dq.poll();
                output.add(el);
                el = el * 10;
                int j = 1;
                while (j <= 3) {
                    dq.add(el + j);
                    j++;
                }

                j = 0;
            }

        }
        return output;
    }

    public static ArrayList<Integer> slidingWindowMaximum(final ArrayList<Integer> input, int k) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
//            while(!dq.isEmpty() && input.size()>0)
//                dq.add(input.get(i));
        }
        ArrayList<Integer> output = new ArrayList<>();
        for (int i = k; i < input.size(); i++) {
            Integer rear = dq.peek();
            if (rear < input.get(i)) {
                dq.poll();
            } else {
                dq.add(input.get(i));
            }
//            output.add(Math.min(dq.peekFirst()));

        }
        return output;

    }

    public static void main(StringDemo[] args) {
        getPermutation(9);
    }
}
