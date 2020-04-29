package coreJava.Interview.beginner;

/*
 * Author: Akshay Babbar
 * Purpose:  how to reverse String in java with example, diagram and program by using StringBuffer in java.
 *
 * */
public class ReverseUsingSB {

    public static void main(String... args) {
        String originalString = "abcde"; //String to be reversed
        StringBuffer sb = new StringBuffer(originalString);

        System.out.println("Original String: " + originalString);
        System.out.println("Reversed String: " + sb.reverse());
    }

}
