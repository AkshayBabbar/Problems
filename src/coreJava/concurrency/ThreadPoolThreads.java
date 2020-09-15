package coreJava.concurrency;

import java.util.concurrent.BlockingQueue;

public class ThreadPoolThreads extends Thread {

    private BlockingQueue<Runnable> taskQueue;
    private ThreadPool threadPool;

    public ThreadPoolThreads(BlockingQueue<Runnable> queue, ThreadPool threadPool) {
        taskQueue = queue;
        this.threadPool = threadPool;
    }

    @Override
    public void run() {
        try {


            while (true) {
                System.out.println(Thread.currentThread().getName() + " is Ready to execute the task");
                Runnable runnable = taskQueue.take();
                runnable.run();
                System.out.println(Thread.currentThread().getName() + " has EXECUTED task.");
                if (this.threadPool.isShutDownInitiation() && this.taskQueue.size() == 0) {
                    this.interrupt();
                    Thread.sleep(1);
                }

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
