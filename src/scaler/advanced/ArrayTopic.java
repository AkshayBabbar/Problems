package src.scaler.advanced;

import java.util.Arrays;

public class ArrayTopic {

    public static int[] solve(int[] A) {
        int[] output = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 1) {
                output[i] = 1;
            } else {
                output[i] = getCount(A[i]);
            }
        }
        return output;
    }

    public static int getCount(int element) {
        int count[] = new int[element + 1];
        Arrays.fill(count, 2);

        for (int i = 2; i < element; i++) {
            for (int j = 2 * i; j <= element; j += i) {
                count[j]++;
            }
        }
        return count[element];
    }

    public static void main(String[] args) {

        int[] output = solve(new int[]{3, 52, 66, 64, 14, 51, 6, 39, 5, 26, 80, 88, 60, 73, 67, 16, 1, 81, 62, 42, 83, 31, 40, 4, 32, 31, 44, 3, 20, 94, 93, 57, 2, 18, 32, 59, 91, 30, 45});

    }
}
