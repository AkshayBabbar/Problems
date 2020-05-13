package coreJava.designPatterns.singleton;

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
