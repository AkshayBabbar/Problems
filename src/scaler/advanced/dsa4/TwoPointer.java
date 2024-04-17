package src.scaler.advanced.dsa4;

import src.scaler.advanced.StringDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class TwoPointer {


    public static int pairsWithGivenSum(ArrayList<Integer> input, int B) {

        int i = 0;
        int mod = 1000 * 1000 * 1000 + 7;
        int ans = 0;
        int j = input.size() - 1;
        while (i < j) {
            int sum = input.get(i) + input.get(j);
            if (sum == B) {
                if (input.get(i).equals(input.get(j))) {
                    int count = j - i + 1;
                    ans += (count * (count + 1)) / 2 % mod;
                    ans %= mod;
                    break;
                } else {
                    int ii = i;
                    int jj = j;
                    while (input.get(ii).equals(input.get(i))) {
                        ii++;
                    }
                    int cnt1 = countElement(input, input.get(i), ii, true);
                    int cnt2 = countElement(input, input.get(j), jj, false);
                    ans += (cnt1 * cnt2) % mod;
                    ans %= mod;
                }
            } else if (sum < B) {
                i++;
            } else {
                j--;
            }
        }
        return ans;
    }

    public static ArrayList<Integer> sortColors(ArrayList<Integer> A) {
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        for (Integer i : A) {
            if (i == '0') {
                count0++;
            }
            if (i == '1') {
                count1++;
            }
            if (i == '2') {
                count2++;
            }
        }
        ArrayList<Integer> output = new ArrayList<Integer>();
        int i = 0;
        while (i < count0) {
            output.add(0);
            i++;
        }
        i = 0;
        while (i < count1) {
            output.add(1);
            i++;
        }
        i = 0;
        while (i < count2) {
            output.add(2);
            i++;
        }
        return output;
    }

    public static int countElement(ArrayList<Integer> input, int element, int position, boolean forward) {
        int count = 0;
        if (forward) {
            for (int i = position; i < input.size(); i++) {
                if (!input.get(i).equals(element)) {
                    break;
                } else {
                    count++;
                }
            }
        } else {
            for (int i = position; i > 0; i--) {
                if (!input.get(i).equals(element)) {
                    break;
                } else {
                    count++;
                }
            }
        }
        return count;
    }

    public static int threeSum(int[] input, int B) {

        int current = Integer.MAX_VALUE;
        Arrays.sort(input);
        int sum = 0;
        for (int i = 0; i < input.length - 2; i++) {
            int a = i;
            int b = i + 1;
            int c = input.length - 1;
            while (b < c) {
                sum = input[a] + input[b] + input[c];
                int a1 = Math.abs(sum - B);
                int a2 = Math.abs(current - B);
                if (a1 < a2) {
                    current = B;
                } else if (a2 > B) {
                    c--;
                } else if (a2 < B) {
                    b++;
                }
                if (a1 == B) {
                    return a1;
                }
            }
        }
        return current;
    }

    public static ArrayList<ArrayList<Integer>> threeSumZero(ArrayList<Integer> A) {

        ArrayList<ArrayList<Integer>> output = new ArrayList<>();
        Collections.sort(A);
        for (int i = 0; i < A.size() - 2; i++) {
            int first = i + 1;
            int second = A.size() - 1;
            while (first < second) {
                int sum = A.get(i) + A.get(first) + A.get(second);
                if (sum == 0) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(A.get(i));
                    temp.add(A.get(first));
                    temp.add(A.get(second));
                    if (!output.contains(temp)) {
                        output.add(temp);
                    }
                    first++;
                    second--;
                } else if (sum < 0) {
                    first++;
                } else {
                    second--;
                }
            }
        }
        return output;
    }

    public static int maxArea(ArrayList<Integer> input) {
        if (input.size() < 2) {
            return 0;
        }
        int i = 0;
        int j = input.size() - 1;
        int maxVol = 0;

        while (i < j) {
            int base = i - j;
            int height = Math.min(input.get(i), input.get(j));
            maxVol = Math.max(maxVol, height * base);
            i++;
            j--;

        }
        return maxVol;
    }

    public static int countRect(ArrayList<Integer> input, int limiter) {

        int count = 0;
        int i = 0;
        int j = input.size();
        while (i < j) {
            int sum = input.get(i) * input.get(j);
            if (sum < limiter) {
                count = count + 2;
                j--;
            }
            if (input.get(i) < limiter) {
                i++;
            } else {
                j--;
            }
        }

        return count;
    }

    public static void main(StringDemo[] args) {

//        ArrayList<Integer> tc1 = new ArrayList<>(Arrays.asList(-5, 1, 4, -7, 10, -7, 0, 7, 3, 0, -2, -5, -3, -6, 4, -7, -8, 0, 4, 9, 4, 1, -8, -6, -6, 0, -9, 5, 3, -9, -5, -9, 6, 3, 8, -10, 1, -2, 2, 1, -9, 2, -3, 9, 9, -10, 0, -9, -2, 7, 0, -4, -3, 1, 6, -3));
//        ArrayList<Integer> tc2 = new ArrayList<>(Arrays.asList(1, -4, 0, 0, 5, -5, 1, 0, -2, 4, -4, 1, -1, -4, 3, 4, -1, -1, -3));
//        int temp = -1;
//        System.out.println(pairsWithGivenSum(tc1, temp));
//        ArrayList<Integer> tc2 = new ArrayList<>(List.of(0));
//        sortColors(tc2);
//        System.out.println(pairsWithGivenSum(tc1, temp));
//        threeSumZero(tc2);

    }

    public int solve(int[] A, int B) {
        int mod = 1000 * 1000 * 1000 + 7;
        int l = 0, r = A.length - 1, ans = 0;
        while (l < r) {
            int sum = A[l] + A[r];
            if (sum == B) {
                int count = 0, prev = r;
                while (prev > l && A[r] == A[prev]) {//count duplicate values from right pointer
                    count++;
                    prev--;
                }
                ans = (ans + count) % mod;
                l++;
            } else if (sum < B) {
                l++;
            } else if (sum > B) {
                r--;
            }
        }
        return ans;
    }
}
