package corejava.oops.blocks;

public class IIB {


    private static String[] emailID;

    static {
        emailID = new String[]{"afwe@esdf.com", "rwefweg@ewwg.com"};

        System.out.println("This is a static block");
    }

    {
        System.out.println("This is instance block");
    }

    public static void main(String[] args) {
        new IIB();
        System.out.println(emailID.length);

    }
}
