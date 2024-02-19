package src.corejava.java8;

import java.util.function.Consumer;

public class DemoJava8 {
    public static void main(String[] args) {
        Consumer<String> consumer= (a) -> {
            System.out.println("this is test " + a);
        };
        consumer.accept("Checking for consumer");
    }
}
