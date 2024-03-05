package src.scaler.advanced;

import java.util.*;


public class Array3 {

    public static ArrayList<Interval> mergeIntervals(ArrayList<Interval> intervals) {

        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        Queue<Interval> queue = new LinkedList<>();
        Stack<Interval> stack = new Stack<>();
        ArrayList<Interval> output = new ArrayList<>();
        stack.push(intervals.get(0));
        output.add(intervals.get(0));

        for (int i = 1; i < intervals.size(); i++) {
            Interval stackTopElement = stack.peek();
            Interval curr = intervals.get(i);

            if (stackTopElement.end >= curr.start) {
                stack.pop();
                output.remove(output.size() - 1);
                Interval newInterval = new Interval(stackTopElement.start, Math.max(stackTopElement.end, curr.end));
                stack.push(newInterval);
                output.add(newInterval);
            } else {
                stack.push(intervals.get(i));
                output.add(intervals.get(i));
            }
        }

        while (!stack.empty()) {
            queue.add(stack.pop());
        }
//        while(!queue.isEmpty()){
//            output.add(queue.remove());
//        }
        return output;
    }

    public static void main(String[] args) {
        ArrayList<Interval> intervals = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int[][] input = {
                {47, 76}, {51, 99}, {28, 78}, {54, 94}, {12, 72}, {31, 72}, {12, 55}, {24, 40},
                {59, 79}, {41, 100}, {46, 99}, {5, 27}, {13, 23}, {9, 69}, {39, 75}, {51, 53},
                {81, 98}, {14, 14}, {27, 89}, {73, 78}, {28, 35}, {19, 30}, {39, 87}, {60, 94},
                {71, 90}, {9, 44}, {56, 79}, {58, 70}, {25, 76}, {18, 46}, {14, 96}, {43, 95},
                {70, 77}, {13, 59}, {52, 91}, {47, 56}, {63, 67}, {28, 39}, {51, 92}, {30, 66},
                {4, 4}, {29, 92}, {58, 90}, {6, 20}, {31, 93}, {52, 75}, {41, 41}, {64, 89},
                {64, 66}, {24, 90}, {25, 46}, {39, 49}, {15, 99}, {50, 99}, {9, 34}, {58, 96},
                {85, 86}, {13, 68}, {45, 57}, {55, 56}, {60, 74}, {89, 98}, {23, 79}, {16, 59},
                {56, 57}, {54, 85}, {16, 29}, {72, 86}, {10, 45}, {6, 25}, {19, 55}, {21, 21},
                {17, 83}, {49, 86}, {67, 84}, {8, 48}, {63, 85}, {5, 31}, {43, 48}, {57, 62},
                {22, 68}, {48, 92}, {36, 77}, {27, 63}, {39, 83}, {38, 54}, {31, 69}, {36, 65},
                {52, 68}
        };


        int[][] input2 = {
                {5, 28}, {7, 70}, {54, 93}, {5, 98}, {46, 70}, {42, 63}, {5, 91}, {30, 49}, {36, 57}, {31, 95},
                {86, 88}, {9, 90}, {5, 53}, {42, 62}, {14, 100}, {59, 75}, {32, 100}, {5, 79}, {31, 31}, {7, 42},
                {13, 47}, {44, 87}, {61, 83}, {100, 100}, {96, 98}, {47, 51}, {34, 44}, {6, 53}, {30, 92}, {50, 64},
                {37, 57}, {49, 67}, {2, 67}, {36, 50}, {55, 100}, {54, 78}, {58, 70}, {2, 37}, {13, 54}, {7, 60},
                {16, 79}, {35, 78}, {17, 57}, {16, 84}, {60, 80}, {10, 54}, {54, 59}, {62, 85}, {7, 37}, {31, 99},
                {40, 41}, {4, 99}, {28, 45}, {27, 71}, {14, 64}
        };
        for (int[] intervalData : input2) {
            int start = intervalData[0];
            int end = intervalData[1];
            intervals.add(new Interval(start, end));
        }
//        intervals.add{new Interval{1,10}};
//        intervals.add(new Interval(2,9));
//        intervals.add(new Interval(3,8));
//        intervals.add(new Interval(4,7));
//        intervals.add(new Interval(5,6));
//        intervals.add(new Interval(6,6));
        mergeIntervals(intervals);


    }
}
