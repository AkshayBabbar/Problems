package src.corejava.concurrency;

/**
 *   @author: Akshay Babbar
 *   @Purpose: Create a thread using user defined static Thread class.
 * */

public class ThreadExample2 {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.run();
        System.out.println("This is after run() Method");
        myThread.start();
        System.out.println("This is after start() Method");

    }

    public static class MyThread extends Thread {
        public void run() {
            System.out.println("MyThread is running " + Thread.currentThread().getName());
            System.out.println("MyThread is finished " + Thread.currentThread().getName());
        }
    }
}
