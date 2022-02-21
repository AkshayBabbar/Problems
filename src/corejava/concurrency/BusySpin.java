package src.corejava.concurrency;

public class BusySpin {

    public static void main(String[] args) {
        ProducerBusySpin producerBusySpin = new ProducerBusySpin();
        ConsumerBusySpin consumerBusySpin = new ConsumerBusySpin(producerBusySpin);

        Thread proThread = new Thread(producerBusySpin, "proThread");
        Thread consThread = new Thread(consumerBusySpin, "consThread");

        proThread.start();
        consThread.start();


    }
}
