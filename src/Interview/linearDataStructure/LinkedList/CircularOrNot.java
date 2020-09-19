package Interview.linearDataStructure.LinkedList;

/**
 * @Author: Akshay Babbar
 * @Purpose: Find if the Singly linkedList in circular or not.
 * @Date: 24-01-2020
 */
public class CircularOrNot {

    public static boolean isCircular(Node head) {
        if (head == null) {
            return true;
        }

        Node node = head.next;

        while (node != null && node != head) {
            node = node.next;
        }
        return (node == head);
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(4);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        System.out.println(isCircular(head) ? "This is circular \n" : "This is not circular \n");
    }
}
