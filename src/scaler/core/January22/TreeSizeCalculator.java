package src.scaler.core.January22;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

public class TreeSizeCalculator implements Callable<Integer> {

    Node root;
    ExecutorService executorService;

    public TreeSizeCalculator(Node root, ExecutorService executorService) {
        this.root = root;
        this.executorService = executorService;
    }

    @Override
    public Integer call() throws Exception {
        return null;
    }
}
