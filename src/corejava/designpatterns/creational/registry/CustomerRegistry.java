package src.corejava.designpatterns.creational.registry;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CustomerRegistry {

    private static final CustomerRegistry INSTANCE = new CustomerRegistry();

    public CustomerRegistry getInstance(){
        return INSTANCE;
    }

    private final Map<String, Customer> customerMap;

    private CustomerRegistry(){
        customerMap = new ConcurrentHashMap<>();
    }

    public Customer getCustomer(String id){
        return customerMap.get(id);
    }

    public Customer addCustomer(Customer customer){
        return customerMap.put(customer.getId(), customer);
    }
}
