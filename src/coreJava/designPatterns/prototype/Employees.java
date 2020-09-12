package coreJava.designPatterns.prototype;

import java.util.ArrayList;
import java.util.List;

public class Employees implements Cloneable {
    private List<String> empList;

    public Employees(List<String> empList) {
        this.empList = empList;
    }

    public Employees() {
        empList = new ArrayList<String>();

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
        for (String s : this.getEmpList()) {
            temp.add(s);
        }
        return new Employees(temp);

    }
}
