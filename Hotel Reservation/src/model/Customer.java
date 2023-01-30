package model;

import java.util.regex.Pattern;

public class Customer {
    private String firstname;
    private String Lastname;
    private String email;

    public Customer(String fn, String ln, String em){
        this.firstname = fn;
        this.Lastname = ln;
        //this.email = em;

        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(emailRegex);
        String emailR = em;
        boolean res = pattern.matcher(emailR).matches();
        if(res == true){
           this.email = em;

        }
        else throw new IllegalArgumentException("Email not Valid");

    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString(){
        return "Firstname: "+firstname +"\nLastname: "+ Lastname+ "\n" +
                "email: " +email;
    }



}
