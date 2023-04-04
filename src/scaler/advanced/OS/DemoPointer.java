package src.scaler.advanced.OS;

public class DemoPointer implements Runnable {

    private void doSomething() {
        System.out.println("Hello4 from " + Thread.currentThread().getName());
    }

    @Override
    public void run() {
        System.out.println("Hello from " + Thread.currentThread().getName());
        doSomething();
    }

    public static class Client {
        public static void main(String[] args) {
            System.out.println("Hello1 from " + Thread.currentThread().getName());
            DemoPointer dp = new DemoPointer();
            //        dp.run();
            Thread t = new Thread(dp);
            t.start();

            System.out.println("Hello2  from " + Thread.currentThread().getName());
        }
    }
}
