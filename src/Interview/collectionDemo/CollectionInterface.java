package Interview.collectionDemo;

/*
 *   Author: Akshay Babbar
 *   Version:    1.0
 *   Date:       13/01/2020
 *   Purpose:    Bucket is here a namesake for Collection Interface just to test waters.
 * */
public interface CollectionInterface<T> extends Iterable<T> {


//    int size();


    boolean isEmpty();

    boolean contains(Object O);


    Iterator<T> repeatitor();

    Object[] toArray();

    <T> T[]toArray(T[] a);

    boolean add(T t);
    boolean remove(Object o);
    boolean containsAll(java.util.Collection<T> e);




}
