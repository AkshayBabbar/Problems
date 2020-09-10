package coreJava.concurrency;


import static java.lang.Thread.sleep;

/**
 * @author: Akshay Babbar
 * @Purpose: This class @Purpose is to pause the thread and throw interrupted Exception for providing interrupts.
 */
public class ThreadExample7 {

    public static void main(String[] args) {
        Runnable runnable = () -> {
            String threadName = Thread.currentThread().getName();

            System.out.println(threadName + " is running.");
//            try{
//                Thread.sleep(1300);
//            }
//            catch (InterruptedException e){
//                e.printStackTrace();
//            }
//            System.out.println(threadName + " is finished.");

            for (int i = 0; i < 5; i++) {
                try {
                    sleep(1000);

                    System.out.println("Running is in the nature.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        };

        Thread thread = new Thread(runnable, "John Wick");
        thread.setDaemon(true);
        thread.start();


        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
