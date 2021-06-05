package coreJava.java8;

import java.util.stream.IntStream;

public class Streams {

    public static void main(String[] args) {
        int[] numbers = {4, 8, 1, 9, 6, 46, 53, 24};
//        Finding minimum of numbers
//        int min = numbers[0];
//        for (int i = 0; i < numbers.length; i++) {
//            if (min > numbers[i]) {
//                min = numbers[i];
//            }
//        }
//        System.out.println("Minimum is " + min);
//
//        System.out.println("above is old way");
//
//        System.out.print("This is new way ");
//        IntStream.of(numbers)
//                .min()
//                .ifPresent(System.out::println);
//
//        System.out.println("Sum is " + IntStream.of(numbers).sum());
//        System.out.println("Average is " + IntStream.of(numbers).average().getAsDouble());
//        System.out.println("Max is " + IntStream.of(numbers).max().getAsInt());
//        System.out.println("Min is " + IntStream.of(numbers).min().getAsInt());
//        System.out.println("distinct is " +IntStream.of(numbers).distinct());
//
//
//        System.out.println("The statistics are " + IntStream.of(numbers).summaryStatistics());

//        Find the 3 distinct smallest numbers from an array of int
//        Old Way
        long before = System.currentTimeMillis();
//        System.out.println(before);
//        int[] copy = Arrays.copyOf(numbers, numbers.length);
//        Arrays.sort(copy);
//        System.out.println("This is the old Way again.");
//        for (int i = 0; i < 3; i++) {
//            System.out.println(copy[i]);
//        }
        long after = System.currentTimeMillis();
//        System.out.println(after);
//        System.out.println("Total Time Taken" + (after - before));
//
//        System.out.println("*********************************------------NEW WAY---------*********************************");
//
        before = System.currentTimeMillis();
        System.out.println(before);
        IntStream.of(numbers)
                .distinct()
                .sorted()
                .skip(3)
                .forEach(System.out::println);
        after = System.currentTimeMillis();
        System.out.println(after);
        System.out.println(" Total Time Taken " + (after - before));
    }
}
