package src.corejava.designPatterns.creational.singleton;


/**
 * Author: Akshay Babbar
 *
 * @Purpose: This class is created for the thread safe implementation of Singleton type.
 * THis is just an addition to the Lazy Initialisation problem solution.
 * The Problem there was that the thread creating the instance and fetching the instance was getting a
 * different instance.
 * Synchronised method here helps us to remove that blockage and thus only one thread will be executed.
 * This reduce the performance and increase the cost as you are stopping parallel processing.
 * THe thread that will be creating the mess will be the initial threads for that what we can do is
 * use <B> DoubleCheckedLocking </B> which will remove the extra overhead.
 * We are checking and synchronising inside method rather than in the method declaration.
 */
public class ThreadSafe {
    private static ThreadSafe INSTANCE;

    private ThreadSafe() {
    }

    private static synchronized ThreadSafe getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ThreadSafe();
        }
        return INSTANCE;
    }

    private static ThreadSafe doubleCheckingLockinggetInstance() {
        if (INSTANCE == null) {
            synchronized (ThreadSafe.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ThreadSafe();
                }
            }
        }
        return INSTANCE;
    }
}
