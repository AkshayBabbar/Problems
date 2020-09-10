package coreJava.concurrency;

/**
 *   @author: Akshay Babbar
 *   @Purpose: Creating thread using Lambda.
 * */


public class ThreadExample5 {

    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.println("Lambda is running");
            System.out.println("Lambda is finished");
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }
}
