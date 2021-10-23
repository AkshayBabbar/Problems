package Interview.nonLinearDS.tree;

import java.util.Stack;

public class BinaryTree {
    Node rootNode;

    /*
    Approach:
    Assume the two stacks are current: currentlevel and nextlevel.
     We would also need a variable to keep track of the current level order(whether it is left to right or right to left).
     We pop from the currentlevel stack and print the nodes value.
     Whenever the current level order is from left to right, push the nodes left child, then its right child to the stack nextlevel.
     Since a stack is a LIFO(Last-In-First_out) structure, next time when nodes are popped off nextlevel, it will be in the reverse order.
     On the other hand, when the current level order is from right to left, we would push the nodes right child first, then its left child.
     Finally, do-not forget to swap those two stacks at the end of each level(i.e., when current level is empty)
     */

    void printZigZagTraversal() {

        if (rootNode == null) {
            return;
        }
        Stack<Node> currentLevel = new Stack<>();
        Stack<Node> nextLevel = new Stack<>();

        currentLevel.push(rootNode);
        boolean leftToRight = true;

        while (!currentLevel.empty()) {
            Node node = currentLevel.pop();
            System.out.print(node.data + " ");

            if (leftToRight) {
                if (node.leftChild != null) {
                    currentLevel.push(node.leftChild);
                }
                if (node.rightChild != null) {
                    currentLevel.push(node.rightChild);
                }
            } else {
                if (node.rightChild != null) {
                    nextLevel.push(node.rightChild);
                }
                if (node.leftChild != null) {
                    nextLevel.push(node.leftChild);
                }
            }

            if (currentLevel.isEmpty()) {
                leftToRight = !leftToRight;
                Stack<Node> temp = new Stack<>();
                currentLevel = nextLevel;
                nextLevel = temp;
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.rootNode = new Node(1);
        tree.rootNode.leftChild = new Node(2);
        tree.rootNode.rightChild = new Node(3);
        tree.rootNode.leftChild.leftChild = new Node(7);
        tree.rootNode.leftChild.rightChild = new Node(6);
        tree.rootNode.rightChild.leftChild = new Node(5);
        tree.rootNode.rightChild.rightChild = new Node(4);

        System.out.println("ZigZag Order traversal of binary tree is");
        tree.printZigZagTraversal();
    }
}
