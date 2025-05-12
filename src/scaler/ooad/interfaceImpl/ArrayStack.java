package src.scaler.ooad.interfaceImpl;

public class ArrayStack<T> implements StackInterface<T> {

    private static int DEFAULT_CAPACITY = 10;
    private T[] elements;
    private int top;

    @SuppressWarnings("unchecked")
    public ArrayStack() {
        elements = (T[]) new Object[DEFAULT_CAPACITY];
        top = -1;
    }

    @SuppressWarnings("unchecked")
    public ArrayStack(int initialCapacity) {
       if(initialCapacity<0){
           throw new IllegalArgumentException(" Initial capacity cannot be negative ");
       }
       elements = (T[]) new Object[initialCapacity];
       top = -1;
    }


    /**
     * Pushes an element onto the top of the stack.
     *
     * @param element the element to be pushed onto the stack
     */
    @Override
    public void push(T element) {
        ensureCapacity();
        elements[++top] = element;
    }

    /**
     * Removes and returns the element at the top of the stack.
     *
     * @return the element at the top of the stack
     * @throws EmptyStackException if the stack is empty
     */
    @Override
    public void pop() {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        T element = elements[top];
        elements[top--] = null;
    }

    @Override
    public int size() {
        return top + 1;
    }

    /**
     * Returns the element at the top of the stack without removing it.
     *
     * @return the element at the top of the stack
     * @throws EmptyStackException if the stack is empty
     */
    @Override
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return elements[top];
    }

    /**
     * Checks if the stack is empty.
     *
     * @return true if the stack contains no elements, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return top == -1;
    }
    /**
     * Ensures that the array has capacity for at least one more element.
     * If not, it doubles the capacity.
     */
    @SuppressWarnings("unchecked")
    private void ensureCapacity(){
        if(top == elements.length - 1){
            int newCapacity = elements.length * 2;
            T[] newElements = (T[]) new Object[newCapacity];
            System.arraycopy(elements, 0, newElements, 0, elements.length);
            elements = newElements;
        }

    }
    public int getCapacity() {
        return elements.length;
    }

}