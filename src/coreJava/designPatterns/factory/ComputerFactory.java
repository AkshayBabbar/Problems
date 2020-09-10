package coreJava.designPatterns.factory;

/*
 *       @author: Akshay Babbar
 *       @Purpose: This is a factory class implementation which helped to achieve our purpose.
 *       we have super classes and sub-classes ready, we can write our factory class.
 *       Here is the basic implementation.
 * */


public class ComputerFactory {

    public static Computer getComputer(String type, String ram, String hdd, String cpu) {

        if (type.equalsIgnoreCase("PC"))
            return new PC(ram, hdd, cpu);
        else if (type.equalsIgnoreCase("Server"))
            return new Server(ram, cpu, hdd);
        else
            return null;
    }
}
