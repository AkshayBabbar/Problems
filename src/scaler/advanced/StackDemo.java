package src.scaler.advanced;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Stack;

public class StackDemo {

    public static ArrayList<Integer> nextGreater(ArrayList<Integer> A) {
        ArrayList<Integer> output = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        stack.add(A.get(0));
        int i = 1;
        while (i < A.size()) {
            int element = A.get(i);
            int top = stack.peek();
            if (top > element) {
                output.add(-1);
            } else {
                output.add(element);
                stack.add(element);
            }
        }
        return output;
    }

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

    public static void main(String[] args) {
//        ArrayList<Integer> TC = new ArrayList<>(Arrays.asList(34, 35, 27, 42, 5, 28, 39, 20, 28));
//        nextGreater(TC);
        System.out.println(bracesTwo("((a+b))"));

    }
}
