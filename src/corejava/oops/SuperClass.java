package src.corejava.oops;

public class SuperClass {

    static{
        System.out.println("SuperClass --------------> Static Block");
    }

    {
        System.out.println("SuperClass --------------> Instance Block");
    }
    static int fuction(int a, int b){
        if (b==0){
            return a;
        }
        else {
            return  fuction(b, a%b);
        }
    }

    SuperClass(){
        System.out.println("SuperClass ------------> Constructor");
    }

    public static void main(String[] args) {
        int i=0;
        int sum =0;
        while (i < 100){
            sum = sum +i;
            sum = i + sum;
            i = i+1;

        }
        int ans = fuction(100,2000);
        System.out.println("Sum " + ans);
    }
}
