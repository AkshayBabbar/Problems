import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Formatter;
 
/**
* Java program to pad leading zeros into numbers e.g. integer and long in Java
* This method returns a String which contains padded zero.
*
* @author Javin Paul
*/
public class PaddingNumbersInJava{
 
    public static void main(String args[]) {
 
        int quantity = 220;
 
        // %08 means total length of number would be 8
        // if number is of 3 digits, rest of them will
        // be padded by leading zeros.
        String padded = String.format("%08d", quantity);
        System.out.println("Number padded with leading zero : " + padded);
 
        System.out.printf("4 digit number padded with zero to make 6 digit :
                     %06d %n", 4001);
 
        // You can also display hexadecimal number padded by zero
        // just replace %d with %x, as shown below
        System.out.printf("2 digit hexadecimal number padded with zero : 
                      %06x %n", 0xBE);
 
        // Another way to left pad a number is by using DecimalFormat class
        // Below format will make String 6 digit long
        // if number is less than 6 digit long, it will be padded by
        // leading zero.
        DecimalFormat df = new DecimalFormat("000000");
        System.out.println("Number formatted using DecimalFormat" 
                            + df.format(23));
    }
 
}
