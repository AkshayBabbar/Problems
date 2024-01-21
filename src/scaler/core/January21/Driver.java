package src.scaler.core.January21;

public class Driver {
    public static void main(String[] args) {
        Thread t = new Thread();
        System.out.println("Thread Name is " + t.getName().toLowerCase());
        System.out.println("Thread priority is " + t.getPriority());
        System.out.println("Thread state is " + t.getState());
    }
}
