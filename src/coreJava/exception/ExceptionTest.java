package coreJava.exception;

import java.io.FileNotFoundException;

public class ExceptionTest {

    static void m() throws ArithmeticException {
        Integer ten = Math.negateExact(Integer.MIN_VALUE);
        Integer zero = Integer.MAX_VALUE;
        Long sum = (long) (ten + zero);
        throw new NullPointerException();

    }

    static void throwsCheckedException() throws FileNotFoundException {
        System.out.println("This will throw Checked Exception but need to cover its ass.");
    }

    static void throwsUncheckedException() throws ArithmeticException {
        System.out.println("This ass is not covered by JAVA");
    }

    static void automaticResourceMgmt() {

//        try{
//            int i=10/0;
//        }catch(Exception e){
//            System.out.println("Exception handled - RuntimeException");
//        }catch(ArithmeticException ae){
//            System.out.println("Exception handled - ArithmeticException");
//        }
    }

    static String whyFinally() {

        String finalCheck;
        try {
            int i = 10 / 2;
            finalCheck = "Test";
            return finalCheck;
        } catch (ArithmeticException exception) {
            finalCheck = "catch";
            return finalCheck;

        } finally {
            finalCheck = "finally";
            return finalCheck;
        }
    }


    public static void main(String[] args) {
//        m();
//
//        try {
//            throwsCheckedException();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        throwsUncheckedException();

        System.out.println("The value we get is " + whyFinally());
    }
}
