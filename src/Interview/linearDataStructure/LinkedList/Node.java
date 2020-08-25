package Interview.linearDataStructure.LinkedList;

/*
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

    public void displayNode() {
        System.out.println(data + " ");
    }
}
