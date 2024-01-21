package src.scaler.core.January21;

/**
 * @author akshaybabbar
 * @apiNote :Thread starting
 */
public class Driver {
    public static void main(String[] args) {
        Thread t = new Thread();
        System.out.println("Java Default Thread name " + Thread.currentThread().getName());
        System.out.println("Thread Name is " + t.getName().toLowerCase());
        System.out.println("Thread priority is " + t.getPriority());
        System.out.println("Thread state is " + t.getState());
    }
}
