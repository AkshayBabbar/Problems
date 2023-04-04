package src.scaler.advanced.OS.question2;

public class NumberPrinter implements Runnable {
    private int numberToPrint;


    public NumberPrinter(int numberToPrint) {
        this.numberToPrint = numberToPrint;
    }

    @Override
    public void run() {
        System.out.println(numberToPrint + "number to be printed by " + Thread.currentThread().getName());
        numberToPrint++;
    }
}
