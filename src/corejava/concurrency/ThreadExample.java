package src.corejava.concurrency;

public class ThreadExample implements Runnable {
    @Override
    public void run() {
        System.out.println("in run() method");

        for (int i = 0; i < 5; i++) {
            System.out.println("i=" + i + " ,ThreadName = " + Thread.currentThread().getName());
        }
    }
//    public static void main(String[] args) {
//        Thread thread = new Thread();
//        thread.start();
//    }
}
