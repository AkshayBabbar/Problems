package src.Interview.leetcode;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TwoSums {
    private static final Logger LOGGING = Logger.getLogger(TwoSums.class.getName());

    public static void main(String[] args) {

        int target = 9;
        int[] array1 = {2, 7, 11, 15};
        TwoSums twoSums = new TwoSums();

        int[] array = twoSums.getTwoSum(array1, target);
        LOGGING.log(Level.INFO, "THIS IS FIRST ELEMENT {0} ", array[0]);
        LOGGING.log(Level.INFO, "THIS IS SECOND ELEMENT {0} ", array[1]);

    }

    public int[] getTwoSum(int[] nums, int target) {


        HashMap<Integer, Integer> map = new HashMap<>();
        int[] output = {0, 0};
        for (int i = 0; i < nums.length; i++) {
            int check = target - nums[i];
            if (map.containsKey(check)) {
                output[0] = i;
                output[1] = map.get(check);
            } else {
                map.put(nums[i], i);
            }
        }
        return output;

    }
}
