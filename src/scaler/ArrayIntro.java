package src.scaler;

import java.util.ArrayList;

public class ArrayIntro {

    /**
     * Rotate Array N Times
     */
    public static ArrayList<Integer> rotate(ArrayList<Integer> input, int B) {

        if (B == 0) {
            return input;
        } else {
            int size = input.size();
            ArrayList<Integer> output = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                int index = (i + B) % size;
                output.add(i, input.get(index));
            }
            return output;
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> test = new ArrayList<>();

        test.add(1);
        test.add(2);
        test.add(3);
        test.add(4);
        test.add(5);

        ArrayList<Integer> out = rotate(test, 3);
        for (int i = 0; i < out.size(); i++) {
            System.out.print(out.get(i) + " ");
        }
    }
}
