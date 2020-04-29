package coreJava.Interview.beginner;
/*
 * Author: Akshay Babbar
 * Purpose: Change the case of String Entered.
 *  */


public class ChangeStringCharactersCaseExample {
    public static void main(String args[]) {
        String inputString = "Java Made So Easy";
        System.out.println("input String : " + inputString);
        System.out.println("output    : " + changecase(inputString));

    }

    /**
     * method returns changed cases of characters in String.
     */
    static String changecase(String inputString) {
        char ar[] = inputString.toCharArray();

        for (int i = 0; i < ar.length; i++) {

            if (ar[i] >= 65 && ar[i] <= 90) { //convert upperCase to lowerCase
                ar[i] += 32;
            } else if (ar[i] >= 97 && ar[i] <= 122) {  //convert lowerCase to upperCase.
                ar[i] -= 32;
            }

        }
        return new String(ar);
    }


}