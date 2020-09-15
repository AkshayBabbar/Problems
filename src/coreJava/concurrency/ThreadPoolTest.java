package coreJava.concurrency;

public class ThreadPoolTest {
    public static void main(String[] args) throws Exception {

        ThreadPool threadPool = new ThreadPool(2);
        Runnable task = new Task();
        threadPool.execute(task);
        threadPool.execute(task);

        threadPool.shutDown();
    }
}