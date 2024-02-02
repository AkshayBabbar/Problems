package src.scaler.core.January30;

import java.util.Iterator;

public class Node implements Iterable<Integer> {
    public int data;
    public Node next;

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     * @return an Iterator.
     */
    @Override
    public Iterator<Integer> iterator() {

        return null;
    }
}
