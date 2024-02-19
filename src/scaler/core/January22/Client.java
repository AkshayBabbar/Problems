package src.scaler.core.January22;


import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

//THREAD CALL

//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter the number");
//        Integer integer = scanner.nextInt();
//
//        for (int i = 0; i < integer; i++) {
//            NumberPrinter np = new NumberPrinter(i);
//            Thread thread = new Thread(np);
//            thread.start();
//        }
//        System.out.println(" Bye from " + Thread.currentThread().getName());
//

//         Executor Service
//        Scanner scn = new Scanner(System.in);
//        System.out.println("Please give a number ");
//        int n = scn.nextInt();
//
//        ExecutorService executorService = Executors.newFixedThreadPool(10);
//
//        for (int i = 0; i <= n; i++) {
//            NumberPrinter np = new NumberPrinter(i);
//            executorService.execute(np);
//        }
//
//        System.out.println("Bye from " + Thread.currentThread().getName());
//
//        executorService.shutdown();

        Random r = new Random();
        GreetingsGenerator gg = new GreetingsGenerator(r);

        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<String> promiseOfGreeting = executorService.submit(gg);

        // any code here not depending on greeting

        String greeting = promiseOfGreeting.get(); // blocking call
        System.out.println(greeting);

        // any code depending on greeting

        executorService.shutdown();
    }


}
