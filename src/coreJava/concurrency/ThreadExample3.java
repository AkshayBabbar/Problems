package coreJava.concurrency;

/**
 *   @author: Akshay Babbar
 *   @Purpose: Create thread using user defined runnable interface.
 * */

public class ThreadExample3 {
    public static void main(String[] args) {

        Thread thread = new Thread(new MyRunnable());
        thread.start();
    }

    public static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("MyRunnable is running");
            System.out.println("MyRunnable is finished");
        }
    }


}
