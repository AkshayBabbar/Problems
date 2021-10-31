package corejava.Interview.medium;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class CountCharUsingHashMap {
    private static void charCountHashMap(String input) {
//        LinkedHashMap is used just for the insertion order.
        HashMap<Character, Integer> countCharMap = new LinkedHashMap<>();
        char[] charArray = input.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char ch = input.charAt(i);
            if (countCharMap.containsKey(ch)) {
                countCharMap.put(ch, countCharMap.get(ch) + 1);
            } else
                countCharMap.put(ch, 1);
        }

        Iterator<Character> charIterator = countCharMap.keySet().iterator();
        while (charIterator.hasNext()) {
            char ch = charIterator.next();
            System.out.print(ch + "=" + countCharMap.get(ch) + " ");
        }

    }


    public static void main(String[] args) {
        String input = "This is it";
        System.out.println("The Char Count is ");
        charCountHashMap(input);

    }


}
