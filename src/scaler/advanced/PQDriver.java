package src.scaler.advanced;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class PQDriver {

    public static int maxSum(ArrayList<Integer> input, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < input.size(); i++) {
            pq.add(input.get(i));
        }
        while (k > 0 && pq.peek() < 0) {
            int top = pq.peek();
            if (top < 0) {
                pq.remove();
                top = top * -1;
                k--;
                pq.add(top);
            }
        }
        if (pq.peek() > 0 && k % 2 != 0) {
            int top = pq.peek() * -1;
            pq.remove();
            pq.add(top);
        }
        int sum = 0;

        while (!pq.isEmpty()) {
            int rem = pq.remove();
            sum += rem;
        }
        return sum;
    }

    /**
     * <p><B>Connect ropes</B></p>
     * Problem Description
     * You are given an array A of integers that represent the lengths of ropes.
     * <p>
     * You need to connect these ropes into one rope. The cost of joining two ropes equals the sum of their lengths.
     * <p>
     * Find and return the minimum cost to connect these ropes into one rope.
     * <p>
     * <p>
     * <p>
     * Problem Constraints
     * 1 <= length of the array <= 100000
     * 1 <= A[i] <= 1000
     * <p>
     * <p>
     * <p>
     * Input Format
     * The only argument given is the integer array A.
     * <p>
     * <p>
     * <p>
     * Output Format
     * Return an integer denoting the minimum cost to connect these ropes into one rope.
     * <p>
     * <p>
     * <p>
     * Example Input
     * Input 1:
     * <p>
     * A = [1, 2, 3, 4, 5]
     * Input 2:
     * <p>
     * A = [5, 17, 100, 11]
     * <p>
     * <p>
     * Example Output
     * Output 1:
     * <p>
     * 33
     * Output 2:
     * <p>
     * 182
     * <p>
     * <p>
     * Example Explanation
     * Explanation 1:
     * <p>
     * Given array A = [1, 2, 3, 4, 5].
     * Connect the ropes in the following manner:
     * 1 + 2 = 3
     * 3 + 3 = 6
     * 4 + 5 = 9
     * 6 + 9 = 15
     * <p>
     * So, total cost  to connect the ropes into one is 3 + 6 + 9 + 15 = 33.
     * Explanation 2:
     * <p>
     * Given array A = [5, 17, 100, 11].
     * Connect the ropes in the following manner:
     * 5 + 11 = 16
     * 16 + 17 = 33
     * 33 + 100 = 133
     * <p>
     * So, total cost  to connect the ropes into one is 16 + 33 + 133 = 182.
     */

    public static int getMinRopes(ArrayList<Integer> A) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int sum = 0;
        int ans = 0;
        int i = 0;
        while (i < A.size()) {
            pq.add(A.get(i));
            ans += A.get(i);
            i++;
        }
        if (A.size() < 2) {
            return ans;
        }
        ans = 0;
        ArrayList<Integer> output = new ArrayList<>();
        while (!pq.isEmpty() & pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();
            sum = first + second;
            pq.add(sum);
            ans = ans + sum;
        }
        return ans;
    }

    public static void main(String[] args) {

//        ArrayList<Integer> inputTC1 = new ArrayList<>(Arrays.asList(57, 3, -14, -87, 42, 38, 31, -7, -28, -61));
        ArrayList<Integer> inputTC2 = new ArrayList<>(Arrays.asList(16, 7, 3, 5, 9, 8, 6, 15));
        System.out.println(getMinRopes(inputTC2));

        int k = 10;
//        System.out.println(maxSum(inputTC1, k));

    }

    /**
     * Problem Description
     * N people having different priorities are standing in a queue.
     * The queue follows the property that each person is standing at most B places away from its position in the sorted queue.
     * <p>
     * Your task is to sort the queue in the increasing order of priorities.
     * <p>
     * NOTE:
     * <p>
     * No two persons can have the same priority.
     * Use the property of the queue to sort the queue with complexity O(NlogB).
     * <p>
     * <p>
     * Problem Constraints
     * 1 <= N <= 100000
     * 0 <= B <= N
     * <p>
     * <p>
     * <p>
     * Input Format
     * The first argument is an integer array A representing the priorities and initial order of N persons.
     * The second argument is an integer B.
     * <p>
     * <p>
     * <p>
     * Output Format
     * Return an integer array representing the sorted queue.
     * <p>
     * <p>
     * <p>
     * Example Input
     * Input 1:
     * <p>
     * A = [1, 40, 2, 3]
     * B = 2
     * Input 2:
     * <p>
     * A = [2, 1, 17, 10, 21, 95]
     * B = 1
     * <p>
     * <p>
     * Example Output
     * Output 1:
     * <p>
     * [1, 2, 3, 40]
     * Output 2:
     * <p>
     * [1, 2, 10, 17, 21, 95]
     * <p>
     * <p>
     * Example Explanation
     * Explanation 1:
     * <p>
     * Given array A = [1, 40, 2, 3]
     * After sorting, A = [1, 2, 3, 40].
     * We can see that difference between initial position of elements amd the final position <= 2.
     * Explanation 2:
     * <p>
     * After sorting, the array becomes [1, 2, 10, 17, 21, 95].
     */
    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < B; i++) {
            pq.add(A.get(i));
        }
        ArrayList<Integer> output = new ArrayList<>();
        for (int i = B + 1; i < A.size(); i++) {
            int min = pq.remove();
            output.add(min);
        }
        while (!pq.isEmpty()) {
            output.add(pq.remove());
        }
        return output;
    }

    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        PriorityQueue<Integer> maxQueue = new PriorityQueue<Integer>(Collections.reverseOrder());
        for (int i = 0; i < A.size(); i++) {
            maxQueue.add(A.get(i));
            if (i < 2) {
                res.add(-1);
            } else {
                int max1 = maxQueue.poll();
                int max2 = maxQueue.poll();
                int max3 = maxQueue.poll();
                res.add(max1 * max2 * max3);
                maxQueue.add(max1);
                maxQueue.add(max2);
                maxQueue.add(max3);
            }
        }
        return res;
    }
}
