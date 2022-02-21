package src.corejava.concurrency;

/**
 * @author Akshay Babbar
 * @version 1.0
 * Deadlock example
 */
public class DeadLock {
    public static void main(String[] args) {

        Thread abc = new Thread(new ABC(), "Thread-1");
        Thread def = new Thread(new DEF(), "Thread-2");
        abc.start();
        def.start();

    }
}

class ABC implements Runnable {
    public void run() {
        synchronized (String.class) {
            try {
                Thread.currentThread().getPriority();
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " has acquired lock" +
                    "on String class and waiting to acquire lock on Object Class... ");
        }
        synchronized (Object.class) {
            System.out.println(Thread.currentThread().getName() +
                    " has acquired lock on Object class");
        }


        System.out.println(Thread.currentThread().getName() + " has ENDED");
    }
}

class DEF implements Runnable {
    public void run() {
        synchronized (Object.class) {
            try {
                Thread.currentThread().getPriority();
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " has acquired lock" +
                    "on Object class and waiting to acquire lock on String Class... ");
        }
        synchronized (String.class) {
            System.out.println(Thread.currentThread().getName() +
                    " has acquired lock on String class");
        }


        System.out.println(Thread.currentThread().getName() + " has ENDED");
    }
}
