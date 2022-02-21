package src.corejava.concurrency;

public class NotThreadSafe extends Thread {

    StringBuilder builder = new StringBuilder();

    public static void main(String[] args) {
        NotThreadSafe notThreadSafe = new NotThreadSafe();
        notThreadSafe.start();
    }

    public void run() {
        System.out.println("This is run() method");
    }

    public void add(String text) {
        this.builder.append(text);
    }
}