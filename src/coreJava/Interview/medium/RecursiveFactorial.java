package coreJava.Interview.medium;

public class RecursiveFactorial {
    public static int factorial(int input) {
        if (input == 0) {
            return 1;
        }
        return input * factorial(input - 1);

    }

    public static void main(String... args) {
        int num = 4;
        System.out.println("Factorial of " + num + " is: " + factorial(num));
    }

}
