package coreJava.concurrency;

public class DriverClass {

    public static void main(String[] args) {
        System.out.println("In main() method");

        ThreadExample threadExample = new ThreadExample();
        Thread thread1 = new Thread(threadExample);
        Thread thread2 = new Thread(threadExample);
        thread1.start();
        thread2.start();
        System.out.println("main() method ends. ");

    }
}
