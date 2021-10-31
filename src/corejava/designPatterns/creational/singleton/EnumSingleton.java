package corejava.designPatterns.creational.singleton;


/**
 * Author:     Akshay Babbar
 *
 * @Purpose: Enum based singleton implementation. Effective Java 2nd Edition (Joshua Bloch) p. 18
 * This implementation is thread safe, however adding any other method and its thread safety
 * is developers responsibility.
 * /
 */
public enum EnumSingleton {

    INSTANCE;

    public static void doSomething() {

    }
}
