package src.corejava.concurrency;

/**
 *   @author: Akshay Babbar
 *   @Purpose: Create thread using user defined runnable interface.
 * */

public class ThreadExample3 {
    public static void main(String[] args) {
        MyRunnable obj = new MyRunnable();

        Thread thread1 = new Thread(obj, "Thread-1");
        Thread thread2 = new Thread(obj, "Thread-2");

        thread1.start();
        thread2.start();
    }

    public static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " is waiting for lock");
            synchronized (this) {
                try {
                    System.out.println(Thread.currentThread().getName() + " has acquired lock");
                    Thread.sleep(2000); //sleep for 2 seconds
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " has ended");
            }
        }
    }


}
