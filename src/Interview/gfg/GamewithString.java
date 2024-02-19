package src.Interview.gfg;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Given a string s of lowercase alphabets and a number k, the task is to print the minimum value of the string after removal of k characters. The value of a string is defined as the sum of squares of the count of each distinct character present in the string.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * s = abccc, k = 1
 * Output:
 * 6
 * Explaination:
 * We remove c to get the value as 12 + 12 + 22
 * Example 2:
 * <p>
 * Input:
 * s = aabcbcbcabcc, k = 3
 * Output:
 * 27
 * Explaination:
 * We remove two 'c' and one 'b'. Now we get the value as 32 + 32 + 32.
 * Your Task:
 * You do not need to read input or print anything. Your task is to complete the function minValue() which takes s and k as input parameters and returns the minimum possible required value.
 * <p>
 * Expected Time Complexity: O(n+klog(p))  where n is the length of string and p is number of distinct alphabets and k number of alphabets to be removed.
 * Expected Auxiliary Space: O(n)
 * <p>
 * Constraints:
 * 0 ≤ k ≤ |string length| ≤ 105
 */
public class GamewithString {
    public int minValue(String s, int k){
        int len = s.length();
        if (k >= len){
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i =0; i<len;i++){
            //Freq map done.
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+ 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y)-> y-x);

        for(char key: map.keySet()){
            pq.add(map.get(key));
        }

        while(k>0){
            Integer temp = pq.poll();
            temp--;
            pq.add(temp);
            k--;
        }
        int ans = 0;
        while(!pq.isEmpty()){
            int num = pq.poll();
            ans = ans+(num*num);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        int rem = scanner.nextInt();
        GamewithString gamewithString = new GamewithString();
        int response = gamewithString.minValue(input,rem);
        System.out.println(response);

    }
}
