package src.corejava.java8;


@FunctionalInterface
public interface TrialOfInterfaces {
    boolean authorize(int val);

    default boolean authorize(String value) {
        return true;
    }

/*
   *    Below Method does not work because of Object Decalration
        default boolean authorize(String value) {
        return true;
    }

    boolean equals(Object o);
}
* */

}