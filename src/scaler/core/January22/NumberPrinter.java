package src.scaler.core.January22;

public class NumberPrinter implements Runnable {

    private int numberToPrint;

    NumberPrinter(Integer numberToPrint) {
        this.numberToPrint = numberToPrint;
    }

    @Override
    public void run() {
        System.out.println(numberToPrint + " printed by " + Thread.currentThread().getName());
    }
}
