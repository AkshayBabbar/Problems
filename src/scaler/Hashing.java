package src.scaler;

import java.util.*;

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
        HashSet<Integer> set2 = new HashSet<>();
        set2.addAll(B);
        ArrayList<Integer> output = new ArrayList<>();

        for (int i = 0; i < A.size(); i++) {
            if (set2.contains(A.get(i))) {
                output.add(A.get(i));
            }
        }
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
        while(next<A.size()) {
            if (map.containsKey(A.get(prev-1))) {
                if ((map.get(A.get(prev-1)) - 1) == 0) {
                    map.remove(A.get(prev-1));
                } else {
                    map.put(A.get(prev-1), map.get(A.get(prev-1)) - 1);
                }
            }
            if (map.containsKey(A.get(next))) {
                    map.put(A.get(next), map.get(A.get(next))+1);
                }
            else{
                map.put(A.get(next),1);
            }
            output.add(map.size());

            prev++;
            next++;
        }

    return output;
    }

    public static String toBinary(int A){
        String out = "";
        while(A!=0){
            out = Integer.toString(A%2) + out;
            A = A/2;
        }
        return out;
    }

    public static void main(String[] args) {
        ArrayList<Integer> array1 = new ArrayList<>(Arrays.asList(2, 1, 4, 10));
        ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(3, 6, 2, 10, 10));
        ArrayList<Integer> array3 = new ArrayList<>(Arrays.asList(3, 3, 27, 38, 38, 42, 42, 42, 42, 42, 48, 48, 54, 54, 54, 54, 54, 54, 54, 58, 63, 65, 76, 76, 76, 86, 86, 86));
        int element = 3;
        System.out.println(toBinary(17));

        System.out.println(checkDiffK(array3, element));
        ArrayList<Integer> output = dNums(array3, element);

//        ArrayList<Integer> output2 = commonElements(array1, array2);
        for (Integer e : output) {
            System.out.println(e);
        }
    }
}
