package corejava.concurrency;

/**
 * @author Akshay Babbar
 * @version 1.0
 * Describing why final is thread safe.
 */

public class FinalMTCheck {

    final String string = new String("a");

    public static void main(String[] args) {

    }

    void method() {
//        **    compilation error, s cannot point to new reference.
//        string = "b";compilation error, s cannot point to new reference.
//        **    compilation error, s cannot point to new reference.
    }
}
