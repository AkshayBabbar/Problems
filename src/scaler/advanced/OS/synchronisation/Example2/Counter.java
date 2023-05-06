package src.scaler.advanced.OS.synchronisation.Example2;

public class Counter {
    int value;

    public synchronized void incrValue(int offset) {
        this.value += offset;
    }
}
