package src.scaler.core.January28.AdderSubtracter;

import java.util.concurrent.Callable;

public class Adder implements Callable {
    private Count count;




    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public Integer call() throws Exception {
        for (int i = 0; i <=1000; i++) {
//            count.value +=i;
        }
        return Integer.valueOf(1);
    }
}
