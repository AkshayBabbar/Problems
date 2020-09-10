package coreJava.concurrency;

/**
 *   @author: Akshay Babbar
 *   @Purpose: Create a thread using user defined static Thread class.
 * */

public class ThreadExample2 {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
    }

    public static class MyThread extends Thread {
        public void run() {
            System.out.println("MyThread is running");
            System.out.println("MyThread is finished");
        }
    }
}
