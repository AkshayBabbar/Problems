package Interview.CollectionDemo;

import java.util.Collection;

public class Collections<T> implements CollectionInterface<T> {

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object O) {
        return false;
    }

    @Override
    public Iterator<T> repeatitor() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<T> e) {
        return false;
    }
}
