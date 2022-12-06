package src.Interview.leetcode.Arrays;

public class ArraysDemo {

    public static void main(String[] args) {
        ArraysDemo arraysDemo = new ArraysDemo();
        int[] TC1 = {1, 7, 3, 6, 5, 6};
        int[] TC2 = {-1, -1, -1, -1, -1, 1};
        int[] TC3 = {2, 1, -1};
        System.out.println(arraysDemo.pivotIndex(TC1));
        System.out.println(arraysDemo.pivotIndex(TC2));
        System.out.println(arraysDemo.pivotIndex(TC3));
    }

    public int pivotIndex(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            nums[i] = nums[i - 1] + nums[i];     // Prefix sum array, modification
        }
        if ((nums[n - 1] - nums[0]) == 0) {         // Check corner case, sum, 1->n-1 == 0
            return 0;
        }
        for (int k = 1; k < n; k++) {
            if (nums[k - 1] == nums[n - 1] - nums[k]) {      // Sum before k == Sum after k
                return k;
            }
        }
        return -1;

    }
}
