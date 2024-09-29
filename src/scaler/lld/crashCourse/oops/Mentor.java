package src.scaler.lld.crashCourse.oops;

import java.util.ArrayList;
import java.util.List;

public class Mentor extends User {
    private List<Student> students = new ArrayList<>();

    public Mentor(long id, String name, String email) {
        super(id, name, email);
    }

    public Mentor(long id, String name, String email, List<Student> students) {
        super(id, name, email);
        this.students = students;
    }
}
