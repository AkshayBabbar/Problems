package coreJava.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Employee {
    private String id;
    private Double Salary;
    private String firstName;
    private String lastName;

    private boolean activeEmployee;

    public boolean isActive() {
        return activeEmployee;
    }

    public void setActive(boolean active) {
        activeEmployee = active;
    }

    public Employee() {
    }

    public Employee(String id, Double salary, String firstName, String lastName, boolean isActive) {
        this.id = id;
        Salary = salary;
        this.firstName = firstName;
        this.lastName = lastName;
        this.activeEmployee = isActive;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getSalary() {
        return Salary;
    }

    public void setSalary(Double salary) {
        Salary = salary;
    }

    public static void main(String[] args) {
//        Driver Code starts
        Employee e1 = new Employee("1234", 78000.00D, "Raj", "Malhotra", true);
        Employee e2 = new Employee("1235", 80000.00D, "Naman", "Malhotra", false);
        Employee e3 = new Employee("1236", 70000.00D, "Vicky", "Malhotra", false);
        Employee e4 = new Employee("1237", 90000.00D, "Raj", "Kumar", true);
        Employee e5 = new Employee("1238", 120000.00D, "Akshay", "Babbar", true);

        List<Employee> listOfEmployees = new ArrayList<>();
        listOfEmployees.add(e1);
        listOfEmployees.add(e2);
        listOfEmployees.add(e3);
        listOfEmployees.add(e4);
        listOfEmployees.add(e5);

//        Driver Code ends
        List<Employee> copy = new ArrayList<>(listOfEmployees);

        copy.sort(((o1, o2) -> (int) (o2.getSalary() - o1.getSalary())));

        //        get first 3 Employees
        System.out.println("This is the OLD Way");
        for (int i = 0; i < 3; i++) {
            Employee employee = copy.get(i);
            System.out.println(employee.getFirstName() + " " + employee.getLastName());
        }

        System.out.println("*****************-------------NEW WAY------------**********");

        listOfEmployees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .limit(3)
                .map(Employee::getFirstName)
                .forEach(System.out::println);

        //        get the 3 highest Paid employee who are still active in the firm.

//        Old way
        int count = 0;
        Iterator<Employee> iterator = copy.iterator();
        List<String> highestPaid = new ArrayList<>();
        System.out.println("This is the OLD Way");
        while (count < 3 && iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employee.isActive()) {
                String fullName = employee.getFirstName() + " " + employee.getLastName();
                highestPaid.add(fullName);
                System.out.println(fullName);
                count++;
            }
        }
        System.out.println("*****************-------------NEW WAY------------**********");
        listOfEmployees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .filter(employee -> employee.isActive())
                .limit(3)
                .map(Employee::getFirstName)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }
}