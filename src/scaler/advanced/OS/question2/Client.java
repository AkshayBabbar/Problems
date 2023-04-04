package src.scaler.advanced.OS.question2;

import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Please give a number");
        int number = scanner.nextInt();

        NumberPrinter np = new NumberPrinter(1);
        for (int i = 1; i <= number; i++) {
            Thread t = new Thread(np);
            t.start();
        }
        System.out.println("Bye from " + Thread.currentThread().getName());
    }
}
