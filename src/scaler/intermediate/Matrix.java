package src.scaler.intermediate;

import java.util.ArrayList;

public class Matrix {

    /**
     * You are given two matrices A & B of same size, you have to return another matrix which is the sum of A and B.
     * A = [[1, 2, 3],[4, 5, 6],[7, 8, 9]]
     * B = [[9, 8, 7],[6, 5, 4],[3, 2, 1]]
     *
     * [[10, 10, 10], [10, 10, 10], [10, 10, 10]]
     * A + B = [[1+9, 2+8, 3+7],[4+6, 5+5, 6+4],[7+3, 8+2, 9+1]] = [[10, 10, 10], [10, 10, 10], [10, 10, 10]].
     *
     * @param first
     * @param second
     * @return
     */
    public static ArrayList<ArrayList<Integer>> sum(ArrayList<ArrayList<Integer>> first, ArrayList<ArrayList<Integer>> second) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

            int row = first.size();
            int col = first.get(0).size();

            for (int i = 0; i < row; i++) {
                ArrayList<Integer> temp = new ArrayList<>();
                for (int j = 0; j < col; j++) {

                    temp.add(j, first.get(i).get(j) + second.get(i).get(j));
                }
                result.add(i, temp);
            }
            return result;
    }

//    public static ArrayList<ArrayList<Integer>> transpose(ArrayList<ArrayList<Integer>> first, ArrayList<ArrayList<Integer>> second) {
//
//        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
//    }

    public static void main(String[] args) {

    }
}
