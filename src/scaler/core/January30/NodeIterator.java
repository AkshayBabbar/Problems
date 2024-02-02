package src.scaler.core.January30;

import src.Interview.collectionDemo.Iterator;

class NodeIterator implements Iterator<Integer>{
    public Node current ;
    @Override
    public boolean hasNext() {
        return this.current!=null;
    }

    public NodeIterator(Node current) {
        this.current = current;
    }

    @Override
    public Integer next() {
        int data = current.data;
        current = current.next;
        return data;
    }

    /**
     * @return
     */
    @Override
    public Iterator<src.scaler.core.january31.Node> iterator() {
        return null;
    }
}
