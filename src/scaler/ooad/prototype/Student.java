package src.scaler.ooad.prototype;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Student implements Prototype {

    private int id;
    private String name;
    private int age;

    public Student() {
    }

    public Student(Student orig) {
//        this.age = orig.getAge();
        this.id = orig.id;
        this.name = orig.name;
    }


    @Override
    public Student clone() {
        return new Student(this);
    }
}
