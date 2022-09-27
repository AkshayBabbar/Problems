package src.scaler.advanced;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sorting {

    public static ArrayList<Integer> merge(final List<Integer> A, final List<Integer> B) {

        int maxSize = Math.max(A.size(), B.size());

        ArrayList<Integer> output = new ArrayList<>(maxSize);

        int minSize = Math.min(A.size(), B.size());

        int p1 = 0;
        int p2 = 0;
        int i = 0;
        while (p1 < A.size() && p2 < B.size()) {
            if (A.get(p1) >= B.get(p2)) {
                output.add(i, B.get(p2));
                p2++;
                // continue;
            } else {
                output.add(i, A.get(p1));
                p1++;
                // continue;
            }
            i++;
        }
        while (p1 < A.size()) {
            output.add(i, A.get(p1));
            p1++;
            i++;
        }
        while (p2 < B.size()) {
            output.add(i, B.get(p2));
            p2++;
            i++;
        }
        return output;
    }

    public static int findKthSmallest(final List<Integer> array, int B) {
        int n = array.size();
        ArrayList<Integer> output = new ArrayList<>(array);
        for (int i = 0; i < B; i++) {
            int index = i;
            int min = Integer.MAX_VALUE;
            for (int j = i; j < n; j++) {

                if (output.get(j) < min) {
                    min = output.get(j);
                    index = j;
                }
            }
            swap(output, i, index);
        }
        if (B <= array.size()) {
            return output.get(B - 1);
        } else {
            return -1;
        }
    }

    /**
     * Problem Description
     * You are given an array A of N elements. You have to make all elements unique. To do so, in one step you can increase any number by one.
     * <p>
     * Find the minimum number of steps.
     * <p>
     * <p>
     * <p>
     * Problem Constraints
     * 1 <= N <= 105
     * 1 <= A[i] <= 109
     * <p>
     * <p>
     * <p>
     * Input Format
     * The only argument given is an Array A, having N integers.
     * <p>
     * <p>
     * <p>
     * Output Format
     * Return the minimum number of steps required to make all elements unique.
     * <p>
     * <p>
     * <p>
     * Example Input
     * Input 1:
     * <p>
     * A = [1, 1, 3]
     * Input 2:
     * <p>
     * A = [2, 4, 5]
     * <p>
     * <p>
     * Example Output
     * Output 1:
     * <p>
     * 1
     * Output 2:
     * <p>
     * 0
     * <p>
     * <p>
     * Example Explanation
     * Explanation 1:
     * <p>
     * We can increase the value of 1st element by 1 in 1 step and will get all unique elements. i.e [2, 1, 3].
     * Explanation 2:
     * <p>
     * All elements are distinct.
     *
     * @param input
     * @return
     */

    public static int getUniqueElementStepCount(ArrayList<Integer> input) {
        Collections.sort(input);
        int count = 0;
        for (int i = 0; i < input.size() - 1; i++) {
            if (input.get(i) < input.get(i + 1)) {
                continue;
            } else {
                if (input.get(i).equals(input.get(i + 1))) {
                    count++;
                    input.set(i + 1, input.get(i) + 1);
                }

                if (input.get(i) > input.get(i + 1)) {
                    count += input.get(i) - input.get(i + 1) + 1;
                    input.set(i + 1, input.get(i) + 1);
                }
            }
        }
        return Math.max(count, 0);

    }

    public static void swap(ArrayList<Integer> array, int start, int end) {
        int temp = array.get(start);
        array.set(start, array.get(end));
        array.set(end, temp);
    }

    public static void main(String[] args) {
        ArrayList<Integer> first = new ArrayList<>(Arrays.asList(3));
        ArrayList<Integer> second = new ArrayList<>(Arrays.asList(-4, -3));
        ArrayList<Integer> thirdTest = new ArrayList<>(Arrays.asList(8, 16, 80, 55, 32, 8, 38, 40, 65, 18, 15, 45, 50, 38, 54, 52, 23, 74, 81, 42, 28, 16, 66, 35, 91, 36, 44, 9, 85, 58, 59, 49, 75, 20, 87, 60, 17, 11, 39, 62, 20, 17, 46, 26, 81, 92));
        ArrayList<Integer> fourthTest = new ArrayList<>(Arrays.asList(121, 839, 643, 713, 837, 39, 273, 130, 400, 864, 415, 2, 19, 291, 117, 812, 617, 185, 160, 597, 542, 555, 231, 49, 600, 543, 233, 847, 350, 392, 572, 592, 415, 282, 190, 608, 501, 491, 880, 579, 47, 258, 977, 593, 282, 491, 77, 532, 987, 309, 999, 740, 735, 322, 823, 149, 514, 874, 558, 7, 178, 964, 38, 227, 927, 299, 262, 914, 622, 675, 490, 355, 154, 392, 957, 703, 217, 648, 758, 456, 433, 119, 784, 563, 876, 700, 851, 698, 126, 406, 266, 150, 746, 883, 369, 859, 717, 848, 160, 98, 869, 58, 792, 172, 80, 974, 522, 738, 159, 407, 917, 397, 458, 687, 838, 506, 83, 116, 967, 779, 698, 877, 739, 321, 573, 257, 716, 413, 57, 135, 342, 860, 17, 820, 675, 182, 752, 674, 62, 43, 127, 412, 663, 81, 494, 399, 586, 48, 78, 498, 802, 201, 164, 332, 371, 540, 677, 754, 321, 195, 952, 334, 801, 628, 486, 455, 520, 164, 259, 616, 326, 339, 202, 711, 62, 443, 696, 633, 591, 507, 26, 853, 402, 359, 363, 177, 489, 484, 537, 630, 381, 253, 184, 438, 925, 635, 219, 168, 880, 2, 65, 253, 923, 30, 775, 206, 382, 436, 844, 904, 556, 144, 329));
        int test = 9;
        System.out.println(getUniqueElementStepCount(fourthTest));

//        findKthSmallest(thirdTest, test);


//        merge(first, second);
    }
}
