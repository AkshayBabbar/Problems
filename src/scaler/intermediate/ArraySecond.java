package src.scaler.intermediate;

import java.util.*;

public class ArraySecond {

    /**
     * Finding the Maximum Element
     *
     * @param input
     * @return
     */
//    public static int leftMax(ArrayList<Integer> input) {
////        for(int i =0 )
//
//    }

    /**
     * You are given an integer array C of size A.
     * Now you need to find a sub-array (contiguous elements) so that the sum of contiguous elements is maximum.
     * But the sum must not exceed B.
     *
     * @param length     int
     * @param maxSum     int
     * @param inputArray Arraylist
     * @return integerSum
     */
    public int maxSubarray(int length, int maxSum, ArrayList<Integer> inputArray) {
        if (inputArray.size() < 2) {
            if (inputArray.get(0) <= maxSum) {
                return inputArray.get(0);
            } else {
                return 0;
            }
        }
        int max = 0;
        for (int i = 0; i < length; i++) {
            int sum = 0;
            for (int j = i; j < length; j++) {
                sum = sum + inputArray.get(j);
                if (sum <= maxSum) {
                    max = Math.max(max, sum);
                }
            }
        }
        if (max <= maxSum) {
            return max;
        }
        return 0;
    }

    /**
     * Making an even subarray
     *
     * @param inputArray
     * @return
     */
    public static ArrayList<Integer> evenSumArray(ArrayList<Integer> inputArray) {
        ArrayList<Integer> outputArray = new ArrayList<>();
        outputArray.add(inputArray.get(0));
        for (int i = 1; i < inputArray.size(); i++) {
            if (i % 2 == 0) {
                outputArray.add(i, outputArray.get(i - 1) + inputArray.get(i));
            } else {
                outputArray.add(outputArray.get(i - 1));
            }
        }
        return outputArray;
    }

    /**
     * Making an odd subarray
     *
     * @param inputArray
     * @return
     */
    public static ArrayList<Integer> oddSumArray(ArrayList<Integer> inputArray) {
        ArrayList<Integer> outputArray = new ArrayList<>();
        outputArray.add(0);
        for (int i = 1; i < inputArray.size(); i++) {
            if (i % 2 != 0) {
                outputArray.add(outputArray.get(i - 1) + inputArray.get(i));
            } else {
                outputArray.add(outputArray.get(i - 1));
            }
        }
        return outputArray;
    }

    /**
     * Given an array of size N, find the subarray of size K with the least average.
     *
     * @param inputArray
     * @param subArraySize
     * @return
     */
    public int leastAverage(List<Integer> inputArray, int subArraySize) {
        int n = inputArray.size();
        float sum;
        int minIndex = 0;
        float minAverage = Float.MAX_VALUE;
        if (subArraySize >= inputArray.size()) {
            return 0;
        }
        for (int i = 0; i < n; i++) {
            float average;
            sum = 0;
            if (i + subArraySize > n) {
                break;
            } else {
                for (int j = i; j < i + subArraySize; j++) {
                    sum = sum + inputArray.get(j);
                }
            }
            average = sum / subArraySize;
            if (minAverage > average) {
                minAverage = average;
                minIndex = i;
            }
        }
        return minIndex;
    }


    public int solution(int[] A) {
        // write your code in Java SE 8
        int flaggedNumber = 0;

        Arrays.sort(A);
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = A.length - 1; i >= 0; i--) {
            if (map.containsKey(A[i])) {
                map.put(A[i], map.get(A[i]) + 1);
            } else {
                map.put(A[i], 1);
            }
        }


        for (Map.Entry hm : map.entrySet()) {
            int key = (int) hm.getKey();
            int value = (int) hm.getValue();

            if (key == value) {
                flaggedNumber = key;
                break;
            }
        }

