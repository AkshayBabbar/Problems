package src.Interview;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static boolean getAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        if (s.length() < 2) {
            return s.charAt(0) == t.charAt(0);
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        for (int i = 0; i < t.length(); i++) {
            if (map.containsKey(t.charAt(i))) {
                map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
            }
        }
        for (Map.Entry<Character, Integer> test : map.entrySet()) {
            Integer value = test.getValue();
            if (value != 0) {
                return false;
            }
        }
        return true;
    }

    public static int getIndex(int[] arr, int key) {
        return binarySearchRecursive(0, arr.length, key, arr);
    }

    public static int binarySearchRecursive(int start, int end, int key, int[] arr) {
        int mid = start + (end - start) / 2;
        if (arr[mid] == key) {
            return mid;
        }
        else if (arr[mid] > key) {
            return binarySearchRecursive(start, mid, key, arr);
        }
        else {
            return binarySearchRecursive(mid + 1, end, key, arr);
        }
    }

    public static void main(String[] args) {
//        System.out.println(getAnagram("", ""));
        int[] arr = new int[]{1, 2, 3, 4, 5};
        System.out.println(getIndex(arr,6));
    }
}
