package src.Interview;

import java.io.*;

class Solution {
    public static boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static String sumStr(String input1, String input2) {
        int len1 = input1.length();
        int len2 = input2.length();
        String str = "";
        int diff = 0;
        int mx = 0;
        if (len1 > len2) {
            mx = 1;
        }
        if (len2 > len1) {
            mx = 2;
        }
        if (len2 == len1) {
            mx = 0;
            diff = 0;
        }
        if (mx == 2) {
            diff = len2 - len1;
        } else {
            diff = len1 - len2;
        }
        int carry = 0;
        if (mx == 2) {
            for (int i = len1 - 1; i >= 0; i--) {
                int sum = (int) (input1.charAt(i) - '0') + (int) (input2.charAt(i + diff) - '0') + carry;
                str += sum % 10;// str += sum % 10
                System.out.println("sum" + sum);
                carry = sum / 10;
            }
            // for remaining 0s.
            for (int i = diff; i > 0; i--) {
                int sum = (int) (input2.charAt(i) - '0') + carry;
                str += sum % 10;
                System.out.println("sum" + sum);
                carry = sum / 10;
            }
            if (carry > 0) {
                str += carry;
            }

        }
        if (mx == 1) {
            for (int i = len2 - 1; i >= 0; i--) {
                int sum = (int) (input1.charAt(i + diff) - '0') + (int) (input2.charAt(i) - '0') + carry;
                str += (char) sum % 10;
                carry = sum / 10;
            }
            // for remaining 0s.
            for (int i = diff; i > 0; i--) {
                int sum = (int) (input1.charAt(i) - '0') + carry;
                str += (char) sum % 10;
                carry += sum / 10;
            }
            if (carry > 0) {
                str += carry;
            }

        } else {
            for (int i = len1 - 1; i >= 0; i--) {
                int sum = (int) (input1.charAt(i) - '0') + (int) (input2.charAt(i) - '0') + carry;
                str += sum % 10;// str += sum % 10
                carry = sum / 10;

            }
            if (carry > 0) {
                str += carry;
            }

        }
        return new StringBuilder(str).reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println("Hello, World");
        // for(int i =2; i<100;i++){
        //     if(isPrime(i)){
        //         System.out.println(i);
        //     }
        // }
        // // Print prime number between 2 - 100 (Use minimum % or / operation)

        // Given 2 very long number strings, return sum of these 2 number
// Example
// String a 		= "100000000000000000000000000001"
// String b 		= "100000000000000000000000000002"
// Expected result  = "200000000000000000000000000003"
// Please try to cover all possible input
// Don't parse whole string to one number variable e.g. don't use int.Parse(a)
// Don't use BigInteger

        System.out.println(sumStr("999", "9999")); // 1998


//1100000000000000000000000000001
// 100000000000000000000000000002
    }
}
