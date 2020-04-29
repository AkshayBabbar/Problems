package coreJava.Interview.beginner;

import java.util.Scanner;

/*
 * Author: Akshay Babbar
 * Purpose: Find sum of digits in number in java.
 */
public class SumOfDigits {
    public static int sumOfDigits(int test) {
        int sum = 0;
        int remainder;

        for (int i = 0; i < test; i++) {

            remainder = test % 10;
            test = test / 10;
            sum = sum + remainder;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the digits.");
        int check = scanner.nextInt();

        System.out.println("The sum of the digits of " + check + " is " + sumOfDigits(check));
    }

}
