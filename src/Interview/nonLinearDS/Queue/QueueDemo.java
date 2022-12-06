package src.Interview.nonLinearDS.Queue;

import java.util.*;

public class QueueDemo {

    public static void main(String[] args) {

    }

    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        Deque<Integer> deque = new ArrayDeque<>();

        int i = 0;
        while (i < A.size()) {
            deque.add(A.get(i));
        }
        int count = 0;
        int j = 0;
        while (j < B.size()) {
            while (!deque.peek().equals(B.get(j))) {
                deque.add(deque.remove());
                count++;
            }

            if (deque.peek().equals(B.get(j))) {
                deque.poll();
                count++;
                j++;
            }
        }

        return count;
    }
}
