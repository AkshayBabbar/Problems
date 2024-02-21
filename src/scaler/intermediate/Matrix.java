package src.scaler.intermediate;

import java.util.ArrayList;
import java.util.Arrays;

public class Matrix {

    /**
     * You are given two matrices A & B of same size, you have to return another matrix which is the sum of A and B.
     * A = [[1, 2, 3],[4, 5, 6],[7, 8, 9]]
     * B = [[9, 8, 7],[6, 5, 4],[3, 2, 1]]
     * <p>
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

    public ArrayList<ArrayList<Integer>> multiplyMatrix(ArrayList<ArrayList<Integer>> first, ArrayList<ArrayList<Integer>> second) {
        int row = first.size();
        int col = second.get(0).size();

        ArrayList<ArrayList<Integer>> result = initialiseEmptyOutputArray(row, col);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                for (int k = 0; k < first.get(0).size(); k++) {
                    result.get(i).set(j, result.get(i).get(j) + first.get(i).get(k) * second.get(k).get(j));
                }
            }
        }
        return result;
    }

    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> first, ArrayList<ArrayList<Integer>> second) {
        int R1 = first.size(); // number of rows in A
        int C1 = first.get(0).size(); // number of columns in A (assuming all rows have the same length)
        int C2 = second.get(0).size(); // number of columns in B

        // Check if the number of columns in A matches the number of rows in B for multiplication
        if (C1 != second.size()) {
            throw new IllegalArgumentException("Number of columns in A must match number of rows in B");
        }

        // Initialize the result matrix with zeros
        ArrayList<ArrayList<Integer>> result = initialiseEmptyOutputArray(R1, C2);

        // Perform matrix multiplication
        for (int i = 0; i < R1; i++) {
            for (int j = 0; j < C2; j++) {
                // Calculate the element at position (i, j) in the result matrix
                for (int k = 0; k < C1; k++) {
                    result.get(i).set(j, result.get(i).get(j) + first.get(i).get(k) * second.get(k).get(j));
                }
            }
        }

        return result;
    }

    private static ArrayList<ArrayList<Integer>> initialiseEmptyOutputArray(int R1, int C2) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < R1; i++) {
            result.add(new ArrayList<>(C2));
            for (int j = 0; j < C2; j++) {
                result.get(i).add(0);
            }
        }
        return result;
    }

    public ArrayList<ArrayList<Integer>> transpose(ArrayList<ArrayList<Integer>> first) {

        int row = first.size();
        int col = first.get(0).size();
        ArrayList<ArrayList<Integer>> result = initialiseEmptyOutputArray(row, col);

        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                result.get(j).set(i, first.get(i).get(j));
            }
        }
        return result;


    }


    public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> sol = new ArrayList<>();
        int current_row = 0;
        int current_col = 0;
        int newr = 0;
        while (newr < 2 * A.size() - 1) {
            sol.add(new ArrayList<>());
            int row = current_row;
            int col = current_col;
            while (col >= 0 && row < A.size()) {
                sol.get(newr).add(A.get(row).get(col));
                row++;
                col--;
            }
            while (sol.get(newr).size() < A.size()) {
                sol.get(newr).add(0);
            }
            newr++;
            if (current_col + 1 < A.size()) {
                current_col++;
            } else {
                current_row++;
            }
        }
        return sol;
    }


    public int[][] generateMatrix(int A) {
        int[][] matrix = new int[A][A];
        Arrays.fill(matrix, 0);
        int i = 0, j = 0, k = 1;
        int dir = 0;
        while (k <= A * A) {
            matrix[i][j] = k;
            if (dir == 0) {
                j++;
                if (j == A || matrix[i][j] != 0) {
                    dir = 1;
                    j = j - 1;
                    i = i + 1;
                }
            } else if (dir == 1) {
                i++;
                if (i == A || matrix[i][j] != 0) {
                    dir = 2;
                    i = i--;
                    j = j--;
                }
            }
        }
        return matrix;
    }

    public ArrayList<ArrayList<Integer>> generateMatrix(int A, int n) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int rows = A, cols = A;
        int row = 0, col = 0;
        int num = 1;
        int max = A * A;

        // Initialize the matrix with zeros
        for (int i = 0; i < rows; i++) {
            ans.add(new ArrayList<>());
            for (int j = 0; j < rows; j++) {
                ans.get(i).add(0);
            }
        }

        int count = 1;
        while (A > 1) {
            // Top row - right to left
            for (int i = 0; i < A - 1; i++) {
                ans.get(row).set(col, count);
                col++;
                count++;
            }

            // Right column - top to bottom
            for (int i = 0; i < A - 1; i++) {
                ans.get(row).set(col, count);
                row++;
                count++;
            }

            // Bottom row - left to right
            for (int i = 0; i < A - 1; i++) {
                ans.get(row).set(col, count);
                col--;
                count++;
            }

            // Left column - bottom to top
            for (int i = 0; i < A - 1; i++) {
                ans.get(row).set(col, count);
                row--;
                count++;
            }

            // Move inwards for the next spiral
            row++;
            col++;
            A -= 2;
        }

        // If A is 1, place the last element in the center
        if (A == 1) {
            ans.get(row).set(col, count);
        }

        return ans;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(Arrays.asList(1, 2, 3, 6, 7, 8, 9)));
        matrix.add(new ArrayList<>(Arrays.asList(4, 5, 6)));
        matrix.add(new ArrayList<>(Arrays.asList(7, 8, 9)));

        // Create a Solution object
        Matrix solution = new Matrix();

        // Transpose the matrix
        ArrayList<ArrayList<Integer>> transposedMatrix = solution.transpose(matrix);
    }

}
