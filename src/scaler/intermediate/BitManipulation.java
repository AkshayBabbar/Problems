package src.scaler.intermediate;

import java.util.ArrayList;
import java.util.Arrays;

public class BitManipulation {


    public static ArrayList<Integer> uniqueDouble(ArrayList<Integer> input) {
        int result = 0;

        for (int i : input) {
            result ^= i;
        }
        int mask = (result & result - 1) ^ result;
        int first = 0;
        int second = 0;

        for (int i : input) {
            if ((mask & i) == 0) {
                first = first ^ i;
            } else {
                second = second ^ i;
            }
        }
        ArrayList<Integer> output = new ArrayList<Integer>();

        output.add(Math.min(first, second));
        output.add(Math.max(first, second));

        return output;
    }

    public static long reverse(long input) {
        long output = 0L;

        for (int i = 0; i < 32; i++) {

            if ((input & 1) == 1) {
                output++;
            } else {
                input = input >> 1;
                output = output << 1;
            }
        }
        return output;
    }

    public static void main(String[] args) {

        BitManipulation bit = new BitManipulation();
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(186, 256, 102, 377, 186, 377));
        uniqueDouble(input);
        System.out.println(bit.addBinary("1", "1"));
        String check = bit.addBinary("110", "10");
        String test = "1001110001111010101001110";
        System.out.println(check.compareTo(test));
        System.out.println(bit.unsetBits(53L, 5));
        System.out.println(reverse(13));

    }

    public int subArrayOr(int[] A) {
        long ans = 0;
        int mod = 1000000007;
        long n = A.length;
        long total = (n * (n + 1)) / 2;
        for (int i = 0; i < 32; i++) {
            long count = total;
            long prev = 0;
            for (int j = 0; j < A.length; j++) {
                if (((A[j] >> i) & 1) == 0) {
                    count += (prev * (prev + 1)) / 2;
                    prev += 1;
                    count -= (prev * (prev + 1)) / 2;

                } else {
                    prev = 0;
                }
            }
            ans += ((1 << i) * count);

            ans = ans % mod;
        }
        return (int) ans;
    }

    public ArrayList<Integer> grayCode(int a) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        if (a == 1) {
            al.add(0);
            al.add(1);
            return al;
        }
        ArrayList<Integer> temp = new ArrayList<Integer>();
        temp.addAll(grayCode(a - 1));
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < temp.size(); i++) {
            ans.add(temp.get(i));
        }
        for (int i = temp.size() - 1; i >= 0; i--) {
            ans.add(temp.get(i) + (1 << (a - 1)));
        }
        return ans;
    }


    public String addBinary(String A, String B) {
        int len1 = A.length();
        int len2 = B.length();

        StringBuilder stringA = new StringBuilder();
        StringBuilder stringB = new StringBuilder();

        stringA.append(A);
        stringB.append(B);

        if (len1 > len2) {
            for (int i = 0; i < len1 - len2; i++) {
                stringB.insert(i, 0);
            }
        }
        if (len2 > len1) {
            for (int i = 0; i < len2 - len1; i++) {
                stringA.insert(i, 0);
            }
        }
        StringBuilder output = new StringBuilder();

        int carry = 0;
        for (int i = Math.max(len1, len2) - 1; i >= 0; i--) {
            int elementA = stringA.charAt(i) - '0';
            int elementB = stringB.charAt(i) - '0';

            int sum = (elementA + elementB + carry) % 2;
            carry = (elementA + elementB + carry) / 2;

            output.append(sum);
        }
        output.reverse();
        return output.toString();
    }

    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        if (A.size() < 3) {
            return A;
        }

        int xorElement = 0;
        for (Integer integer : A) {
            xorElement = xorElement ^ integer;
        }
        int idx = -1;
        for (int i = 0; i < 32; i++) {
            if ((xorElement & (1 << i)) != 0) {

                idx = i;
                break;
            }
        }

        int xorA = 0;
        int xorB = 0;

        for (Integer integer : A) {
            if ((integer & (1 << idx)) != 0) {
                xorA = xorA ^ integer;
            } else {
                xorB = xorB ^ integer;
            }
        }
        ArrayList<Integer> output = new ArrayList<>();
        output.add(xorA);
        output.add(xorB);
        return output;

    }

    public Long unsetBits(Long input, int unsetNumber) {

        Long ans = input;
        for (int i = 0; i < unsetNumber; i++) {
            if ((input & (1L << i)) == 1) {
                ans -= (1L << i);
            }
        }
        return ans;
    }

}
