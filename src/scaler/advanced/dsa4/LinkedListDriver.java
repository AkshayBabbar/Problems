package src.scaler.advanced.dsa4;

import java.util.LinkedList;

public class LinkedListDriver {

    public  static ListNode reverseBetween(ListNode head, int start, int end) {
        if(start == end) return head;
        int count = end-start;
        ListNode t1 = head;
        int counter = 1;
        while(t1!=null && counter<start){
            t1 = t1.next;
            counter++;
        }
        counter = 1;
        ListNode t2 = t1.next;
        while(t2!=null && counter<=count){
            ListNode temp = t2.next;
            t2.next = t1;
            t1 = t2;
            t2 = temp;
        }

        return t1;

    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.insert(listNode,2);
        listNode.insert(listNode,3);
//        listNode.insert(listNode,4);
//        listNode.insert(listNode,5);


        reverseBetween(listNode,2,3);

    }
}
