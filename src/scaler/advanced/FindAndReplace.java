package src.scaler.advanced;

public class FindAndReplace {
    public static String replace(String input, int opening, int closing, String check, String replace) {
        StringBuffer sb = new StringBuffer(input);
        sb.replace(opening+1, closing-1, check);
        return sb.toString();

    }

    public static String findAndReplace(String input, String check, String replace) {
        int opening = input.indexOf('[');
        int closing = input.indexOf(']');
        String out = replace(input, opening, closing, check, replace);
        return out;
    }

    public static void main(String[] args) {
        System.out.println(
                findAndReplace("abs[as]as", "a", "s"));

    }
}