        if (flaggedNumber != 0) {
            return flaggedNumber;
        } else {
            return 0;
        }
    }

    public int solve(String A) {

        StringBuffer sb = new StringBuffer();
        sb.append(A);
        int maxLenght = Integer.MIN_VALUE;
        int totalOnesCount = 0;

        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == '1') {
                totalOnesCount++;
            }
        }

        int leftCount = 0;
        int rightCount = 0;
        for (int i = 0; i < A.length(); i++) {

            if (A.charAt(i) == '0') {
                leftCount = 0;
                rightCount = 0;

// Left Part count
                int leftIndex = i - 1;
                while (leftIndex >= 0) {
                    if (A.charAt(leftIndex) == '1') {
                        leftCount++;
                    } else {
                        break;
                    }
                    leftIndex--;
                }

// Right Part Count
                int rightIndex = i + 1;
                while (rightIndex < A.length()) {
                    if (A.charAt(rightIndex) == '1') {
                        rightCount++;
                    } else {
                        break;
                    }
                    rightIndex++;
                }

                if ((leftCount + rightCount) < totalOnesCount) {
                    maxLenght = Math.max(maxLenght, (leftCount + rightCount + 1));
                } else {
                    maxLenght = Math.max(maxLenght, (leftCount + rightCount));
                }
            }
        }

        if (maxLenght == Integer.MIN_VALUE) {
            return A.length();
        }

        return maxLenght;
    }

    public static ArrayList<Integer> posiArray(ArrayList<Integer> input) {

        int n = input.size();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(input.get(i), 1);
        }
        ArrayList<Integer> output = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(i)) {
                output.add(i);
            } else {
                output.add(-1);
            }
        }
        return output;
    }

    public static int oddEvenSumIndexCount(ArrayList<Integer> A) {
        ArrayList<Integer> oddArray = oddSumArray(A);
        ArrayList<Integer> evenArray = evenSumArray(A);
        int count = 0;
        int zerototalEven = oddArray.get(A.size() - 1) - oddArray.get(0);
        int zerototalOddSum = evenArray.get(A.size() - 1) - evenArray.get(0);
        if (zerototalOddSum == zerototalEven) {
            count++;
        }
        for (int i = 1; i < A.size(); i++) {
            int totalEven = evenArray.get(i - 1) + oddArray.get(A.size() - 1) - oddArray.get(i);
            int totalOddSum = oddArray.get(i - 1) + evenArray.get(A.size() - 1) - evenArray.get(i);
            if (totalEven == totalOddSum) {
                count++;
            }
        }
        return count;
    }

    /**
     * return the majority element for the array.
     *
     * @param A
     * @return
     */
    public int majorityElement(final List<Integer> A) {
        int majorityElement = 0;
        if (A.size() < 2) {
            return A.get(0);
        }
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < A.size(); i++) {
            if (map.containsKey(A.get(i))) {
                map.put(A.get(i), map.get(A.get(i)) + 1);
            } else {
                map.put(A.get(i), 1);
            }
        }

        for (Map.Entry gmap : map.entrySet()) {
            int value = (int) gmap.getValue();
            if (value >= (A.size() / 2 + 1)) {
                majorityElement = (int) gmap.getKey();
            }
        }
        return majorityElement;

    }

    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        int size = A.size();
        HashMap<Integer, Integer> map = new HashMap<>();

        ArrayList<Integer> sub = new ArrayList<>();
        int start = -1, end = -1, minStart = -1, maxEnd = -1, max = Integer.MIN_VALUE;
        for (int i = 0; i < size; ) {
            if (A.get(i) >= 0) {
                start = i;
                while (i < size && A.get(i) >= 0) {
                    i++;
                }
                end = i - 1;
                if (max < (end - start + 1)) {
                    minStart = start;
                    maxEnd = end;
                    max = end - start + 1;
                }
            } else
                i++;
        }
        for (int i = minStart; i <= maxEnd; i++) {
            sub.add(A.get(i));
        }
        return sub;
    }

    public int findMod(String A, int B) {
        int ans = 0;
        int n = A.length();
        for (int i = 0; i < A.length(); i++) {
            int digit = (int) Math.pow(10, n - 1 - i) % B;
            int number = (A.charAt(i) - '0') % B;
            int numberFull = number * digit;
            ans = ans % B + numberFull;
        }
        return ans % B;
    }


    public ArrayList<Integer> repeatedNumber(final List<Integer> A) {

        Collections.sort(A);

        boolean flag = false;
        int repeatedNumber = A.get(0);
        int missingNumber = 0;
        int repeatingIndex = -1;
        for (int i = 0; i < A.size() - 1; i++) {
            if (A.get(i).equals(A.get(i + 1))) {
                repeatedNumber = A.get(i);
                repeatingIndex = i;
            }
            if (repeatingIndex == 0) {
                missingNumber = A.get(i) - 1;
            }
            if ((A.get(i + 1) - A.get(i) != 1) && !(A.get(i).equals(A.get(i + 1)))) {
                missingNumber = A.get(i) + 1;
            }
            if (missingNumber == A.get(i)) {
                flag = true;
            }
        }


        ArrayList<Integer> output = new ArrayList<>();

        output.add(repeatedNumber);
        if (flag) {
            missingNumber = 1;
        }

        output.add(missingNumber);

        return output;
    }


    public int nobleNumber(ArrayList<Integer> A) {
        Collections.sort(A);
        int n = A.size();

        int count = 0;
        for (int i = 1; i < A.size(); i++) {
            if (A.get(i)!= A.get(i-1)) {
                count = i;
            }
            if (A.get(i) == n - count - 1) {
                return 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        ArraySecond arraySecond = new ArraySecond();
        ArrayList<Integer> inputArray = new ArrayList<>(Arrays.asList(389, 299, 65, 518, 361, 103, 342, 406, 24, 79, 192, 181, 178, 205, 38, 298, 218, 143, 446, 324, 82, 41, 312, 166, 252, 59, 91, 6, 248, 395, 157, 332, 352, 57, 106, 246, 506, 261, 16, 470, 224, 228, 286, 121, 193, 241, 203, 36, 264, 234, 386, 471, 225, 466, 81, 58, 253, 468, 31, 197, 15, 282, 334, 171, 358, 209, 213, 158, 355, 243, 75, 411, 43, 485, 291, 270, 25, 100, 194, 476, 70, 402, 403, 109, 322, 421, 313, 239, 327, 238, 257, 433, 254, 328, 163, 436, 520, 437, 392, 199, 63, 482, 222, 500, 454, 84, 265, 508, 416, 141, 447, 258, 384, 138, 47, 156, 172, 319, 137, 62, 85, 154, 97, 18, 360, 244, 272, 93, 263, 262, 266, 290, 369, 357, 176, 317, 383, 333, 204, 56, 521, 502, 326, 353, 469, 455, 190, 393, 453, 314, 480, 189, 77, 129, 439, 139, 441, 443, 351, 528, 182, 101, 501, 425, 126, 231, 445, 155, 432, 418, 95, 375, 376, 60, 271, 74, 11, 419, 488, 486, 54, 460, 321, 341, 174, 408, 131, 115, 107, 134, 448, 532, 292, 289, 320, 14, 323, 61, 481, 371, 151, 385, 325, 472, 44, 335, 431, 187, 51, 88, 105, 145, 215, 122, 162, 458, 52, 496, 277, 362, 374, 26, 211, 452, 130, 346, 10, 315, 459, 92, 531, 467, 309, 34, 281, 478, 477, 136, 519, 196, 240, 12, 288, 302, 119, 356, 503, 527, 22, 27, 55, 343, 490, 127, 444, 308, 354, 278, 497, 191, 294, 117, 1, 396, 125, 148, 285, 509, 208, 382, 297, 405, 245, 5, 330, 311, 133, 274, 275, 118, 463, 504, 39, 99, 442, 337, 169, 140, 104, 373, 221, 499, 413, 124, 510, 159, 465, 80, 276, 83, 329, 524, 255, 387, 259, 397, 491, 517, 23, 4, 230, 48, 349, 412, 142, 114, 487, 381, 164, 35, 67, 498, 73, 440, 108, 226, 96, 132, 144, 207, 235, 33, 69, 128, 236, 364, 198, 475, 173, 493, 150, 90, 515, 111, 68, 232, 340, 112, 526, 492, 512, 495, 429, 146, 336, 17, 350, 251, 7, 184, 76, 380, 359, 293, 19, 49, 345, 227, 212, 430, 89, 474, 279, 201, 398, 347, 273, 37, 185, 177, 102, 304, 295, 422, 94, 426, 514, 116, 183, 180, 494, 42, 305, 152, 390, 30, 247, 451, 32, 388, 331, 78, 424, 368, 394, 188, 306, 449, 8, 214, 120, 179, 280, 511, 409, 338, 153, 507, 370, 461, 217, 161, 483, 147, 242, 86, 417, 268, 71, 462, 420, 167, 513, 379, 307, 522, 435, 113, 296, 457, 525, 45, 529, 423, 427, 2, 438, 64, 316, 46, 40, 13, 516, 367, 233, 110, 318, 250, 283, 216, 186, 310, 237, 377, 365, 175, 479, 378, 66, 414, 473, 165, 210, 50, 348, 372, 363, 339, 20, 168, 284, 415, 505, 206, 53, 223, 434, 202, 123, 399, 400, 135, 269, 428, 219, 456, 28, 464, 267, 489, 98, 391, 195, 366, 300, 484, 533, 229, 213, 149, 160, 256, 303, 530, 301, 29, 404, 344, 401, 220, 287, 9, 407, 170, 450, 523, 249, 72, 410, 3, 21, 200, 260));
//        int length = inputArray.size();
//        int maxSum = 14;
//        int max = arraySecond.maxSubarray(length, maxSum, inputArray);
//        int max = arraySecond.leastAverage(inputArray, 9);
//        System.out.println(max);
//        int[] arr = {3, 8, 2, 3, 3, 2};
//        arraySecond.solution(arr);
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(4, 3, 2, 3));
        ArrayList<Integer> input3 = new ArrayList<>(Arrays.asList(-4, 7, 5, 3, 5, -4, 2, -1, -9, -8, -3, 0, 9, -7, -4, -10, -4, 2, 6, 1, -2, -3, -1, -8, 0, -8, -7, -3, 5, -1, -8, -8, 8, -1, -3, 3, 6, 1, -8, -1, 3, -9, 9, -6, 7, 8, -6, 5, 0, 3, -4, 1, -10, 6, 3, -8, 0, 6, -9, -5, -5, -6, -3, 6, -5, -4, -1, 3, 7, -6, 5, -8, -5, 4, -3, 4, -6, -7, 0, -3, -2, 6, 8, -2, -6, -7, 1, 4, 9, 2, -10, 6, -2, 9, 2, -4, -4, 4, 9, 5, 0, 4, 8, -3, -9, 7, -8, 7, 2, 2, 6, -9, -10, -4, -9, -5, -1, -6, 9, -10, -1, 1, 7, 7, 1, -9, 5, -1, -3, -3, 6, 7, 3, -4, -5, -4, -7, 9, -6, -2, 1, 2, -1, -7, 9, 0, -2, -2, 5, -10, -1, 6, -7, 8, -5, -4, 1, -9, 5, 9, -2, -6, -2, -9, 0, 3, -10, 4, -6, -6, 4, -3, 6, -7, 1, -3, -5, 9, 6, 2, 1, 7, -2, 5));

        System.out.println(arraySecond.nobleNumber(input3));
//        ArrayList<Integer> input1 = new ArrayList<>(Arrays.asList(-1, -1, 6, 1, 9, 3, 2, -1, 4, -1));
//        System.out.println(arraySecond.majorityElement(input));
//        System.out.println(arraySecond.findMod("842554936302263", 41));
//        ArrayList<Integer> output = arraySecond.evenSumArray(input);
//        for (Integer check : output) {
//            System.out.print(check + " ");

//        }
//        System.out.println(oddEvenSumIndexCount(inputArray));

    }
}
