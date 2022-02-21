package src.corejava.designPatterns.creational.singleton;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class SerialisationSingleton implements Serializable {
    private static final long serialVersionUID = 1L;

    private static SerialisationSingleton INSTANCE = new SerialisationSingleton();
    private int x;

    private SerialisationSingleton() {

    }

    public static SerialisationSingleton getINSTANCE() {
        return INSTANCE;
    }

    @Override
    public String toString() {
        return "Singleton{x=" + x +
                '}';
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        System.out.println("inside Read Object");
        ois.defaultReadObject();
        INSTANCE = this;
    }

    private Object readResolve() {
        System.out.println("Inside Read Resolve Method");
        return INSTANCE;
    }
}
