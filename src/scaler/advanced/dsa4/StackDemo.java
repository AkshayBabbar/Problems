package src.scaler.advanced.dsa4;

import java.util.*;

public class StackDemo {


    /**
     * Push the first element in the stack.
     * Pick rest of the elements one by one and follow the following steps in loop
     * Mark the current element as next.
     * If stack is not empty, compare top element of stack with next.
     * If next is greater than the top element, Pop element from stack. Next is the next greater element for the popped element.
     * Keep popping from the stack while the popped element is smaller than next. Next becomes the next greater element for all such popped elements.
     * Finally, push the next in the stack.
     * After the loop in step 2 is over, pop all the elements from stack and print -1 as next element for them.
     * Time Complexity:- O(N)
     *
     * @param A
     * @return
     */
    public static int braces(String A) {
        Deque<Character> stack = new ArrayDeque();
        int strLen = A.length();
        String validOps = "+-*/";
        for (int i = 0; i < strLen; i++) {
            char ch = A.charAt(i);
            if (ch != ')') stack.push(ch);
            else {
                ch = stack.pop();
                boolean isFound = false;

                while (ch != '(') {
                    if (validOps.indexOf(ch) >= 0) isFound = true;
                    ch = stack.pop();
                }

                if (!isFound) return 1;
            }
        }

        return 0;
    }

    public static int bracesTwo(String input) {

        if (input.length() < 1) {
            return 0;
        }

        Stack<Character> stack = new Stack<>();
        boolean flag = false;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(' || input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*' || input.charAt(i) == '/') {
                stack.add(input.charAt(i));
            }
            if (input.charAt(i) == ')') {
                if (input.charAt(i) != '(') {
                    stack.pop();
                } else {
                    flag = true;
                }
            }
            if (flag) {
                return 1;
            }
        }
        return 0;

    }

//    public static ArrayList<Integer> nextGreater(ArrayList<Integer> input) {
//        ArrayList<Integer> output = new ArrayList<>();
//        // Stack is LIFO.
//        // Push the first element in the stack.
//        // Pick rest of the elements one by one and follow the following steps in loop
//        // Mark the current element as next.
//        // If stack is not empty, compare top element of stack with next.
//        // If next is greater than the top element, Pop element from stack. Next is the next greater element for the popped element.
//        // Keep popping from the stack while the popped element is smaller than next. Next becomes the next greater element for all such popped elements.
//        // Finally, push the next in the stack.
//        // After the loop in step 2 is over, pop all the elements from stack and print -1 as next element for them.
//        // Time Complexity:- O(N)
//
//        Stack<Integer> stack = new Stack<>();
//        stack.add(input.get(0));
//        for (int i = 1; i < input.size(); i++) {
//            if(!stack.isEmpty() && stack.peek() < input.get(i)){
//                stack.pop();
////                stack.add()
//            }
//        }
//
//
//        return output;
//    }

    public static ArrayList<Integer> nextGreater(ArrayList<Integer> A) {
        ArrayList<Integer> output = new ArrayList<>(A.size());
        if (A.size() < 2) {
            output.add(-1);
            return output;
        }
        for (Integer i : A) {
            output.add(0);
        }
        int n = A.size();
//        Stack<Integer> stack = new Stack<>();
//        stack.add(A.get(A.size() - 1));
        output.set(n - 1, -1);


        for (int i = n - 2; i >= 0; i--) {
            if (A.get(i) > A.get(i + 1)) {
                if (A.get(i) > output.get(i + 1)) {
                    output.set(i, -1);
                }
                if (A.get(i) < output.get(i + 1)) {
                    output.set(i, output.get(i + 1));
                }

            }
            if (A.get(i) < A.get(i + 1)) {
                output.set(i, A.get(i + 1));
            }
        }
//
//            while (!stack.empty() && A.get(stack.peek()) < A.get(i)) {
//                stack.pop();
//            }
//            if (stack.isEmpty()) {
//                output.set(i, A.get(stack.peek());
//                stack.push(i);
//
//            }
//
//            // Push current element's index onto the stack
//            stack.push(i);
//        }
//        int i = A.size() - 1;
//        while (i > 0 && !stack.isEmpty()) {
//            int curr = A.get(i);
//            int top = stack.peek();
//            if (curr < top) {
//                stack.pop();
//                output.add(top);
//                stack.push(curr);
//                i--;
//            } else {
//                output.add(-1);
//                stack.push(curr);
//                i--;
//            }
//        }
        return output;

    }
    public static int[] nextGreater(int[] A) {
        Stack < Integer > s = new Stack < > ();
        s.push(0);
        int n = A.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        for (int i = 1; i < n; i++) {
            if (s.isEmpty()) {
                s.push(i);
                continue;
            }
            // find the elements whose next greater element is A[i]
            while (!s.isEmpty() && A[s.peek()] < A[i]) {
                ans[s.peek()] = A[i];
                s.pop();
            }
            s.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
//        ArrayList<Integer> TC = new ArrayList<>(Arrays.asList(34, 35, 27, 42, 5, 28, 39, 20, 28));
//        nextGreater(TC);
        ArrayList<Integer> output = new ArrayList<>(Arrays.asList(34, 35, 27, 42, 5, 28, 39, 20, 28));
//        35 42 42 -1 28 39 -1 28 -1

        int[] nextGreater = {34, 35, 27, 42, 5, 28, 39, 20, 28};
        nextGreater(nextGreater);

        ArrayList<Integer> next = nextGreater(output);
        for (Integer i : next) {
            System.out.print(i + " ,");
        }
//        System.out.println(bracesTwo("((a+b))"));

    }
}
