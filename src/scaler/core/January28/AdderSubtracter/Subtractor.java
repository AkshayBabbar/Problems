package src.scaler.core.January28.AdderSubtracter;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;

public class Subtractor implements Callable {

    private Count count;
    private Lock lock;

    public Subtractor(Count count, Lock lock) {
        this.count = count;
        this.lock = lock;
    }

    public Subtractor(Count count) {
        this.count = count;
    }

    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public Integer call() throws Exception {
        for (int i = 0; i < 10000; i++) {
            lock.lock();
            System.out.println("This is INSIDE SUB LOCK");
            count.value.decrementAndGet();
            lock.unlock();
        }

        return count.value.get();
    }
}
