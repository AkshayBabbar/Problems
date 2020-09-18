package coreJava.Interview.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Driver implements Formula {
    public static void main(String[] args) {
        Formula formula = new Formula() {
            @Override
            public double calculate(int a) {
                return sqrt(a * 1000);
            }
        };
        formula.calculate(100);
        formula.sqrt(16);

        List<String> names = Arrays.asList("Test", "anna", "xerbia");
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });

        Collections.sort(names, (a, b) -> b.compareTo(a));

    }

    @Override
    public double calculate(int a) {
        return 0;
    }

}
