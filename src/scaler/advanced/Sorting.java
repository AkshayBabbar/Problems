package src.scaler.advanced;

import java.util.ArrayList;
import java.util.Arrays;
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

    public static void swap(ArrayList<Integer> array, int start, int end) {
        int temp = array.get(start);
        array.set(start, array.get(end));
        array.set(end, temp);
    }

    public static void main(String[] args) {
        ArrayList<Integer> first = new ArrayList<>(Arrays.asList(3));
        ArrayList<Integer> second = new ArrayList<>(Arrays.asList(-4, -3));
        ArrayList<Integer> thirdTest = new ArrayList<>(Arrays.asList(8, 16, 80, 55, 32, 8, 38, 40, 65, 18, 15, 45, 50, 38, 54, 52, 23, 74, 81, 42, 28, 16, 66, 35, 91, 36, 44, 9, 85, 58, 59, 49, 75, 20, 87, 60, 17, 11, 39, 62, 20, 17, 46, 26, 81, 92));
        int test = 9;
        findKthSmallest(thirdTest, test);

//        merge(first, second);
    }
}
