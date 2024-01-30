package src.scaler.core.January28.AdderSubtracter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Client {
    public static void main(String[] args)  throws InterruptedException{

        Count count = new Count();
        count.value.set(0);

        Adder adder = new Adder(count);
        Subtractor subtractor = new Subtractor(count);
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(adder);
        executorService.submit(subtractor);


        executorService.shutdown();
        executorService.awaitTermination(100L,TimeUnit.MINUTES);
        System.out.println("FINAL VALUE IS- " + count.value);

    }
}
