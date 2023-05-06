package src.scaler.advanced.OS.synchronisation.Example2;

import java.util.concurrent.locks.Lock;

public class Subtractor implements Runnable {
    Counter counter;

    public Subtractor(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            this.counter.incrValue(-i);

        }
    }
}
