package corejava.Interview.beginner;

/**
 * Author: Akshay Babbar
 * Problem: Reverse String - keeping performance in mind (without StringBuffer) in java
 * Condition: Complexity offered by our program to reverse String in java will be O(n/2), where n is number of characters in string in java.
 * Date : 29/4/2020
 * */
public class ReverseString {

    public static String reverseString(String s) {
        char temp;
        char array[] = s.toCharArray();
        if (s.length() == 1) {
            return s;
        }
        if (s.length() == 0) {
            return "Wrong input";
        } else {

            for (int i = 0, j = array.length - 1; i < (array.length) / 2; i++, j--) {
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        return new String(array);
//    return array.toString();
    }


    public static void main(String[] args) {
        String check = "afdgrr";
        System.out.println("Original String is " + check);
        System.out.println("The reversed String would be " + reverseString(check));
    }
}
