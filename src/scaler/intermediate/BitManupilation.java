package src.scaler.intermediate;

import java.util.ArrayList;

public class BitManupilation {

    /**
     * Given an array of positive integers A, two integers appear only once, and all the other integers appear twice.
     * Find the two integers that appear only once.
     * <p>
     * Note: Return the two numbers in ascending order.
     * <p>
     * 2 <= |A| <= 100000
     * 1 <= A[i] <= 109
     * <p>
     * Example Input
     * Input 1:
     * A = [1, 2, 3, 1, 2, 4]
     * Input 2:
     * <p>
     * A = [1, 2]
     * <p>
     * <p>
     * Example Output
     * Output 1:
     * [3, 4]
     * Output 2:
     * <p>
     * [1, 2]
     *
     * @param ArrayList<Integer>
     */

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
//    void printSum(){
//        System.out.println(number);
//    }

    public static void recusrion(int number) {
        if (number > 0) {
            System.out.print(number);
            recusrion(number - 1);
        }
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

    public String addBinary(String A, String B) {
        int len1 = A.length();
        int len2 = B.length();

        StringBuffer stringA = new StringBuffer();
        StringBuffer stringB = new StringBuffer();

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
        StringBuffer output = new StringBuffer();

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

    public static void main(String[] args) {

        BitManupilation bit = new BitManupilation();
//        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(186, 256, 102, 377, 186, 377));
//        uniqueDouble(input);
//        System.out.println(bit.addBinary("1", "1"));
        String check = bit.addBinary("110", "10");
//        String test = "1001110001111010101001110";
//        System.out.println(check.compareTo(test));

//        System.out.println(bit.unsetBits(53L, 5));
//        Integer test = 100;
        System.out.println(reverse(13));
//        bit.cals(test);
//        test = test * 2;
//        System.out.println(test);
//        bit.printSum();


        /*
        PriorityQueue<Integer> queue = new PriorityQueue<>();


        queue.add(11);
        queue.add(12);
        queue.add(14);
        queue.add(15);
        queue.add(16);
        queue.add(17);
        queue.add(20);

        while(queue.isEmpty() == false){
            System.out.printf("%d", queue.remove());
            System.out.println("\n");
        }
        */

//        recusrion(10);


    }

    public String addBinaryV2(String A, String B) {
        if (A.length() < B.length()) return addBinary(B, A);
        int i = A.length() - 1;
        int j = B.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0) {
            int sum = carry + Character.getNumericValue(A.charAt(i)) + getJ(j, B);
            sb.append(sum % 2);
            carry = sum / 2;
            i--;
            j--;
        }
        if (carry != 0) {
            sb.append("1");
        }

        return sb.reverse().toString();
    }

//    public Long unsetBits(Long input, int unsetNumber) {
//
//        Long ans = input;
//        for (int i = 0; i < unsetNumber; i++) {
//            if ((input & (1<< i)) == true) {
//                ans -= (1L << i);
//            }
//        }
//        return ans;
//    }

    public int getJ(int j, String B) {
        if (j >= 0) {
            return Character.getNumericValue(B.charAt(j));
        }
        return 0;
    }

    //    int number = 100;
    void cals(int number) {
        number++;
        Integer test = 10000;
    }

    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        if (A.size() < 3) {
            return A;
        }

        int xorElement = 0;
        for (int i = 0; i < A.size(); i++) {
            xorElement = xorElement ^ A.get(i);
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

        for (int i = 0; i < A.size(); i++) {
            if ((A.get(i) & (1 << idx)) != 0) {
                xorA = xorA ^ A.get(i);
            } else {
                xorB = xorB ^ A.get(i);
            }
        }
        ArrayList<Integer> output = new ArrayList<>();
        output.add(xorA);
        output.add(xorB);
        return output;

    }
}
