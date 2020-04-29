package Interview.CollectionDemo;

public class LinkedListCustom<E> {

    /**
     * Pointer to the first node.
     */
    transient Node<E> first;

    /**
     * Pointer to the first node.
     */
    transient Node<E> last;
    transient int size = 0;

    transient int modificationCount = 0;

    public LinkedListCustom() {

    }

    public void linkFirst(E e) {
        final Node<E> f = first;
        final Node<E> newNode = new Node<>(null, e, f);
        first = newNode;
        if (f == null) {
            last = newNode;
        } else
            f.prev = newNode;
        size++;
        modificationCount++;
    }


    public void linkLast(E e) {
        final Node<E> f = last;
        final Node<E> newNode = new Node<>(last, e, null);

        last = newNode;

        if (last == null) {
            first = newNode;
        } else
            last.next = newNode;
        size++;
        modificationCount++;
    }

    private static class Node<E> {
        E item;
        LinkedListCustom.Node<E> next;
        LinkedListCustom.Node<E> prev;

        Node(LinkedListCustom.Node<E> prev, E element, LinkedListCustom.Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }


}
