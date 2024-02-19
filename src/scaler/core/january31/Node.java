package src.scaler.core.january31;


import java.util.Iterator;

public class Node implements Iterable<Node> {
    public int data;
    public Node next;

    public Node(int d) {
        this.data = d;
    }

    public Node(int d, Node n) {
        this.data = d;
        this.next = n;
    }

    @Override
    public Iterator<Node> iterator() {
        return new NodeIterator(this);
    }


    class NodeIterator implements Iterator<Node> {
        private Node head;

        public NodeIterator(Node head) {
            this.head = head;
        }

        @Override
        public boolean hasNext() {
            return this.head != null;
        }

        @Override
        public Node next() {
            Node temp = head;
            head = head.next;
            return temp;
        }
    }
}