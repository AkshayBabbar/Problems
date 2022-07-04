package src.corejava.oops;

/**
 * @author aksbabba
 * @
 */
public class NestedClassExample {

    int testInteger;

   public static class StaticInnerClassExample{
        void staticTestMethod(){
            System.out.println("This is static inner class ");
        }
        static void test(){
            System.out.println("this is test");
        }
    }

    public class InnerClassExample{
        void innerClassTest(){
            System.out.println("this is the the inner Class.");
        }
    }

//    int check = function(asfa){
//
//    }
    public static void main(String[] args) {

        new NestedClassExample.StaticInnerClassExample().staticTestMethod();
//        new NestedClassExample.StaticInnerClassExample.test();

         new NestedClassExample().new InnerClassExample().innerClassTest();

    }
}
