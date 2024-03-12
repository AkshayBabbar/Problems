package src.scaler.advanced;

import java.util.*;

public class Trees {

    public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode input) {
        ArrayList<ArrayList<Integer>> output = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> nested = new ArrayList<>();
        queue.add(input);
        while (queue.size() > 1) {
            TreeNode x = queue.poll();
            nested.add(x.val);
            if (x == null) {
                queue.add(null);
                output.add(nested);
                nested = new ArrayList<>();
            }
            if (x != null) {
                if (x.left != null) {
                    queue.add(x.left);
                }
                if (x.right != null) {
                    queue.add(x.right);
                }
            }
        }
        output.add(nested);
        return output;
    }

//        return output;


//        queue.add(A);
//        queue.add(null);
//
//        ArrayList<ArrayList<Integer>> mainList = new ArrayList<ArrayList<Integer> >();
//        ArrayList<Integer> level = new ArrayList<>();
//        while(queue.size() > 1){
//            TreeNode temp = queue.poll();
//
//            if(temp == null){
//                queue.add(null);
//                mainList.add(level);
//                level = new ArrayList<>();
//            }
//
//            if (temp != null){
//                level.add(temp.val);
//
//                if(temp.left != null){
//                    queue.add(temp.left);
//                }
//                if(temp.right != null){
//                    queue.add(temp.right);
//                }
//
//            }
//        }
//        mainList.add(level);
//        return mainList;
//    }

    public TreeNode buildTree(ArrayList<Integer> inOrder, ArrayList<Integer> postOrder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inOrder.size(); i++) {
            map.put(inOrder.get(i), i);
        }
        Stack<Integer> st = new Stack<>();
        st.pop();
        return constructTreeFromPoIn(inOrder, postOrder, 0, postOrder.size() - 1, 0, inOrder.size() - 1, map);
    }

    public TreeNode constructTreeFromPrIn(ArrayList<Integer> preOrder, ArrayList<Integer> inOrder, int prs, int pre, int ins, int ine, HashMap<Integer, Integer> map) {
        if (prs > pre || ins > ine) {
            return null;
        }

        int curr_root = preOrder.get(prs);
        TreeNode root = new TreeNode(curr_root);
        int idx = map.get(curr_root);
        int length = idx - ins;
        root.left = constructTreeFromPrIn(preOrder, inOrder, prs + 1, prs + length, ins, idx - 1, map);
        root.right = constructTreeFromPrIn(preOrder, inOrder, prs + length + 1, pre, idx + 1, ine, map);
        return root;
    }

    public TreeNode constructTreeFromPoIn(ArrayList<Integer> inOrder, ArrayList<Integer> postOrder, int postStart, int postEnd, int inStart, int inEnd, HashMap<Integer, Integer> map) {
        if (postStart > postEnd || inStart > inEnd) {
            return null;
        }

        int curr_root = postOrder.get(postEnd);
        TreeNode root = new TreeNode(curr_root);
        int idx = map.get(curr_root);
        int length = idx - inStart;
        root.left = constructTreeFromPoIn(inOrder, postOrder, postStart, postStart + length - 1, inStart, idx - 1, map);
        root.right = constructTreeFromPoIn(inOrder, postOrder, postStart + length, postEnd - 1, idx + 1, inEnd, map);
        return root;
    }

//    public int kthsmallest(TreeNode A, int B) {
//
//
//    }
//
//    public Stack<> getPath(TreeNode root) {
//
//        if(root==null){
//            return null;
//        }
//
//    }

    public int count(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        if (k == 0) {
            return 1;
        }
        int left = count(root.left, k - 1);
        int right = count(root.right, k - 1);

        return left + right;
    }

    public static void main(StringDemo[] args) {

    }
}
