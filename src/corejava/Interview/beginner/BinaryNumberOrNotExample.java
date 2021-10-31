package corejava.Interview.beginner;


/**
 * @Author: Akshay Babbar
 * @Purpose: To find the number is binary or not.
 **/
public class BinaryNumberOrNotExample {

    public static void main(String a[]) {

        int n = 11001011;
        System.out.println(isBinaryNumber(n) ? n + " is binary number." : n + " is not binary number.");
        n = 11001110;
        System.out.println(isBinaryNumber(n) ? n + " is binary number." : n + " is not binary number.");
        n = 10000112;
        System.out.println(isBinaryNumber(n) ? n + " is binary number." : n + " is not binary number.");
        n = 11005110;
        System.out.println(isBinaryNumber(n) ? n + " is binary number." : n + " is not binary number.");
    }

    /**
     * returns true if number is binary.
     */
    public static boolean isBinaryNumber(int n) {
        while (n != 0) {
            if (n % 10 > 1) {
                return false;  //number containing any digit greater than 1 means its not binary.
            }
            n = n / 10;
        }
        return true;
    }


}