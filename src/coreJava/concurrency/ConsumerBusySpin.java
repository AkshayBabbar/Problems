package coreJava.concurrency;

public class ConsumerBusySpin extends Thread {

    ProducerBusySpin producerBusySpin;

    ConsumerBusySpin(ProducerBusySpin producerBusySpin) {
        this.producerBusySpin = producerBusySpin;
    }

    public void run() {
        while (this.producerBusySpin.productionInProcess) {
            System.out.println("BUSY SPIN - Consumer waiting for production to get over.");
/*          productionInProcess is false means production is over,
            consumer will start consuming.
            */

            System.out.println("Production is over, consumer can consume.");
            int productSize = this.producerBusySpin.list.size();
            for (int i = 0; i < productSize; i++)
                System.out.println("Consumed : " + this.producerBusySpin.list.remove(0) + " ");
        }
    }
}
