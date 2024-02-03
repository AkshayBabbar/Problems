package src.scaler.core.feb3;

public class Client {

    public static void main(String[] args) {

        TableGenerator tableGenerator = new TableGenerator(4);
        ScalerThread thread = new ScalerThread(tableGenerator);

        ScalerThread test = new ScalerThread(()-> {
            System.out.println("Printing via lambda " + Thread.currentThread().getName());
        });

        test.start();
        thread.start();
    }
}
