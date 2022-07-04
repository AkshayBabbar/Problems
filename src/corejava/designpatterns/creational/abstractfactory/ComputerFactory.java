package src.corejava.designpatterns.creational.abstractfactory;

/**
 * @author: Akshay Babbar
 * @Purpose: This is a factory class implementation which helped to achieve our @Purpose.
 * we have super classes and sub-classes ready, we can write our abstract factory class.
 * Here is the basic implementation.
 */


public class ComputerFactory {

    public static Computer getComputer(ComputerAbstractFactory factory) {

        return factory.createComputer();
    }
}
