package Interview;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

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

    static Integer getAsci(String str) {
        return str.length();
    }

    public static void main(String[] args) {

//        String[] cmd = new String[1];
//        cmd[0] = "file.java";
//        System.out.println(10 * 20 + "Javatpoint");
//        System.out.println("Javatpoint" + 10 * 20);

//        Process process = Runtime.getRuntime().exec(cmd);

        System.out.println("Test");

        System.out.println("1 - " + LocalDateTime.of(2020, 12, 31, 23, 59, 59).minusYears(1));

        System.out.println("2 - " + LocalDateTime.of(2020, 12, 31, 23, 59, 59).minusYears(1));

        System.out.println("3 - " + LocalDateTime.parse("2019-12-31T23:59").withSecond(59));

        System.out.println("4 - " + LocalDateTime.of(LocalDate.of(2019, 12, 31), LocalTime.MAX));

        System.out.println("5 - " + LocalDateTime.of(2020, 1, 1, 0, 1, 1).minusSeconds(61));

        System.out.println("6 - " + LocalDateTime.parse("2017-12-31T23:59").withYear(2019));

        System.out.println("7 - " + LocalDateTime.of(LocalDate.of(2020, 1, 1), LocalTime.MIDNIGHT).minusSeconds(1));
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


