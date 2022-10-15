package src.Interview.math;

import java.util.ArrayList;

public class Prime {

    public static int primeSum(int start, int end) {

        ArrayList<Boolean> numberArray = seive(end);

        int sum = 0;
        int init = Math.max(start, 2);
        for (int i = init; i < numberArray.size(); i++) {
            if (Boolean.TRUE.equals(numberArray.get(i))) {
                sum += i;
            }
        }
        return sum;

    }

    private static ArrayList<Boolean> seive(int size) {
        ArrayList<Boolean> numberArray = new ArrayList<>();
        for (int i = 0; i < size + 1; i++) {
            numberArray.add(true);
        }
        for (int i = 2; i * i <= size; i++) {
            if (Boolean.TRUE.equals(numberArray.get(i))) {
                for (int j = i * i; j <= size; j = j + i) {
                    numberArray.set(j, false);
                }
            }
        }
        return numberArray;
    }

    public static void main(String[] args) {
        System.out.println(primeSum(4, 13));

    }
}
