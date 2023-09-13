package src.Interview.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Group the People Given the Group Size They Belong To
 * <p>
 * There are n people that are split into some unknown number of groups. Each person is labeled with a unique ID from 0 to n - 1.
 * <p>
 * You are given an integer array groupSizes, where groupSizes[i] is the size of the group that person i is in. For example, if groupSizes[1] = 3, then person 1 must be in a group of size 3.
 * <p>
 * Return a list of groups such that each person i is in a group of size groupSizes[i].
 * <p>
 * Each person should appear in exactly one group, and every person must be in a group. If there are multiple answers, return any of them. It is guaranteed that there will be at least one valid solution for the given input.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: groupSizes = [3,3,3,3,3,1,3]
 * Output: [[5],[0,1,2],[3,4,6]]
 * Explanation:
 * The first group is [5]. The size is 1, and groupSizes[5] = 1.
 * The second group is [0,1,2]. The size is 3, and groupSizes[0] = groupSizes[1] = groupSizes[2] = 3.
 * The third group is [3,4,6]. The size is 3, and groupSizes[3] = groupSizes[4] = groupSizes[6] = 3.
 * Other possible solutions are [[2,1,6],[5],[0,4,3]] and [[5],[0,6,2],[4,3,1]].
 * Example 2:
 * <p>
 * Input: groupSizes = [2,1,3,3,3,2]
 * Output: [[1],[0,5],[2,3,4]]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * groupSizes.length == n
 * 1 <= n <= 500
 * 1 <= groupSizes[i] <= n
 */
public class GroupPeople {

    public static List<List<Integer>> groupThePeople(int[] groupSizes){
//        List<List<Integer>> output = new ArrayList<>();
//
//        for(int i =0; i<groupSizes.length; i++){
//            int check = groupSizes[i];
//            List<Integer> added = new ArrayList<>();
//            if(check!=-1){
//                added.add(i);
//                groupSizes[i] = -1;
//            }
//            for(int j=i+1; j<groupSizes.length; j++){
//                if(groupSizes[j] == check && groupSizes[j]!=-1){
//                    added.add(j);
//                    groupSizes[j] = -1;
//                }
//            }
//            if(!added.isEmpty()){
//                output.add(added);
//            }
//        }
//        return output;

        HashMap<Integer, List<Integer>> groupMapping = new HashMap<Integer, List<Integer>>();

        // Initialize a list to store the final result.
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        // Iterate through the groupSizes array.
        for (int i = 0; i < groupSizes.length; i++) {
            // Get the list of people for the current group size from the mapping.
            List<Integer> currentGroup = groupMapping.getOrDefault(groupSizes[i], new ArrayList<Integer>());

            // Check if the current group is full (size matches the specified group size).
            if (currentGroup.size() == groupSizes[i]) {
                // If the group is full, add it to the result and create a new empty group.
                result.add(currentGroup);
                currentGroup = new ArrayList<Integer>();
            }

            // Add the current person (index 'i') to the current group.
            currentGroup.add(i);

            // Update the mapping with the current group.
            groupMapping.put(groupSizes[i], currentGroup);
        }

        // After processing all people, add the remaining groups to the result.
        for (int size : groupMapping.keySet()) {
            result.add(groupMapping.get(size));
        }

        // Return the final list of groups.
        return result;
    }
    public static void main(String[] args) {
        int[] input = {2,1,3,3,3,2};
        List<List<Integer>> output = groupThePeople(input);
        System.out.println("This is test");
    }
}
