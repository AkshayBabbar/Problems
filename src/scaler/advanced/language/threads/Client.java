package src.scaler.advanced.language.threads;

public class Client {

    public static void main(String[] args) {
        HelloWorldPrinterTask task = new HelloWorldPrinterTask();
        Thread t1 = new Thread(task);
        t1.start();
    }
}
