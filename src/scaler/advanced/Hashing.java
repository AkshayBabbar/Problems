package src.scaler.advanced;

import java.util.*;

public class Hashing {

    /**
     * Compare Sorted Subarrays
     * Unsolved
     * character backgroundcharacter
     * Problem Description
     * Given an array A of length N. You have to answer Q queries.
     * <p>
     * Each query will contain four integers l1, r1, l2, and r2. If sorted segment from [l1, r1] is the same as the sorted segment from [l2 r2], then the answer is 1 else 0.
     * <p>
     * NOTE The queries are 0-indexed.
     * <p>
     * Problem Constraints
     * 0 <= A[i] <= 100000
     * 1 <= N <= 100000
     * 1 <= Q <= 100000
     * <p>
     * <p>
     * Input Format
     * The first argument is an array A.
     * The second is a 2D array B denoting queries with dimension Q * 4.
     * Consider ith query as l1 = B[i][0], r1 = B[i][1], l2 = A[i][2], r2 = B[i][3].
     * <p>
     * Output Format
     * Return an array of length Q with answers to the queries in the same order as the input.
     * <p>
     * Example Input
     * Input 1:
     * <p>
     * A = [1, 7, 11, 8, 11, 7, 1]
     * B = [
     * [0, 2, 4, 6]
     * ]
     * Input 2:
     * <p>
     * A = [1, 3, 2]
     * B = [
     * [0, 1, 1, 2]
     * ]
     */
    public static ArrayList<Integer> compareSortedSubArrays(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
        int n = A.size();
        HashSet<Long> set = new HashSet<>();
        HashMap<Integer, Long> map = new HashMap<>();
        long[] pfSum = new long[n + 1];
        Random rnd = new Random();
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(A.get(i))) {
                long hash = rnd.nextLong();
                while (set.contains(hash)) {
                    hash = rnd.nextLong();
                }
                set.add(hash);
                map.put(A.get(i), hash);
            }
            pfSum[i + 1] = pfSum[i] + map.get(A.get(i));
        }
        ArrayList<Integer> output = new ArrayList<>();
        for (ArrayList<Integer> temp : B) {
            long val1 = pfSum[temp.get(1) + 1] - pfSum[temp.get(0)];
            long val2 = pfSum[temp.get(3) + 1] - pfSum[temp.get(2)];
            if (val2 == val1) {
                output.add(1);
            } else {
                output.add(0);
            }
        }
        return output;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> query = new ArrayList<>();
        query.add(new ArrayList<>(Arrays.asList(0, 2, 4, 6)));
        compareSortedSubArrays(new ArrayList<>(Arrays.asList(1, 7, 11, 8, 11, 7, 1)), query);

    }

    public ArrayList<Integer> lszero(ArrayList<Integer> A) {
        int pfSum = A.get(0);
        int startIndex = -1, endIndex = -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> output = new ArrayList<Integer>();
        for (int i = 0; i < A.size(); i++) {
            pfSum += A.get(i);
            if (map.containsKey(pfSum)) {
                startIndex = map.get(pfSum);
                endIndex = i;
            } else {
                map.put(A.get(i), i);
            }
            if (pfSum == 0) {
                startIndex = 0;
                endIndex = i;
            }
        }
        for (Map.Entry Emap : map.entrySet()) {
            Emap.getValue().equals(13);

        }
        return output;

    }

    public ArrayList<Integer> commonElements(ArrayList<Integer> first, ArrayList<Integer> second) {
        ArrayList<Integer> output = new ArrayList<>();
        HashMap<Integer, Integer> firstMap = new HashMap<>();
        HashMap<Integer, Integer> secondMap = new HashMap<>();

        for (Integer integer : first) {
            if (firstMap.containsKey(integer)) {
                firstMap.put(integer, firstMap.get(integer) + 1);
            } else {
                firstMap.put(integer, 1);
            }

        }
        return output;

    }
}
