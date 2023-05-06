package src.scaler.advanced.OS.synchronisation.Example2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Adder implements Runnable {
    Counter counter;

    public Adder(Counter counter) {

        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            synchronized (counter) {
                this.counter.value += i;
            }
        }
    }
}
