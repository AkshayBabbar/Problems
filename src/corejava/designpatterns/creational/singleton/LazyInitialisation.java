package src.corejava.designpatterns.creational.singleton;

/**
 * Author: Akshay Babbar
 *
 * @Purpose: Singleton Design Pattern implementation using Lazy Initialisation.
 * Instance is created only when its get Instance is called otherwise not called.
 * In MT Application though when in lo
 * session.get
 * load
 * op two threads can get different Objects of Singleton.
 * So not recommended.
 */
public class LazyInitialisation {

    private static LazyInitialisation instance;

    private LazyInitialisation() {
    }

    public static LazyInitialisation getInstance() {
        if (instance == null) {
            instance = new LazyInitialisation();
        }
        return instance;
    }
}
