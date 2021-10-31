package corejava.concurrency;

public class ConsumerBSImpl extends Thread {
    final ProducerBSImpl producerBS;

    ConsumerBSImpl(ProducerBSImpl producerBS) {
        this.producerBS = producerBS;
    }

    public void run() {
        /*
         * consumer will wait till producer is producing.
         */
        synchronized (this.producerBS) {  //NO BUSY SPIN

            System.out.println("NO BUSY SPIN, Consumer waiting for production to get over.");
            try {
                this.producerBS.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }


        /*production is over, consumer will start consuming.*/
        int productSize = this.producerBS.sharedQueue.size();
        for (int i = 0; i < productSize; i++)
            System.out.println("Consumed : " + this.producerBS.sharedQueue.remove(0) + " ");

    }
}
