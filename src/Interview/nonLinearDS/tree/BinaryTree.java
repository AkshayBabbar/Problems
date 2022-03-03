package src.Interview.nonLinearDS.tree;

import java.util.Stack;

public class BinaryTree {
    Node rootNode;

    public static int sizeOfTree(Node node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + sizeOfTree(node.rightChild)
                    + sizeOfTree(node.leftChild);
        }
    }


    /*
    Question:Write a function to print ZigZag order traversal of a binary tree
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

    /*
    Question :  Given a Binary Tree where all values are from 0 to n-1.
                Construct an ancestor matrix mat[n][n]. Ancestor matrix is defined as below.
                mat[i][j] = 1 if i is ancestor of j
                mat[i][j] = 0, otherwise

    Approach :  The idea is to traverse the tree.
                While traversing, keep track of ancestors in an array.
                When we visit a node, we add it to ancestor array and consider corresponding row in adjacency matrix.
                We mark all ancestors in its row as 1.
                Once a node and all its children are processed, we remove the node from ancestor array.

    Complexity : O(n^2)
     */
    public void ancestorMatrix(Node rootNode, int[][] matrix, int size) {
        if (rootNode == null) {
            return;
        }

        ancestorMatrix(rootNode.leftChild, matrix, size);

        ancestorMatrix(rootNode.rightChild, matrix, size);

        if (rootNode.leftChild != null) {
            matrix[rootNode.data][rootNode.leftChild.data] = 1;
            // iterate through all the columns of children node
            // all nodes which are children to
            // children of root node will also
            // be children of root node
            for (int i = 0; i < size; i++) {
                // if children of root node is a parent
                // of someone (i.e 1) then make that node
                // as children of root also
                if (matrix[rootNode.leftChild.data][i] == 1)
                    matrix[rootNode.data][i] = 1;
            }
        }
        if (rootNode.rightChild != null) {
            matrix[rootNode.data][rootNode.rightChild.data] = 1;
            // iterate through all the columns of children node
            // all nodes which are children to
            // children of root node will also
            // be children of root node
            for (int i = 0; i < size; i++) {
                // if children of root node is a parent
                // of someone (i.e 1) then make that node
                // as children of root also
                if (matrix[rootNode.rightChild.data][i] == 1)
                    matrix[rootNode.data][i] = 1;
            }
        }
    }

    /*

    Question:   Given a binary tree, a complete path is defined as a path from root to a leaf.
                The sum of all nodes on that path is defined as the sum of that path.
                Given a number K, you have to remove (prune the tree) all nodes which don’t lie in any path with sum>=k.

                Note:   A node can be part of multiple paths.
                        So we have to delete it only in case when all paths from it have sum less than K.
    Approach:   The above code can be simplified using the fact that nodes are deleted in bottom up manner.
                The idea is to keep reducing the sum when traversing down.
                When we reach a leaf and sum is greater than the leaf’s data, then we delete the leaf.
                Note that deleting nodes may convert a non-leaf node to a leaf node and if the data for the converted leaf node is less than the current sum, then the converted leaf should also be deleted.
    Complexity: O(n), the solution does a single traversal of given Binary Tree.

     */
    public Node prune(Node rootNode, int sum) {

        if (rootNode == null) {
            return null;
        }
        rootNode.leftChild = prune(rootNode.leftChild, sum - rootNode.data);
        rootNode.rightChild = prune(rootNode.rightChild, sum - rootNode.data);

        //case of Leaf Node
        if (rootNode.rightChild == null && rootNode.leftChild == null && rootNode != null) {
            if (rootNode.data < sum) {
                rootNode = null;
            }
        }
        return rootNode;
    }

    public static void print(Node root) {

        // base case
        if (root == null)
            return;

        print(root.leftChild);
        System.out.print(root.data + " ");
        print(root.rightChild);
    }

    /*
        Question:   Given a Binary Search Tree (BST) and a positive integer k, find the k’th largest element in the Binary Search Tree.
        Approach:   The idea is to do reverse inorder traversal of BST. Keep a count of nodes visited.
                    The reverse inorder traversal traverses all nodes in decreasing order, i.e, visit the right node then centre then left and continue traversing the nodes recursively.
                    While doing the traversal, keep track of the count of nodes visited so far.
                    When the count becomes equal to k, stop the traversal and print the key.

        Time Complexity: O(h + k). The code first traverses down to the rightmost node which takes O(h) time, then traverses k elements in O(k) time.
                        Therefore overall time complexity is O(h + k).
        Auxiliary Space: O(1).

     */

    public int kthLargest(Node rootNode, int kthValue) {
        if (rootNode != null && kthValue == 0) {
            return rootNode.data;
        }
        int count = 0;

        kthLargest(rootNode.rightChild, kthValue);
        count++;

        if (count == kthValue) {
            return rootNode.data;
        }

        kthLargest(rootNode.leftChild, kthValue);
        return -1;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.rootNode = new Node(50);
        tree.rootNode.leftChild = new Node(30);
        tree.rootNode.rightChild = new Node(70);
        tree.rootNode.leftChild.leftChild = new Node(20);
        tree.rootNode.leftChild.rightChild = new Node(40);
        tree.rootNode.rightChild.leftChild = new Node(60);
        tree.rootNode.rightChild.rightChild = new Node(80);

//        System.out.println("ZigZag Order traversal of binary tree is");
        tree.printZigZagTraversal();
        System.out.println();
//
//        System.out.println("This is the size of tree : " + sizeOfTree(tree.rootNode));
//        int size = 8;
//        int[][] matrix = new int[size][size];
//
//        tree.ancestorMatrix(tree.rootNode, matrix, size);
//
//        for (int i = 0; i < size; i++) {
//            for (int j = 0; j < size; j++) {
//                System.out.print(matrix[i][j] + " ");
//            }
//            System.out.println();
//        }

//        tree.prune(tree.rootNode, 9);
        System.out.println(tree.kthLargest(tree.rootNode, 2));
        print(tree.rootNode);
    }
}
