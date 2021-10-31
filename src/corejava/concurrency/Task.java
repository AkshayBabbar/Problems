package corejava.concurrency;

public class Task implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
            System.out.println("Current thread is " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
