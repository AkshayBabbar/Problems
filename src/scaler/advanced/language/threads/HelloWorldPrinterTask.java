package src.scaler.advanced.language.threads;

public class HelloWorldPrinterTask implements Runnable {
    @Override
    public void run() {
        System.out.println(" Hello World " + Thread.currentThread().getName());
    }
}
