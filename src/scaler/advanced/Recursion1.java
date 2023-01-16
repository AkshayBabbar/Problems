package src.scaler.advanced;

public class Recursion1 {
    public static String reverse(String input) {

        if (input.length() < 2) {
            return input;
        }

        return input.charAt(input.length() - 1) + reverse(input.substring(0, input.length() - 1));
    }

    public static void main(String[] args) {
        System.out.println(reverse("input"));
    }
}
