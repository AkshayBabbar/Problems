package coreJava.Interview.beginner;

public enum EnumTest {
    AN("Ankit"),
    AS("Ashish");

    private final String name;

    private EnumTest(String s) {
        name = s;
    }

    public String toString() {
        return this.name;
    }
}
