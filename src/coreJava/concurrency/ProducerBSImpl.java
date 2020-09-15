package coreJava.concurrency;

import java.util.ArrayList;

public class ProducerBSImpl implements Runnable {

    ArrayList<Integer> sharedQueue;

    public ProducerBSImpl() {
        sharedQueue = new ArrayList<Integer>();
    }

    @Override
    public void run() {

        synchronized (this) {
            for (int i = 0; i <= 10; i++) {
                sharedQueue.add(i);

                System.out.println("Producer is still Producing, Produced : " + i);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            System.out.println("Production is over, consumer can consume.");
            this.notify();  //Production is over, notify consumer thread
            //so that consumer can consume.
        }

    }
}
