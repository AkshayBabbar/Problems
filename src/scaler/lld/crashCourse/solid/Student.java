package src.scaler.lld.crashCourse.solid;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Student {
    private String name;
    private int age;
    private String rollNumber;

    public Student(String name, int age, String rollNumber) {
        this.name = name;
        this.age = age;
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public static void main(String[] args) {
        Student student = new Student("Tantia Tope", 25, "1234567890");
        Field[] fields = student.getClass().getFields();
        System.out.println("****************** MAIN **************");
        for (Field field : fields) {
            System.out.println("Field name is " + field.getName());
            System.out.println("Field type is " + field.getType());

        }
        Method[] methods = student.getClass().getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("Method name: " + method.getName());
            System.out.println("Method return type: " + method.getReturnType());
        }

    }
}
