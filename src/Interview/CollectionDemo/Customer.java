package Interview.CollectionDemo;


import java.util.Objects;

@FunctionalInterface
public interface Customer<T> {


    void accept(T t);

    default Customer<T> andThen(Customer<? super T> after) {
        Objects.requireNonNull(after);
        return (T t) -> {
            accept(t);
            after.accept(t);
        };
    }
}


