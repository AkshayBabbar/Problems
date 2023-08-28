package src.scaler.advanced.language;

public class Student {
    int age;
    String name;

    void display(){
        System.out.println(" My name is " + this.name + ". I am " + this.age + " years old. ");
    }

    void sayHello( String name){
        System.out.println(this.name + " says Hello "+ name);
    }
}
