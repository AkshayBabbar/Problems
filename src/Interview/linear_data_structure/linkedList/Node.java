package src.Interview.linear_data_structure.linkedList;

/**
 *   @Author:    Akshay Babbar
 *   @Purpose:   Generic Node class which will be used from time to time.*/
public class Node {

    public int data;
    public Node next;
    //    in case of doubly linked list.
    public Node prev;

    public Node(int data) {
        this.data = data;
    }

    public void push(Node prev_node, int data) throws LinkedListEmptyException {
        if (prev_node == null) {
            throw new LinkedListEmptyException("The given node cannot be null");
        }
        Node newNode = new Node(data);
        newNode.next = prev_node.next;

        prev_node.next = newNode;

    }

    public void displayNode() {
        System.out.println(data + " ");
    }
}
