package src.Interview.leetcode;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * You can return the answer in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 * <p>
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 * <p>
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * Only one valid answer exists.
 * <p>
 * <p>
 * Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?
 */

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
