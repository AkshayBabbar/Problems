package corejava.Interview.java8;

import java.util.List;
import java.util.function.IntBinaryOperator;
import java.util.function.LongUnaryOperator;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;


public class Driver {
    public static IntBinaryOperator binaryOperator = (x, y) -> (x >= y) ? x : y;
    public static LongUnaryOperator longUnaryOperator = x -> (x % 2 == 0) ? x + 2 : x + 1;
    public static UnaryOperator<List<String>> unaryOperator = x -> x.stream().distinct().collect(Collectors.toList());
    public static TernaryIntPredicate allValues = (a, b, c) -> a != b && b != c && c != a;


    public static void main(String[] args) {


////        This is a lambda defined here.
//        Formula f = val -> val*val*val;
//
//        double val = f.calculate(20);
//        System.out.println(val);
//
//        List<String> names = Arrays.asList("Test", "anna", "xerbia");
//        Collections.sort(names, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o2.compareTo(o1);
//            }
//        });
//
//        Collections.sort(names, (a, b) -> b.compareTo(a));


        System.out.println(longUnaryOperator.applyAsLong(484));
//        List<Integer> numbers = List.of(1, 4, 7, 6, 2, 9, 7, 8);
//        long count =numbers.stream().filter(numbers -> numbers>5).count();
//        List<String> companies = new ArrayList<>(              "Google", "Amazon", "Samsung",
//                "GOOGLE", "amazon", "Oracle"
//        );
    }
}
