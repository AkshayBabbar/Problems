package src.scaler.intermediate;

public class ModMultiplication {
    public static int power(long A, long fact, long mod) {
        long ans = 1;
        while (fact > 0) {
            if ((1 & fact) == 1) {
                ans = ((ans * A) % mod);
            }
            A = ((A % mod * A % mod) % mod);
            fact = fact >> 1;
        }
        return (int) (ans % mod);
    }

    public static int largePower(int A, int B) {
        long fact = 1;
        long mod = 1000 * 1000 * 1000 + 7;

        for (int i = 2; i <= B; i += 1) {
            fact = (fact * i) % (mod - 1);
        }
        int ans = power(A, fact, mod);
        return ans;
    }


    public static void main(String[] args) {
        int A = 8;
        int B = 2;
        System.out.println(largePower(A, B));
    }
}
