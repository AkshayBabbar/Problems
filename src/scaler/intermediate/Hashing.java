package src.scaler.intermediate;

import java.util.*;
import java.util.Queue;

public class Hashing {

    public static int checkPallindrome(String A) {
        HashMap<Character, Integer> map = new HashMap<>();
        int n = A.length();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(A.charAt(i))) {
                map.remove(A.charAt(i), map.get(A.charAt(i)));
            } else {
                map.put(A.charAt(i), 1);
            }
        }

        if (map.size() < 2) {
            return 1;
        } else {
            return 0;
        }
    }

    public static ArrayList<Integer> commonElements(ArrayList<Integer> A, ArrayList<Integer> B) {
        // Taking HashMap of B.
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < B.size(); i++) {
            if (map.containsKey(B.get(i))) {
                map.put(B.get(i), map.get(B.get(i)) + 1);
            } else {
                map.put(B.get(i), 1);
            }
        }
        ArrayList<Integer> output = new ArrayList<>();

        for (int i = 0; i < A.size(); i++) {
            if (map.containsKey(A.get(i))) {
                output.add(A.get(i));
                if (map.get(A.get(i)) - 1 == 0) {
                    map.remove(A.get(i));
                } else {
                    map.put(A.get(i), map.get(A.get(i)) - 1);
                }
            }
        }
        Long a = 1L;
        return output;
    }

    public static int checkDiffK(ArrayList<Integer> input, int K) {
        HashMap<Integer, Integer> map = new HashMap<>();
        if (input.size() < 2) {
            return 0;
        }
        for (int i = 0; i < input.size(); i++) {
            if (map.containsKey(input.get(i))) {
                map.put(input.get(i), input.get(i) + 1);
            } else {
                map.put(input.get(i), 1);
            }
        }
        if (K == 0) {
            for (int i = 0; i < input.size(); i++) {
                int k = input.get(i);
                if (map.get(k) > 1) {
                    return 1;
                }
            }
            return 0;
        }
        for (int i = 0; i < input.size(); i++) {
            if (map.containsKey(input.get(i) - K)) {
                return 1;
            }
        }
        return 0;
    }

    public static ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        ArrayList<Integer> output = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < B; i++) {
            if (map.containsKey(A.get(i))) {
                map.put(A.get(i), map.get(A.get(i)) + 1);
            } else {
                map.put(A.get(i), 1);
            }
        }
        output.add(map.size());

        int prev = 1;
        int next = B;
        while (next < A.size()) {
            if (map.containsKey(A.get(prev - 1))) {
                if ((map.get(A.get(prev - 1)) - 1) == 0) {
                    map.remove(A.get(prev - 1));
                } else {
                    map.put(A.get(prev - 1), map.get(A.get(prev - 1)) - 1);
                }
            }
            if (map.containsKey(A.get(next))) {
                map.put(A.get(next), map.get(A.get(next)) + 1);
            } else {
                map.put(A.get(next), 1);
            }
            output.add(map.size());

            prev++;
            next++;
        }

        return output;
    }

    public static String toBinary(int A) {
        String out = "";
        while (A != 0) {
            out = Integer.toString(A % 2) + out;
            A = A / 2;
        }
        return out;
    }

    public static int function(int x, int n) {
        if (n == 0) {
            return 1;
        } else if (n % 2 == 0) {
            return function(x * x, (n - 1) / 2);
        } else {
            return x * function(x * x, (n - 1) / 2);
        }
    }

    /**
     * Problem Description
     * Given an array A of N integers.
     * <p>
     * Find the largest continuous sequence in a array which sums to zero.
     * <p>
     * <p>
     * Problem Constraints
     * 1 <= N <= 106
     * -107 <= A[i] <= 107
     * <p>
     * Input Format
     * Single argument which is an integer array A.
     * <p>
     * Output Format
     * Return an array denoting the longest continuous sequence with total sum of zero.
     * <p>
     * NOTE : If there are multiple correct answers, return the sequence which occurs first in the array.
     * <p>
     * Example Input
     * A = [1,2,-2,4,-4]
     * <p>
     * <p>
     * Example Output
     * [2,-2,4,-4]
     * <p>
     * <p>
     * Example Explanation
     * [2,-2,4,-4] is the longest sequence with total sum of zero.
     *
     * @param input
     * @return
     */
    public static ArrayList<Integer> lszero(ArrayList<Integer> input) {
        int pfSum = input.get(0);
        int startIndex = -1;
        int endIndex = -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        map.put(pfSum, 0);
        for (int i = 1; i < input.size(); i++) {
            pfSum = pfSum + input.get(i);
            if (map.containsKey(pfSum)) {
                if (map.get(pfSum) - i > ans) {
                    startIndex = map.get(pfSum) - 1;
                    endIndex = i;
                    ans = endIndex - startIndex;
                }
            }
            if (pfSum == 0) {
                startIndex = 0;
                endIndex = i;
                ans = endIndex - startIndex;
            } else {
                map.put(pfSum, i);
            }
        }

        ArrayList<Integer> output = new ArrayList<Integer>();
        for (int i = startIndex; i < endIndex + 1; i++) {
            output.add(input.get(i));
        }
        return output;
    }

    public int getSum(int A, int B, ArrayList<Integer> C) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < C.size(); i++) {
            if (map.containsKey(C.get(i))) {
                map.put(C.get(i), map.get(C.get(i)) + 1);
            } else {
                map.put(C.get(i), 1);
            }
        }
        boolean zeroFlag = false;
        for (Map.Entry<Integer, Integer> hMap : map.entrySet()) {
            if (hMap.getKey().equals(B)) {
                if (hMap.getValue().equals(0)) {
                    zeroFlag = true;
                }
                sum = sum + (int) hMap.getValue();
            }
        }
        return (!zeroFlag && sum == 0) ? -1 : sum;
    }

    public static void main(String[] args) {
        ArrayList<Integer> array1 = new ArrayList<>(Arrays.asList(1, 2, -2, 4, -4));
//        ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(2, 3, 1, 2));
//        ArrayList<Integer> array3 = new ArrayList<>(Arrays.asList(3, 3, 27, 38, 38, 42, 42, 42, 42, 42, 48, 48, 54, 54, 54, 54, 54, 54, 54, 58, 63, 65, 76, 76, 76, 86, 86, 86));
        int element = 3;
        System.out.println(function(2, 10));

        lszero(array1);
        System.out.println(toBinary(17));


//        System.out.println(checkDiffK(array3, element));
//        ArrayList<Integer> output = dNums(array3, element);

//        ArrayList<Integer> output2 = commonElements(array1, array2);
//        for (Integer e : output) {
//            System.out.println(e);
//        }
    }

//    public String solve(int A) {
//        Queue<Integer> queue = new LinkedList<>();
//        queue.add(11);
//        queue.add(22);
//        if(A<2){
//            if(A==1)return "11";
//            if(A==2)return "22";
//        }
//        int count =2;
//        else{
//            while(count<A){
//                int x = queue.peek();
//                int element = 100*x+ 100+x;
//            }
//        }
//    }

    public int[] prevSmaller(int[] A) {
        ArrayList<Integer> test = new ArrayList<>();
        int length = A.length;
        Stack<Integer> stk = new Stack<>();
        int[] outArray = new int[length];
        for (int i = 0; i < length; i++) {
            if (stk.isEmpty()) {
                outArray[i] = -1;
                stk.push(A[i]);
            } else {
                while (!stk.isEmpty() && stk.peek() >= A[i]) {
                    stk.pop();
                }
                if (stk.isEmpty()) {
                    outArray[i] = -1;
                } else outArray[i] = stk.peek();
                stk.push(A[i]);
            }
        }
        return outArray;
    }
}
