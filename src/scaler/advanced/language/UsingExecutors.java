package src.scaler.advanced.language;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UsingExecutors {
    public static void main(String[] args) {
        ExecutorService executors = Executors.newFixedThreadPool(5);
        Runnable runnable = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("count : " + i + "\t" + Thread.currentThread().getName());
            }
        };
        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("test");
            }
        };


    }
}
