package coreJava.oops;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Student {
    private final String id;
    private final String name;
    private final int age;

    public Student(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("1234", "Tarun", 28));
        studentList.add(new Student("1233", "Arun", 28));
        studentList.add(new Student("1236", "Shiv", 28));
        studentList.add(new Student("1233", "Rohan", 28));
        Collections.sort(studentList, Comparator.comparing(Student::getAge)
                .thenComparing(Student::getName));
    }
}

