package src.corejava.designpatterns.creational.singleton;

/**
 * Author:     Akshay Babbar
 *
 * @Purpose: Implementation of Bill Pugh Singleton.
 * Prior to Java 5 due to memory model issue of Java, too many threads were trying to fetch singleton class.
 * Now to solve this Bill Pugh implemented inner private static helper class thus removing synch constraints.
 */
public class BillPughImplementation {

    private BillPughImplementation() {
    }

    public static BillPughImplementation getINSTANCE() {
        return SingletonHelper.INSTANCE;
    }

    private static class SingletonHelper {
        private static final BillPughImplementation INSTANCE = new BillPughImplementation();
    }
}
