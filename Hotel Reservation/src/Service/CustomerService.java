package Service;

import model.Customer;
import model.MainMenu;

import java.util.*;

public class CustomerService {
    private static CustomerService custObj;
    private Map<String, Customer> customerMap = new HashMap<>();

    private CustomerService(){

    }
    public static CustomerService getInstance(){
        if(custObj == null) {
            custObj = new CustomerService();
        }
        return custObj;
    }
    public void addCustomer(String fn, String ln, String email){
        try{
            Customer customer = new Customer(fn, ln, email);
            customerMap.put(customer.getEmail(), customer);
            System.out.println("Customer Added");
            MainMenu.Mainmenu();
        }catch(IllegalArgumentException e){
            System.out.println("Please try again.");
        }
    }

    public Customer getCustomer(String customerEmail) throws Exception {
        if (customerEmail == null) {
            throw new Exception("String is null");
        }
       return customerMap.get(customerEmail);

    }
    public Collection<Customer> getAllCustomers(){
        return customerMap.values();
    };


}
