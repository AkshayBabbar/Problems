package src.scaler.advanced;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Hashing {

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

    public static int nearestDuplicates(ArrayList<Integer> input) {
        Map<Integer, Integer> map = new HashMap<>();
        int nearestSum = 0;

        for (int i = 0; i < input.size(); i++) {
            if (map.containsKey(input.get(i))) {
                nearestSum = Math.max(nearestSum, i - map.get(input.get(i)));
                map.put(input.get(i), i);
            } else {
                map.put(input.get(i), i);
            }
        }
        return nearestSum;
    }

    public static void main(StringDemo[] args) {

    }
}
