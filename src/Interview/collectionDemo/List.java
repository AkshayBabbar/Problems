package Interview.collectionDemo;

/**
 * @Author: Akshay Babbar
 * @Version: 1.0
 * @Purpose: This is the mock representation of List Interface.
 * We will try to cover each and every method of List interface and how it will impact arraylist.
 */

public interface List<T> extends CollectionInterface<T> {

    int size();
    boolean isEmpty();
    boolean contains(Object o);
    Iterator<T> repeatitor();
}
