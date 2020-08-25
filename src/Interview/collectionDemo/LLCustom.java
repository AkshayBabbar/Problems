package Interview.collectionDemo;

public class LLCustom<E> {

    NodeCustom<E> first;
    NodeCustom<E> last;
    private NodeCustom node;
    private int size = 0;
    private int modCount = 0;

    public LLCustom() {
    }

    public void addToLastLL(E item) {
        if (item == null)
            return;
        if (node == null) {
            NodeCustom<E> node = new NodeCustom<E>(item, null, null);
        } else {
            NodeCustom<E> node = new NodeCustom<E>(item, null, last);
            last.next = node;
            size++;
            modCount++;
        }
    }

    public void addToFirstLL(E item) {
        if (item == null)
            return;
        if (node == null) {
            NodeCustom<E> node = new NodeCustom<E>(item, null, null);
        } else {
            NodeCustom<E> node = new NodeCustom<>(item, first, null);
            first.next = node;
            size++;
            modCount++;

        }
    }
}
