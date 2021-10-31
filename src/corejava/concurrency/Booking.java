package corejava.concurrency;

/**
 * @author Akshay Babbar
 * @version 1.0
 * Synch Ticket Booking mechanism.
 */
public class Booking implements Runnable {
    int ticketsAvailable = 1;

    public void run() {
        System.out.println("Waiting to book ticket for : " + Thread.currentThread().getName());
        synchronized (this) {
            if (ticketsAvailable > 0) {
                System.out.println("Booking Ticket for :  " + Thread.currentThread().getName());

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ticketsAvailable--;
                System.out.println("Ticket BOOKED for : " + Thread.currentThread().getName());
                System.out.println("currently ticketsAvailable = " + ticketsAvailable);
            } else {
                System.out.println("Ticket NOT BOOKED for : " + Thread.currentThread().getName());
            }
        }
    }
}
