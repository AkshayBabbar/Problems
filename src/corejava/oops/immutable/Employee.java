package src.corejava.oops.immutable;

public final class Employee {
    private final int id;
    private final Address address;

    public Employee(int id, Address address) {
        this.id = id;
//      Deep Copy
        this.address = new Address();
        this.address.setStreet(address.getStreet());
    }

    public int getId() {
        return id;
    }

    public Address getAddress() {
        // must copy here too
        Address address1 = new Address();
        address1.setStreet(address.getStreet());
        return address1;
    }
}
