package src.scaler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ArrayIntro {

    /**
     * Rotate Array N Times
     */
    public static ArrayList<Integer> rotate(ArrayList<Integer> input, int B) {

        if (B == 0) {
            return input;
        } else {
            int size = input.size();
            ArrayList<Integer> output = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                int index = (i + B) % size;
                output.add(i, input.get(index));
            }
            return output;
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> test = new ArrayList<>();

//        test.add(1);
//        test.add(2);
//        test.add(4);
//        test.add(5);
//        Collections.addAll(test, 1, 2, 3, 7, 1, 2, 3);
        Collections.addAll(test, -533, -666, -500, 169, 724, 478, 358, -38, -536, 705, -855, 281, -173, 961, -509, -5, 942, -173, 436, -609, -396, 902, -847, -708, -618, 421, -284, 718, 895, 447, 726, -229, 538, 869, 912, 667, -701, 35, 894, -297, 811, 322, -667, 673, -336, 141, 711, -747, -132, 547, 644, -338, -243, -963, -141, -277, 741, 529, -222, -684, 35);
//        ArrayList<Integer> out = rotate(test, 3);
//        for (int i = 0; i < out.size(); i++) {
//            System.out.print(out.get(i) + " ");
//        }

//        ArrayList<ArrayList<Integer>> check = new ArrayList<>();
//        check.add(new ArrayList<>(Arrays.asList(1, 38)));
//        check.add(new ArrayList<>(Arrays.asList(15, 52)));
//        check.add(new ArrayList<>(Arrays.asList(50, 65)));
//        check.add(new ArrayList<>(Arrays.asList(12, 50)));
//        check.add(new ArrayList<>(Arrays.asList(47, 72)));
//        check.add(new ArrayList<>(Arrays.asList(15, 34)));
//        check.add(new ArrayList<>(Arrays.asList(8, 61)));
//        check.add(new ArrayList<>(Arrays.asList(16, 65)));
//        check.add(new ArrayList<>(Arrays.asList(18, 69)));
//        check.add(new ArrayList<>(Arrays.asList(39, 52)));
//        check.add(new ArrayList<>(Arrays.asList(38, 44)));
//        check.add(new ArrayList<>(Arrays.asList(26, 63)));
//        check.add(new ArrayList<>(Arrays.asList(8, 60)));
//        check.add(new ArrayList<>(Arrays.asList(53, 58)));
//        ArrayIntro arrayIntro = new ArrayIntro();
//        ArrayList<Long> output = arrayIntro.rangeSum(test, check);
//        for (int i = 0; i < output.size(); i++) {
//            System.out.println(output.get(i));
//        }
        ArrayIntro arrayIntro = new ArrayIntro();
//        int output = arrayIntro.getEquilibrium(test);
        int output = arrayIntro.maxPossibleSum(test,48);

        if (output != -1) {
            System.out.println("Equilibrium point is " + output);
        } else {
            System.out.println("There is no equilibrium point exist.");
        }

    }

    //    public ArrayList<Long> prefixSumUtil(ArrayList<Integer> A) {
//        ArrayList<Long> prefixSum = new ArrayList<>();
//        prefixSum.add(Long.valueOf(A.get(0)));
//
//        for (int i = 1; i < A.size(); i++) {
//            prefixSum.add(prefixSum.get(i - 1) + A.get(i));
//        }
//
//        return prefixSum;
//    }
    public ArrayList<Integer> prefixSumUtil(ArrayList<Integer> A) {


        ArrayList<Integer> prefixSum = new ArrayList<>();
        prefixSum.add(A.get(0));

        for (int i = 1; i < A.size(); i++) {
            prefixSum.add(prefixSum.get(i - 1) + A.get(i));
        }

        return prefixSum;
    }

    public ArrayList<Integer> rangeSum(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<Integer> prefixSum = prefixSumUtil(A);
        ArrayList<Integer> range = new ArrayList<>();
        for (int i = 0; i < B.size(); i++) {
            int start = B.get(i).get(0);
            int end = B.get(i).get(1);
            int endPrefixSum = prefixSum.get(end - 1);
            if (start == 1) {
                range.add(endPrefixSum);
            } else {
                int startPrefixSum = prefixSum.get(start - 2);
                range.add(endPrefixSum - startPrefixSum);
            }

        }
        return range;
    }

    /**
     * You are given an array A of integers of size N.
     * Your task is to find the equilibrium index of the given array
     * The equilibrium index of an array is an index such that the sum of elements at lower indexes is equal to the sum of elements at higher indexes.
     */

    public int getEquilibrium(ArrayList<Integer> A) {
        ArrayList<Integer> prefixSum = prefixSumUtil(A);
        ArrayList<Integer> index = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            if (i == 0) {
                if (prefixSum.get(A.size() - 1) - A.get(i) == 0) {
                    index.add(i);
                }
            }
            if (i > 1 && prefixSum.get(i - 1) == (prefixSum.get(A.size() - 1) - prefixSum.get(i))) {
                index.add(i);
            }
            if (i == A.size() - 1) {
                if (prefixSum.get(i - 1) == 0) {
                    index.add(i);
                }
            }
        }

        Arrays.sort(index.toArray());

        if (index.isEmpty()) {
            return -1;
        } else {
            return index.get(0);
        }

    }

    /**
     * You are given an integer array A of size N.
     * You have to pick B elements in total. Some (possibly 0) elements from left end of array A and some (possibly 0) from the right end of array A to get the maximum sum.
     * Find and return this maximum possible sum.
     * @param A
     * @param B
     * @return integer
     */
    public int maxPossibleSum(ArrayList<Integer> A, int B) {

        int n = A.size();
        int ans = Integer.MIN_VALUE;
        int curr = 0;
        int back= B-1;
        for(int i =0;i<B;i++){
            curr = A.get(i) + curr;
        }
        // got Current Value till B;
        ans = Math.max(curr,ans);
        for(int i=0; i<B; i++){
            if(back!=-1){
                curr = curr - A.get(back -i) + A.get(n-1-i);
                ans = Math.max(ans,curr);
            }
        }

        return ans;
    }

}
