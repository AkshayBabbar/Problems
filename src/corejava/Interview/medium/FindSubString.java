package corejava.Interview.medium;

import java.util.Scanner;

/**
 * Author: Akshay Babbar
 *
 * @Purpose: Find the user defined Sub String in the String that has been defined.
 */
public class FindSubString {

    public static void main(String[] args) {
        String inputString;
        String searchSubString;
        int index;

        int JavaAPIIndex;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter the Main String.");
        inputString = scanner.nextLine();


        System.out.println("Please enter the String  to be searched for");
        searchSubString = scanner.nextLine();

        JavaAPIIndex = inputString.indexOf(searchSubString);
        System.out.println("From Java API we are getting the index of" + searchSubString + " at " + JavaAPIIndex);
        index = indexSearchedString(inputString, searchSubString);
        System.out.println("The index from the my method is " + index);
    }

    static int indexSearchedString(String wholeString, String searchedText) {
        int index = 0;
        if (searchedText.length() == 0) {
            return -1;
        }
        for (int i = 0; i < wholeString.length(); i++) {
            if (wholeString.charAt(i) == searchedText.charAt(index)) {
                index++;
                if (index == searchedText.length()) {
                    return i - index + 1;
                }
            } else {

                if (index > 0) {
                    index = 0;
                    i--;
                }
            }
        }
        return -1;
    }
}
