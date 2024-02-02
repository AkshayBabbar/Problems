package src.scaler.core.feb3;

public class TableGenerator implements Runnable{
    int number;

    public TableGenerator(int number) {
        this.number = number;
    }

    /**
     * Runs this operation.
     */
    @Override
    public void run() {
        for (int i = 0; i <= 10; i++) {
            System.out.println(this.number + " times " + i + " is " + this.number*i);
        }
        System.out.println(Thread.currentThread().getName());
    }
}
