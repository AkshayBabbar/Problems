package src.corejava.Interview.medium;

/**
 * Author: Akshay Babbar
 *
 * @Purpose: Check if the string can be made pallindrome after rotations
 */

public class RotationalPallindrome {

    public static boolean isPalindrome(String input) {
        for (int i = 0; i < (input.length() / 2); i++) {
            if (input.charAt(i) != input.charAt(input.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static boolean rotationPallindromeCheck(String input) {
        boolean flag = false;
        for (int i = 0; i < input.length(); i++) {
            String afterRotationString = rotation(input, i);
            flag = isPalindrome(afterRotationString);
            if (flag) {
                System.out.println("The Pallindrome is " + afterRotationString);
                return true;
            }
        }
        return false;
    }

    //TODO Rotation needs to be checked there is some flaw here.
    public static String rotation(String input, int index) {
        char[] charArray = input.toCharArray();
        int temp[] = new int[index];
        for (int i = 0; i <= index; i++) {
            temp[i] = charArray[i];
        }


        for (int i = index; i < charArray.length - 1; i++) {
            for (int j = 0; j < charArray.length - 1; j++) {
                charArray[i] = charArray[j + 1];
            }
        }
        StringBuffer rotatedString;


        input = new String(charArray);
        System.out.println("The rotated String is " + input);
        return input;
    }

    public static void main(String[] args) {
        String s = "aaaad";
        System.out.println("The string under test is " + s);
        String output = (rotationPallindromeCheck(s)) ? "" : "THe mentioned string is not a pallindrome";
        if (output.length() != 0) {
            System.out.println(output);
        }
    }
}
