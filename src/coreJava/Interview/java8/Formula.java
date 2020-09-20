package coreJava.Interview.java8;

public interface Formula {

    double calculate(int a);

    static double sqrt(int a) {
        return Math.sqrt(a);
    }

    static long rect(int a, int b) {
        return a * b;
    }

}
