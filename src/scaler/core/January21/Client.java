package src.scaler.core.January21;

public class Client {
    public static void main(String[] args) {
        System.out.println(" Hello from " + Thread.currentThread().getName() + " thread.");
        DemoPrinter dp = new DemoPrinter();
        Thread t = new Thread(dp);
        t.start();

    }
}
