package src.Interview.hackerranktest.GS.test.collapseString;

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
     * Complete the 'collapseString' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING inputString as parameter.
     */

    public static String collapseString(String inputString) {
        if(inputString.length() <0){
            return "";
        }
        Integer count = 1;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<inputString.length() - 1;i++){
            char curChar = inputString.charAt(i);
            if(curChar ==inputString.charAt(i + 1)){
                count ++;
            }
            if(curChar !=inputString.charAt(i+1)){
                sb = sb.append(count.toString() + curChar);
                count = 1;
            }
        }
        sb = sb.append(count.toString() + inputString.charAt(inputString.length()-1));
        return sb.toString();

    }

}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String inputString = bufferedReader.readLine();

        String result = Result.collapseString(inputString);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
