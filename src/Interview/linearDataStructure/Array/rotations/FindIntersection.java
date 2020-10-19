package Interview.linearDataStructure.Array.rotations;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * FindIntersection(strArr) read the array of strings stored in strArr which will contain 2 elements:
 *        the first element will represent a list of comma-separated numbers sorted in ascending order,
 *        the second element will represent a second list of comma-separated numbers (also sorted).
 *  Your goal is to return a comma-separated string containing the numbers that occur in elements of strArr in sorted order.
 *  If there is no intersection, return the string false.
 *
 *       Input: new String[] {"1, 3, 4, 7, 13", "1, 2, 4, 13, 15"}
 *       Output: 1,4,13
 *
 *       Input: new String[] {"1, 3, 9, 10, 17, 18", "1, 4, 9, 10"}
 *       Output: 1,9,10
 * */
public class FindIntersection {

    public static String FindIntersection(String[] strArr) {
        // code goes here
        String sb = null;
        String first = "";
        String second = "";


        first = strArr[0];
        second = strArr[1];

        int size = Math.min(first.length(), second.length());

        Integer count = 1;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < first.length(); i++) {
            if (map.get(first.charAt(i)) == null && first.charAt(i) != ' ')
                map.put(first.charAt(i), 1);
            else
                map.put(first.charAt(i), map.get(first.charAt(i)) + 1);
        }

        for (int j = 0; j < second.length(); j++) {
            if (map.get(second.charAt(j)) == null && second.charAt(j) != ' ')
                map.put(second.charAt(j), 1);
            else
                map.put(second.charAt(j), map.get(second.charAt(j)) + 1);
        }

        System.out.println(map.entrySet());

        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            if (e.getValue() > 1) {
                sb.concat(String.valueOf(e.getValue()));
            }


        }

        if (sb != null) {
            return sb.toString();
        } else return "false";


//            for (int i = 0; i<size;i++){
//                int firstpointer =0;
//                int secondpointer =0;
//
//                if(first.charAt(firstpointer) == second.charAt(secondpointer)){
//                    sb.append(first.charAt(firstpointer));
//                }
//                if(first.charAt(firstpointer)>second.charAt(secondpointer)){
//                    firstpointer++;
//                }
//                if(first.charAt(firstpointer)<second.charAt(secondpointer)){
//                    secondpointer++;
//                }
//            }
//            return sb.toString();


//        System.out.println(first);
//        System.out.println(second);
//            return strArr[0];
    }

    public static void main(String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
//        System.out.print(FindIntersection(s.nextLine()));
    }


}
