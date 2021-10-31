package corejava.concurrency;

import java.util.ArrayList;

public class ProducerBusySpin implements Runnable {

    boolean productionInProcess;

    ArrayList<Integer> list;

    public ProducerBusySpin() {
        productionInProcess = true;
        list = new ArrayList<>();
    }

    @Override
    public void run() {
        for (int i = 1; i < 10; i++) {
            list.add(i);
            System.out.println("Producer is still Producing, Produced  : " + i);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            productionInProcess = false;

        }
    }
}
