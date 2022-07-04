package src.corejava.oops;

import java.util.HashMap;
import java.util.Map;

public class SubClass extends SuperClass{

    static{
        System.out.println("SubClass ---------------> static Block");
    }

    {
        System.out.println("Subclass -------------> instance block");
    }

    SubClass(){
        System.out.println("Subclass ---------------------> Constuctor");
    }

    public static void main(String[] args) {
        new SubClass();
//        Student s0= new Student();
//        Student s1 = new Student();
//        s0.marks(s1);


    }
}
