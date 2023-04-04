package src.scaler.advanced;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Hashing {

    public static void main(String[] args) {

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
