package Service;

import model.Customer;
import model.MainMenu;

import java.util.*;

public class CustomerService {
    private static CustomerService custObj;
    private Map<String, Customer> customerMap = new HashMap<>();

    //private static List<Customer> customers = new ArrayList<>();
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
//        Collection<Customer> collectionValues = customerMap.values();
//
//
//       // System.out.println("<------OutPut before modification------>\n");
//        for(Customer cus: collectionValues){
//            System.out.println(cus);
//        }
//        return collectionValues;
    }
    public Map<String, Customer> getAllCustomers(){
        for (Map.Entry<String, Customer> cus : customerMap.entrySet()){
               for(int i = 0; i<customerMap.size();i++) {
                   // for(Customer customer: customers){
                   System.out.println("Customer no."+(i+1)+"\n " + cus.getValue());
//                    " Lastname: "+customer.getLastname()+
//                    " Email: "+customer.getEmail());
               }
        }

        return customerMap;
    };


}
