package src.Interview.hackerranktest.GS.test.countConnections;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {

    /*
     * Complete the 'countConnections' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY matrix as parameter.
     */

    public static int countConnections(List<List<Integer>> matrix) {
        int row = matrix.size();
        int col = matrix.get(0).size();
        if(row == 0 && col == 0){
            return 0;
        }

        int[][] array = matrix.stream().map(l -> l.stream().mapToInt(Integer::intValue).toArray()).toArray(int[][]::new);

        int count = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(array[i][j] == 1){
                    if (array[i][j] == 1) {
                        if (i - 1 >= 0 && j - 1 >= 0 && array[i - 1][j - 1] == 1) {
                            count = count + 1;

                        }
                        if (i - 1 >= 0 && array[i - 1][j] == 1) {
                            count = count + 1;
                        }
                        if (i - 1 >= 0 && j + 1 < col && array[i - 1][j + 1] == 1) {
                            count = count + 1;
                        }
                        if (j + 1 < col && array[i][j + 1] == 1) {
                            count = count + 1;
                        }
                    }

                }
            }
        }
        return count;
    }

}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int matrixRows = Integer.parseInt(bufferedReader.readLine().trim());
        int matrixColumns = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> matrix = new ArrayList<>();

        IntStream.range(0, matrixRows).forEach(i -> {
            try {
                matrix.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.countConnections(matrix);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
