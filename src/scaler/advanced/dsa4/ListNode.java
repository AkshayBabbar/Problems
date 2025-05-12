package src.scaler.advanced.dsa4;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }
    public int getData() {
        return val;
    }

    public void setData(int data) {
        this.val = data;
    }

    public ListNode getNextNode() {
        return next;
    }

    public void setNextNode(ListNode nextNode) {
        this.next = nextNode;
    }

    public void insert(ListNode head,int data){
        ListNode newNode = new ListNode(data);
        if(head == null){
            head = newNode;
        }else {
            ListNode currentNode = head;
            while(currentNode.getNextNode() != null){
                currentNode = currentNode.getNextNode();
            }
            currentNode.setNextNode(newNode);
        }
    }

}
