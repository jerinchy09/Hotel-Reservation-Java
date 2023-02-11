package model;

import java.util.regex.Pattern;

public class Customer {
    private final String firstname;
    private final String Lastname;
    private final String email;

    public Customer(String firstname, String lastname, String email){
        this.firstname = firstname;
        this.Lastname = lastname;
        this.email= email;


    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString(){
        return "Firstname: "+firstname +"\nLastname: "+ Lastname+ "\n" +
                "email: " +email;
    }



}
