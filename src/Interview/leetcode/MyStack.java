package src.Interview.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 225. Implement Stack using Queues
 * Easy
 * 5.4K
 * 1.1K
 * company
 * Google
 * company
 * Amazon
 * company
 * Bloomberg
 * Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).
 * <p>
 * Implement the MyStack class:
 * <p>
 * void push(int x) Pushes element x to the top of the stack.
 * int pop() Removes the element on the top of the stack and returns it.
 * int top() Returns the element on the top of the stack.
 * boolean empty() Returns true if the stack is empty, false otherwise.
 * Notes:
 * <p>
 * You must use only standard operations of a queue, which means that only push to back, peek/pop from front, size and is empty operations are valid.
 * Depending on your language, the queue may not be supported natively. You may simulate a queue using a list or deque (double-ended queue) as long as you use only a queue's standard operations.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input
 * ["MyStack", "push", "push", "top", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 * Output
 * [null, null, null, 2, 2, false]
 * <p>
 * Explanation
 * MyStack myStack = new MyStack();
 * myStack.push(1);
 * myStack.push(2);
 * myStack.top(); // return 2
 * myStack.pop(); // return 2
 * myStack.empty(); // return False
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= x <= 9
 * At most 100 calls will be made to push, pop, top, and empty.
 * All the calls to pop and top are valid.
 * <p>
 * <p>
 * Follow-up: Can you implement the stack using only one queue?
 */

public class MyStack {
    private Queue<Integer> q = new LinkedList<>();

    public MyStack() {

    }

    public void push(int x) {
        if (q.isEmpty()) q.add(x);
        else{
            q.add(x);
            for(int i =0; i<q.size()-1; i++){
                q.add(q.remove());
            }
        }
    }

    public int pop() {
        return q.remove();

    }

    public int top() {
        return q.peek();

    }

    public boolean empty() {
        if(q.size()==0){
            return true;
        }
        return false;

    }

    public static void main(String[] args) {
        MyStack obj = new MyStack();
        obj.push(12);
        int param_2 = obj.pop();
        int param_3 = obj.top();
        boolean param_4 = obj.empty();
    }
}
