package coreJava.Interview.java8;

public interface Formula {

    double calculate(int a);

    default double sqrt(int a) {
        return Math.sqrt(a);
    }

    default long rect(int a, int b) {
        return a * b;
    }

}
