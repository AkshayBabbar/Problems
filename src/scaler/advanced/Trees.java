package src.scaler.advanced;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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

    public static void main(String[] args) {

    }
}
