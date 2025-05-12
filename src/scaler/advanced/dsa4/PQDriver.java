package src.scaler.advanced.dsa4;

import java.util.*;

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
            i++;
        }
        if (A.size() < 2) {
            return ans;
        }
        ans = 0;
        while (!pq.isEmpty() & pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();
            sum = first + second;
            pq.add(sum);
            ans = ans + sum;
        }
        return ans;
    }

    /**
     * Q1. Magician and Chocolates
     * Problem Description
     * Given N bags, each bag contains Bi chocolates. There is a kid and a magician.
     * In a unit of time, the kid can choose any bag i, and eat Bi chocolates from it, then the magician will fill the ith bag with floor(Bi/2) chocolates.
     * <p>
     * Find the maximum number of chocolates that the kid can eat in A units of time.
     * <p>
     * NOTE:
     * <p>
     * floor() function returns the largest integer less than or equal to a given number.
     * Return your answer modulo 109+7
     * <p>
     * <p>
     * Problem Constraints
     * 1 <= N <= 100000
     * 0 <= B[i] <= INT_MAX
     * 0 <= A <= 105
     * <p>
     * <p>
     * Input Format
     * The first argument is an integer A.
     * The second argument is an integer array B of size N.
     * <p>
     * <p>
     * Output Format
     * Return an integer denoting the maximum number of chocolates the kid can eat in A units of time.
     * <p>
     * Example Input
     * Input 1:
     * <p>
     * A = 3
     * B = [6, 5]
     * Input 2:
     * <p>
     * A = 5
     * b = [2, 4, 6, 8, 10]
     * <p>
     * Example Output
     * Output 1:
     * 14
     * Output 2:
     * 33
     * <p>
     * Example Explanation
     * Explanation 1:
     * <p>
     * At t = 1 kid eats 6 chocolates from bag 0, and the bag gets filled by 3 chocolates.
     * At t = 2 kid eats 5 chocolates from bag 1, and the bag gets filled by 2 chocolates.
     * At t = 3 kid eats 3 chocolates from bag 0, and the bag gets filled by 1 chocolate.
     * so, total number of chocolates eaten are 6 + 5 + 3 = 14
     * Explanation 2:
     * <p>
     * Maximum number of chocolates that can be eaten is 33.
     */
    public static int nchoc(int time, ArrayList<Integer> bag) {
        int ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(bag.size(), Collections.reverseOrder());
        int mod = 1000_000_000 + 7;

        for (Integer iterator : bag) {

            pq.offer(iterator);

        }
        while (time > 0) {
            int top = pq.poll();
            ans = (ans + top) % mod;
            pq.offer((top / 2));
            time--;
        }
        return ans % mod;
    }

    public static int kthMinimum(ArrayList<Integer> first, ArrayList<Integer> second, int kthElement) {
//        PriorityQueue<Integer> integerPriorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
//        integerPriorityQueue.add(Math.min(first.get(0), second.get(0)));
        return 0;

    }

    public static void main(String[] args) {

//        ArrayList<Integer> inputTC1 = new ArrayList<>(Arrays.asList(57, 3, -14, -87, 42, 38, 31, -7, -28, -61));
        ArrayList<Integer> inputTC2 = new ArrayList<>(Arrays.asList(2147483647, 2000000014, 2147483647));
        ArrayList<Integer> inputTCT1 = new ArrayList<>(Arrays.asList(1, 2, 3 , 4 , 5));
        ArrayList<Integer> inputTCT2 = new ArrayList<>(Arrays.asList(2, 3, 4));
        System.out.println(getMinRopes(inputTCT1));
//        System.out.println(kthMinimum(inputTCT1, inputTCT2, 3));
//        System.out.println(nchoc(10, inputTC2));
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//        pq.add(3);
//        pq.add(3);
//        pq.add(3);
//        System.out.println(pq.size());


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

    /**
     * Given a 2D matrix of size NxM with sorted rows. Merge all the rows into a sorted 1D array.
     * Example:
     * [[1, 3, 8],
     * [2, 5, 7],
     * [4, 9, 12]]
     * Here, the respective 1D array would be:
     * [1, 2, 3, 4, 5, 7, 8, 9, 12]
     */
//    public static ArrayList<Integer> sortedArray(ArrayList<ArrayList<Integer>> input) {
//        int row = input.size();
//        int col = input.get(0).size();
//
//
//    }

    /**
     * Problem Description
     * <p>
     * Given a list containing head pointers of N sorted linked lists.
     * Merge these given sorted linked lists and return them as one sorted list.
     * <p>
     * <p>
     * <p>
     * Problem Constraints
     * <p>
     * 1 <= total number of elements in given linked lists <= 100000
     * <p>
     * <p>
     * <p>
     * Input Format
     * <p>
     * The first and only argument is a list containing N head pointers.
     * <p>
     * <p>
     * <p>
     * Output Format
     * <p>
     * Return a pointer to the head of the sorted linked list after merging all the given linked lists.
     * <p>
     * <p>
     * <p>
     * Example Input
     * <p>
     * Input 1:
     * <p>
     * 1 -> 10 -> 20
     * 4 -> 11 -> 13
     * 3 -> 8 -> 9
     * Input 2:
     * <p>
     * 10 -> 12
     * 13
     * 5 -> 6
     * <p>
     * <p>
     * Example Output
     * <p>
     * Output 1:
     * <p>
     * 1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20
     * Output 2:
     * <p>
     * 5 -> 6 -> 10 -> 12 ->13
     * <p>
     * <p>
     * Example Explanation
     * <p>
     * Explanation 1:
     * <p>
     * The resulting sorted Linked List formed after merging is 1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20.
     * Explanation 2:
     * <p>
     * The resulting sorted Linked List formed after merging is 5 -> 6 -> 10 -> 12 ->13.
     */
//    public ListNode mergeKLists(ArrayList<ListNode> list) {
//        if(list.isEmpty()){
//            return null;
//        }
//
//
//        while (list.size() > 1) {
//            int mergedSize = (list.size() + 1) / 2;
//            ArrayList<ListNode> merged = new ArrayList<>(mergedSize);
////            ListNode[] merged = new ListNode[mergedSize];
//            for (int i = 0; i < mergedSize; i++) {
//                int index1 = i * 2;
//                int index2 = i * 2 + 1;
//                ListNode l1 = list.get(index1);
//                ListNode l2 = (index2 < list.size()) ? list.get(index2) : null;
//                merged[i] = mergeTwoLists(l1, l2);
//            }
//            lists = merged;
//        }
//
//        return lists[0];
//
//    }

    /**
     * You are getting a stream of integers. With every new element you get, return the current median.
     * Example:
     * Suppose the stream is: [4, 6, 3, 2, 9]
     * After 1st element: [4] -> Median = 4
     * After 2nd element: [4, 6] -> Median = 5
     * After 3rd element: [4, 6, 3] -> [3, 4, 6] -> Median = 4
     * After 4th element: [4, 6, 3, 2] -> [2, 3, 4, 6] -> Median = 3.5
     * After 5th element: [4, 6, 3, 2, 9] -> [2, 3, 4, 6, 9] -> Median = 4
     */

//    public ArrayList<Integer> getRunningMedian(ArrayList<Integer> A) {
//        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
//        HashSet<Integer> hs = new HashSet<>();
//        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
//
//        for(int i =0; i<A.size(); i++){
//            maxHeap.add(A.get(i));
//            if(maxHeap.peek()> minHeap.peek()){
//                int max = maxHeap.peek();
//                int min = minHeap.peek();
//                maxHeap.poll();
//                minHeap.poll();
//                maxHeap.add(min);
//                minHeap.add(max);
//            }
//            if(maxHeap.size() > minHeap.size() + 1){
//                int max = maxHeap.poll();
//                maxHeap.poll();
//                minHeap.add(max);
//            }
//
//        }
//    }


}
