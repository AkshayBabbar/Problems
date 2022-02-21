package src.corejava.Interview.medium;

/**
 * Author: Akshay Babbar
 *
 * @Purpose: Create a recursive solution for Pallindrome.
 */
public class RecursivePallindrome {

    public static boolean recursivePallindrome(String input) {
        if (input.length() == 1 || input.length() == 0) {
            return true;
        }
        if (input.charAt(0) == input.charAt(input.length() - 1)) {
            return recursivePallindrome(input.substring(1, input.length() - 1));
        }
        return false;
    }

    public static void main(String[] args) {
        String inputString = "aabaa";
        System.out.println(recursivePallindrome(inputString) ? inputString + " is a palindrome." : inputString + "is not a palindrome.");
    }
}
