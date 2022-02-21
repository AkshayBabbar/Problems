package src.corejava.Interview.beginner;

public class StackUse {

    public static void main(String[] args) throws StackEmptyException {
        Stack stack = new Stack(10);

        stack.push(10);
        stack.push(5);
        stack.push(13);
        stack.push(8);
        stack.push(12);
//        int topElement = stack.peek();
        System.out.println("The number at the top is " + stack.peek());

        stack.pop();
        System.out.println("after one Pop operation top is " + stack.peek());

    }
}
