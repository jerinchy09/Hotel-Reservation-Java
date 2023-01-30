package Service;

import model.Customer;
import model.MainMenu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class CustomerService {
    private static CustomerService custObj;
    private static List<Customer> customers = new ArrayList<>();
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
            customers.add(customer);
            System.out.println("Customer Added");
            MainMenu.Mainmenu();
        }catch(IllegalArgumentException e){
            System.out.println("Please try again.");
        }
    }

    public Customer getCustomer(String customerEmail){
        return null;
    }
    public List<Customer> getAllCustomers(){
        for(Customer customer: customers){
            System.out.println("Firstname: "+ customer.getFirstname()+
                    " Lastname: "+customer.getLastname()+
                    " Email: "+customer.getEmail());
        }

        return customers;
    };


}
