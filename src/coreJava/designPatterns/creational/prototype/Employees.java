package coreJava.designPatterns.creational.prototype;

import java.util.ArrayList;
import java.util.List;

public class Employees implements Cloneable {
    private List<String> empList;

    public Employees(List<String> empList) {
        this.empList = empList;
    }

    public Employees() {
        empList = new ArrayList<>();

    }

    public void loadData() {
        empList.add("Pankaj");
        empList.add("Raj");
        empList.add("David");
        empList.add("Lisa");
    }

    public List<String> getEmpList() {
        return empList;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        List<String> temp = new ArrayList<String>();
        temp.addAll(this.getEmpList());
        return new Employees(temp);

    }
}
