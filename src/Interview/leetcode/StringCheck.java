package src.Interview.leetcode;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StringCheck {
    public static final Logger LOGGER = Logger.getLogger(StringCheck.class.toString());

    public static String transform(String input) {

        Map<Character, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < input.length(); i++) {
            if (map.containsKey(input.charAt(i))) {
                map.put(input.charAt(i), map.get(input.charAt(i)) + 1);
            } else {
                map.put(input.charAt(i), 1);
            }
        }
        StringBuilder output = new StringBuilder();

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Character key = (Character) entry.getKey();
            Integer value = (Integer) entry.getValue();
            output.append(key + " ");
            output.append(value.toString());
        }


        return output.toString();
    }

    public static void main(String[] args) {
        LOGGER.log(Level.INFO, "This is output {0} ", transform("a quick brown fox jumps over the lazy dog"));
    }
}
