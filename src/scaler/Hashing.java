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


    public static void main(String[] args) {
        ArrayList<Integer> array1 = new ArrayList<>(Arrays.asList(2, 1, 4, 10));
        ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(3, 6, 2, 10, 10));
        ArrayList<Integer> array3 = new ArrayList<>(Arrays.asList(34, 63, 64, 38, 65, 83, 50, 44, 18, 34, 71, 80, 22, 28, 20, 96, 33, 70, 0, 25, 64, 96, 18, 2, 53, 100, 24, 47, 98, 69, 60, 55, 8, 38, 72, 94, 18, 68, 0, 53, 18, 30, 86, 55, 13, 93, 15, 43, 73, 68, 29));
        int element = 97;

        System.out.println(checkDiffK(array3, element));

//        ArrayList<Integer> output = commonElements(array1,array2);
//        for (Integer e:output) {
//            System.out.println(e);
//        }
    }
}
