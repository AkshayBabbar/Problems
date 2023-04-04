package src.scaler.advanced.OS.question5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Random r = new Random();
        GreetingGenerator greetingGenerator = new GreetingGenerator(r);
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        List<Future<String>> listOfGreetingFutures = new ArrayList<>();
        for (int i = 0; i < 99; i++) {
            Future<String> promiseOfGreeting = executorService.submit(greetingGenerator);
            listOfGreetingFutures.add(promiseOfGreeting);
        }

//        for(Future<String> greetingPromises: listOfGreetingFutures){
//            String greeting = greetingPromises.get();
//            System.out.println(greeting);
//        }
    }
}
