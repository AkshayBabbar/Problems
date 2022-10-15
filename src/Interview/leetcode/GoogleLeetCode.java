package src.Interview.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GoogleLeetCode {

    public static int keyExists(List<String> input, String key) {
        List<String> output = new ArrayList<>();
        if (input.size() == 0) {
            return output.size();
        }
        for (String s : input) {
            int len = s.split(key).length;
            if (len > 0 && len < s.length()) {
                output.add(s);
            }
        }
        return output.size();
    }

    public static void main(String[] args) {
        List<String> test = new ArrayList<>(Arrays.asList("minecraftgame", "intelligent", "innercrafttalent", "knife", "scissor", "stonecrafter"));
        String key = "craft";

        System.out.println(keyExists(test, key));

    }
}
