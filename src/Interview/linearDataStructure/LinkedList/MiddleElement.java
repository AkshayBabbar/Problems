package Interview.linearDataStructure.LinkedList;


/**
 * @author Akshay Babbar
 * @version : 1.0
 * Generic method declaration for finding the middle element of the Linked List
 */
public class MiddleElement {
    public static void main(String[] args) {

        Node node = new Node(32);

        try {
            node.push(node, 12);
            node.push(node, 72);
            node.push(node, 45);
            node.push(node, 65);
            node.push(node, 476);
            node.push(node, 41);
// 32,12,72,45,65,476,41
        } catch (LinkedListEmptyException e) {
            e.printStackTrace();
        }

        MiddleElement middleElement = new MiddleElement();
        middleElement.middleElement(node);

    }

    public void middleElement(Node head) {

        Node fastPointer = head;
        Node slowPointer = head;

        if (head != null) {
            while (fastPointer != null && fastPointer.next != null) {
                fastPointer = fastPointer.next.next;
                slowPointer = slowPointer.next;
            }
            System.out.println("Element in the middle is " + slowPointer.data);
        }

    }
}
