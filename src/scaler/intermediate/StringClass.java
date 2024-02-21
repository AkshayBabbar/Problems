package src.scaler.intermediate;

import java.util.*;

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
            String reverseString = sb.substring(start, end);
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

    public static int checkBOB(String A) {
        int start = 0;
        int end = 2;
        int count=0;

        while(end!=A.length()-1){
            if(A.charAt(start) == 'b' && A.charAt(start+1) == 'o' && A.charAt(end) == 'b'){
                count++;
                start +=2;
                end+=2;
            }
            start++;
            end++;
        }
        return count;

    }
    public static void main(String[] args) {

        String test = "umeaylnlfd";
//        System.out.println(swapCharacer(test,1));

    }

//    public static int swapCharacer(String input, int maximumSwaps) {
//        int[] freqArray = new int[26];
//        int distinct = 0;
//
//        Arrays.fill(freqArray,0);
//
//        for(int i =0; i<input.length();i++){
//            freqArray[input.charAt(i) -97]++;
//        }
//        Arrays.sort(freqArray);
//        int remove =0;
//        while(maximumSwaps < 0){
//            int min = 0;
//            int index = 0;
//            for(int i =0; i<26;i++){
//
//            }
//        }
//    }


}
