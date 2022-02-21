package src.corejava.concurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class ThreadPool {
    private BlockingQueue<Runnable> taskQueue;

    private boolean shutDownInitiation = false;

    public ThreadPool(int nThreads) {

        taskQueue = new LinkedBlockingDeque<>(nThreads);

        for (int i = 1; i <= nThreads; i++) {
            ThreadPoolThreads threadPoolThreads = new ThreadPoolThreads(taskQueue, this);
            threadPoolThreads.setName("Thread -" + i);
            System.out.println("Thread- " + i + " created in ThreadPool");
            threadPoolThreads.start();

        }
    }

    public synchronized void execute(Runnable task) throws Exception {
        if (this.shutDownInitiation) {
            throw new Exception("THreadPool has been shutDown, no further update");
        }
        System.out.println("Task has been added");
        this.taskQueue.put(task);
    }

    public boolean isShutDownInitiation() {
        return shutDownInitiation;
    }

    public synchronized void shutDown() {
        this.shutDownInitiation = true;
        System.out.println("THREADPOOL SHUTDOWN INITIATED !!!!!!!");
    }


}
