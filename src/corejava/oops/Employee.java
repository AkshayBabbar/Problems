package src.corejava.oops;

import java.util.Comparator;
import java.util.Date;

public class Employee implements Comparable {
    private String id;
    private String name;
    private int age;
    private int salary;
    private Date dateOfJoining;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(Date dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Employee() {
    }

    public static final Comparator<Employee> AgeComparator = new Comparator<Employee>() {
        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.getAge() - o2.getAge();
        }
    };
    public static final Comparator<Employee> SalaryComparator = new Comparator<Employee>() {
        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.getSalary() - o2.getSalary();
        }
    };

    public Employee(String id, String name, int age, int salary, Date dateOfJoining) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.dateOfJoining = dateOfJoining;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", dateOfJoining=" + dateOfJoining +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
