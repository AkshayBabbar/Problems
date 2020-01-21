package Interview.CollectionDemo;

import java.util.Arrays;

public class ArrayListCustom<E> {

    private static int INITIAL_CAPACITY = 10;
    private Object[] elementData = {};
    private int size = 0;

    public ArrayListCustom() {
        elementData = new Object[INITIAL_CAPACITY];
    }

    private void add(E e) {
        if (size ==elementData.length){
            ensureCapacity();
        }
        elementData[size++] = e;

    }


    /**
     * method returns specific element for specific index.
     */

    public E get(int index) {
//        Negative Scenarios:
//        if index is negative or of greater than the size of array.
//        We throw an exception.

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(" Index: " + index + ", Size " +
                    index);
        }
        return (E) elementData[index]; // return value on Index.
    }

    /**
     * Ensure capacity of custom/your own ArrayList.
     * <p>
     * Method increases capacity of list by making it double.
     */
    private void ensureCapacity() {
        int newIncreasedCapacity = elementData.length * 2;
        elementData = Arrays.copyOf(elementData, newIncreasedCapacity);

    }

    /**
     * remove elements from custom/your own ArrayList method returns
     * <p>
     * removedElement on specific index. else it throws IndexOutOfBoundException
     * if index is negative or greater than size of size.
     */

    public Object remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index);
        }

        Object removeElement = elementData[index];
        for (int i = index; i < size - 1; i++) {
            elementData[i] = elementData[i + 1];
        }
        size--;
        return removeElement;
    }


    /**
     * Display custom/your own ArrayList.
     * <p>
     * Method displays all the elements in list.
     */

    public void Display() {
        System.out.println("The List is : ");

        for (int i = 0; i < size; i++) {
            System.out.println(elementData[i] + " ");

        }
    }


}
