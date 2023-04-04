package src.scaler.advanced.OS.question5;

import java.util.Random;
import java.util.concurrent.Callable;

public class GreetingGenerator implements Callable<String> {

    private Random random;

    public GreetingGenerator(Random random) {
        this.random = random;
    }

    @Override
    public String call() throws Exception {
        int num = random.nextInt(5);
        if (num == 1) {
            return "Hello From" + Thread.currentThread().getName();
        }
        if (num == 2) {
            return "Hi From" + Thread.currentThread().getName();
        }
        if (num == 3) {
            return "Hola From" + Thread.currentThread().getName();
        }
        if (num == 4) {
            return "Namaste From" + Thread.currentThread().getName();
        } else {
            return "No Greeting";
        }
    }
}
