package src.scaler.advanced.OS.question4;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Please give a number");
        int number = scanner.nextInt();
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 1; i <= number; i++) {
            NumberPrinter np = new NumberPrinter(i);
            executorService.execute(np);
        }
        System.out.println("Bye from " + Thread.currentThread().getName());
        executorService.shutdown();
    }
}
