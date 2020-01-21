/**
 * Created by Akshay Babbar on 21-08-2017.
 */
public class test {

    static int variable = 10;

    static void check(){

        variable = 16;
    }

    public static void main(String[] args) {

        variable = 12;

        check();

        System.out.println(variable);
    }
}
