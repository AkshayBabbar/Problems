package src.Interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Akshay Babbar on 21-08-2017.
 */
public class Demo {

    //    static void check(){
//        variable = 16;
//    }
//    private static int x = 10;
//    private static int y = 10;
//    public int b = 9;
//    protected int a = 10;
//
//
//    protected Demo(int a, int b) {
//        this.a = a;
//        this.b = b;
//    }
//
//    private Demo() {
//        this(5);
//    }


//    public static void main(String[] args) {
//
////        variable = 12;
////        check();
//        String s = "abacabad";
//        for (int i = 0; i < s.length(); i++) {
//            if(s.lastIndexOf(i)==s.indexOf(i)){
//                System.out.println(i);
//            }
//        }
//        System.out.println(s.indexOf(s));
//    }

//    private Demo(int x) {
//        this(x, y);
//    }

    public int getSum(int A, int B, ArrayList<Integer> C) {
        int mod = (int) 1e9 + 7;
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> L = new ArrayList<>();
        for (int i = 0; i < A; i++) {
            if (map.containsKey(C.get(i))) {
                map.put(C.get(i), map.get(C.get(i)) + 1);
                if (map.get(C.get(i)) == B) {
                    L.add(C.get(i));
                }
                if (map.get(C.get(i)) > B) {
                    L.remove(C.get(i));
                }
            } else {
                map.put(C.get(i), 1);
                if (map.get(C.get(i)) == B) { // if B==1 ;
                    L.add(C.get(i));
                }
            }
        }
        int N = L.size();
        int sum = 0;
        for (int j = 0; j < N; j++) {
            sum = sum + L.get(j);
        }
        if (N == 0) {
            return -1;
        } // if all elemants are distinct
        else
            return sum % mod;
    }

    static Integer getAscii(String str) {
        return str.length();
    }

    public static int minimumKeypadClickCount(String keyedLetters) {
        if (keyedLetters.length() == 0) {
            return 0;
        } else {
            int count = 0;
            for (int i = 0; i < keyedLetters.length(); i++) {
                count = count + getOptimalCount(keyedLetters.charAt(i));
            }
            return count;
        }
    }

    public static void getShoCode(int n) {

        String[] s = {"afsa", "afsa"};
        s[0].compareTo(s[1]);

        ArrayList<Integer> test = new ArrayList<>();
        Map<Integer, Integer> hMap = new HashMap<>();
        int max = Integer.MAX_VALUE;


        for (int i = 0; i < 2 * n; i++) {
            for (int j = 0; j < 2 * n; j++) {
                int ix = (i < n) ? i : 2 * n - i - 1;
                int jx = (j < n) ? j : 2 * n - j - 1;

                char toBePrinted = (char) ('a' + n - 1 - Math.min(ix, jx));
                System.out.print(toBePrinted + " ");
            }
            System.out.println();

        }
    }

    public static int getOptimalCount(char ch) {
        int count = 0;
        if (ch <= 'i') {
            count = 1;
        } else if (ch > 'i' && ch <= 'r') {
            count = 2;
        } else if (ch > 'r' && ch <= 'z') {
            count = 3;
        }
        return count;
    }

    public static void main(String[] args) {
//        System.out.println(minimumKeypadClickCount("abacadefghibj"));
//            getShoCode(26);


//        String[] cmd = new String[1];
//        cmd[0] = "file.java";
//        System.out.println(10 * 20 + "Javatpoint");
//        System.out.println("Javatpoint" + 10 * 20);

//        Process process = Runtime.getRuntime().exec(cmd);
//
//        System.out.println("Test");
//
//        System.out.println("1 - " + LocalDateTime.of(2020, 12, 31, 23, 59, 59).minusYears(1));
//
//        System.out.println("2 - " + LocalDateTime.of(2020, 12, 31, 23, 59, 59).minusYears(1));
//
//        System.out.println("3 - " + LocalDateTime.parse("2019-12-31T23:59").withSecond(59));
//
//        System.out.println("4 - " + LocalDateTime.of(LocalDate.of(2019, 12, 31), LocalTime.MAX));
//
//        System.out.println("5 - " + LocalDateTime.of(2020, 1, 1, 0, 1, 1).minusSeconds(61));
//
//        System.out.println("6 - " + LocalDateTime.parse("2017-12-31T23:59").withYear(2019));
//
//        System.out.println("7 - " + LocalDateTime.of(LocalDate.of(2020, 1, 1), LocalTime.MIDNIGHT).minusSeconds(1));
//        char ch = c;


    }
//        Demo t = new Demo();
//
//        String s1 = "Java";
//        String s2 = "Java";
//        String s3 = new String("Java");
//
//        System.out.println(s1 == s2);
//        System.out.println(s1 == s3);
//        List list = new ArrayList();
//    }
//
//    protected void add() {
//        System.out.println(a + b);
//    }
//
//    private double Hackr() throws Exception {
//        return 0.7;
//    }
}
