package src.scaler.advanced.language;

import java.util.ArrayList;

public class FanInFanOut {

    public static void main(String[] args) {
        new FanInFanOutJob(50, 4).run();
    }

    private static class FanInFanOutJob {
        ArrayList<Integer> items;
        ArrayList<Integer> threads;

        public FanInFanOutJob(int count, int threads) {
            this.items = new ArrayList<>(count);
            this.threads = new ArrayList<>(threads);

            for (int i = 1; i <= count; i++) {
                this.items.add(i);
            }
        }

        public void run() {
            int i =0;
        }
    }
}
