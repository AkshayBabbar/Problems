package src.scaler.advanced;

import src.scaler.advanced.dsa4.ListNode;

import java.util.LinkedList;

public class LinkedList1 {

    public static void main(StringDemo[] args) {
        ListNode listNode = new ListNode(1);


    }

    public ListNode removeNthFromEnd(ListNode A, int B) {
        ListNode temp = A;
        int count = 0;
        if (count < B && temp != null && temp.next != null) {
            return A.next;
        }
        while (temp.next != null) {
            temp = temp.next;
            count++;
        }


        int element = count - B;
        if (element == 1 && count == 1) {
            return null;
        }
        if (element == 0 && count > 0) {
            return temp.next;
        }
        count = 0;
        temp = A;

        while (temp != null && element > 1) {
            temp = temp.next;
            element--;
        }
        if (temp != null && temp.next != null) {
            temp.next = temp.next.next;
        }
        return temp;
    }
    public  static ListNode reverseBetween(ListNode head, int start, int end) {
        if(start==end || (start==1 && end==1)) return head;
        int count = end-start;
        ListNode t1 = head;
        int counter = 1;
        while(t1!=null && counter<start){
            t1 = t1;
        }
        counter = 1;
        ListNode t2 = t1.next;
        while(t2!=null && counter<count){
            ListNode temp = t2.next;
            t2.next = t1;
            t1 = t2;
            t2 = temp;
        }

        return head;

    }
}

