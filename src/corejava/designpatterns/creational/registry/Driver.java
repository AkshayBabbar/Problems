package src.corejava.designpatterns.creational.registry;

public class Driver {
    public static void main(String[] args) {
        Customer testCustomer = new Customer("01","Akshay");
        CustomerRegistry customerRegistry = null;
        customerRegistry.addCustomer(testCustomer);
    }
}
