package src.scaler.intermediate;

public class GCD {

    public static int getGCD(int A, int B) {
        if(A==B){
            return A;
        }
        if(A ==0){
            return B;
        }
        else if(B == 0){
            return A;
        }
        if(A == 1 || B==1){
            return 1;
        }
        else{
            if(A>B){
                return getGCD(A%B,B);
            }
            else{
                return getGCD(A,B%A);
            }
        }
    }
    public String solve(String A, String B) {
        Integer a = Integer.parseInt(A);
        Integer b = Integer.parseInt(B);
        Integer output = getGCD(a,b);
        return output.toString();
    }
    public static void main(String[] args) {


        System.out.println(getGCD(6,4));

    }
}
