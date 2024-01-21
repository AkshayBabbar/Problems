package src.scaler.core.January21;

public class DemoPrinter implements Runnable {

    void doSomething() {
        System.out.println("DemoPrinter running......");
    }

    @Override
    public void run() {
        System.out.println("This thread" + Thread.currentThread().getName() +
                " is running from DemoPrinter");
        doSomething();

    }
}
