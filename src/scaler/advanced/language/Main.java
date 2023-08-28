package src.scaler.advanced.language;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Runnable printThreadName  = () -> System.out.println(Thread.currentThread().getName());

        var threadList = new ArrayList<Thread>();




    }
}
