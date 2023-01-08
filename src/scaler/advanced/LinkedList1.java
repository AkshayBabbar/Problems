package src.scaler.advanced;

public class LinkedList1 {

    public static void main(String[] args) {

    }

    public ListNode removeNthFromEnd(ListNode A, int B) {
        ListNode temp = A;
        int count = 0;
        while (temp.next != null) {
            temp = temp.next;
            count++;
        }
        if (count < B && temp != null && temp.next != null) {
            return A.next;
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
}

