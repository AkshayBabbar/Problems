package coreJava.Interview.beginner;

public class Stack {


    private int[] data;
    private int nextIndex;

    public Stack(int size) {
        this.data = new int[size];
        this.nextIndex = 0;
    }

    public void pop() throws StackEmptyException {
        if (isEmpty()) {
            StackEmptyException e = new StackEmptyException();
            throw e;
        } else {
            nextIndex--;
            int toBeReturned = data[nextIndex];
            data[nextIndex] = 0;

        }

    }

    public int peek() throws StackEmptyException {
        if (size() == 0) {
            throw new StackEmptyException();
        }
        return data[nextIndex - 1];
    }

    public void push(int element) {
        if (nextIndex == data.length) {
            int[] temp = data;
            data = new int[data.length * 2];
            for (int i = 0; i < temp.length; i++) {
                data[i] = temp[i];
            }
        }
        data[nextIndex] = element;
        nextIndex++;
    }

    public int size() {
        return nextIndex;
    }

    public boolean isEmpty() {
        return size() == 0;

    }
}
