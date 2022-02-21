package src.corejava.Interview.beginner;

import java.util.Scanner;

/**
 * Author: Akshay Babbar*/
public class OddEvenWithoutModulus {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please enter the number which has to be checked. ");
        int number = scanner.nextInt();

        String output = ((number & 1) == 0) ? "even" : "odd";

        System.out.println("The number entered is " + output);

    }
}
