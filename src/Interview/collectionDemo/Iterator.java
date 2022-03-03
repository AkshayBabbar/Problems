package src.Interview.collectionDemo;

import java.util.Objects;

public interface Iterator<T> {

    boolean hasNext();

    T next();

    default void remove() {
        throw new UnsupportedOperationException("Remove");

    }

    default void forEachRemaining(Customer<? super T> action) {
        Objects.requireNonNull(action);
        while (hasNext()) {
            action.accept(next());
        }
    }

}
