package src.Interview.leetcode;

import java.util.Arrays;

/**
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * <p>
 * Note that you must do this in-place without making a copy of the array.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Example 2:
 * <p>
 * Input: nums = [0]
 * Output: [0]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 */
public class MoveZeros {

    public static void main(String[] args) {
        MoveZeros moveZeros = new MoveZeros();
        moveZeros.moveZeroes(new int[]{0, 1});
    }

    public void moveZeroes(int[] nums) {

        int c = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[c] = nums[i];
                c++;
            }
        }
        for (int i = c; i < nums.length; i++) {
            nums[i] = 0;
        }

    }
}
