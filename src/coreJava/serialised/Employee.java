package coreJava.serialised;

/*
 *
 * Author: Akshay Babbar
 * Purpose: This is driver class.
 * */

import java.io.Serializable;

public class Employee implements Serializable {

//    static  String companyName ="Amdocs Pvt Ltd.";;
private Integer id;
    private String name;

    public Employee(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee [id = " + this.id + " name = " + this.name + "]";

    }
}
