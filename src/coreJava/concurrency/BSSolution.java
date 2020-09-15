package coreJava.concurrency;

/**
 * @author Akshay Babbar
 * @version 1.0
 */
public class BSSolution {
    public static void main(String[] args) throws InterruptedException {
        ProducerBSImpl producerBS = new ProducerBSImpl();
        ConsumerBSImpl consumerBS = new ConsumerBSImpl(producerBS);

        Thread prodThread = new Thread(producerBS, "prodThread");
        Thread consThread = new Thread(consumerBS, "consThread");


        consThread.start();
        Thread.sleep(100);
        prodThread.start();
        Thread.sleep(100);

    }
}
