package src.scaler;

public class StringClass {

    public static String reverse(String input) {
        StringBuilder sb = new StringBuilder(input);
        sb.reverse();
        StringBuilder out = new StringBuilder();
        char[] arr = new char[input.length()];

        int start = 0, end = 0;
        String current = "";
        while (end < input.length()) {
            if (sb.charAt(end) != ' ') {
                end++;
            }
            String reverseString = sb.toString().substring(start, end);
            current = current + reverseToString(reverseString, start, end - 1);
            start = end;
        }
        return current;
    }

    private static String reverseToString(String input, int start, int end) {
        char[] inputArray = input.toCharArray();
        while (start < end) {
            char temp = input.charAt(start);
            inputArray[start] = inputArray[end];
            inputArray[end] = temp;
            start++;
        }
        return new String(inputArray);
    }

    private static String pattern(String input) {

        StringBuilder result = new StringBuilder();

        char[] charArr = new char[2 * input.length()];
        for (int i = 0; i < input.length(); i++) {
            charArr[i] = input.charAt(i);

        }
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) >= 'a' && input.charAt(i) <= 'z') {
                if (input.charAt(i) == 'a' || input.charAt(i) == 'e' || input.charAt(i) == 'i' || input.charAt(i) == 'o' || input.charAt(i) == 'u') {
                    result.append("#");
                } else {
                    result.append(input.charAt(i));
                }
            }
        }
        result.append(result);

        return result.toString();

    }

    public static void main(String[] args) {

        String test = "hgUe";
        System.out.println(pattern(test));
    }
}
