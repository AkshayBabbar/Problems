package src.scaler.advanced;

import java.util.ArrayList;

public class Utils {

    public static ArrayList<Integer> pfSum(ArrayList<Integer> input) {

        ArrayList<Integer> pfSum = new ArrayList<>();
        if (input.size() < 1) {
            return null;
        }
        pfSum.add(input.get(0));
        for (int i = 1; i < input.size(); i++) {
            pfSum.set(i, pfSum.get(i - 1) + input.get(i));
        }
        String[] temp  = {"Adf","Afa"};
        return pfSum;

    }


}
