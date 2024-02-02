package src.Interview.collectionDemo;

import src.scaler.core.january31.Node;

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

    Iterator<Node> iterator();
}
