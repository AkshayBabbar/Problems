package src.Interview.collectionDemo;

public class NodeCustom<E> {

    E item;

    NodeCustom<E> next;
    NodeCustom<E> prev;

    public NodeCustom(E item, NodeCustom<E> next, NodeCustom<E> prev) {
        this.item = item;
        this.next = next;
        this.prev = prev;
    }
}
