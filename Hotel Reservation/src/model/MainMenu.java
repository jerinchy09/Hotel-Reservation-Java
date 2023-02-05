package model;

import Service.CustomerService;
import Service.ReservationService;
import api.HotelResource;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

import static java.lang.System.exit;

public class MainMenu {
    private static HotelResource hotelResource=HotelResource.getInstance();
    private static ReservationService rsvobj=ReservationService.getInstance();
    private static CustomerService custobj=CustomerService.getInstance();


    private static List<Room> rooms = new ArrayList<>();

    public static void Mainmenu() {
        final Scanner scanner = new Scanner(System.in);
        Boolean looping = true;
        while (looping) {
            System.out.println("Welcome to Hotel Reservation.");
            System.out.println("--------------------------------------");
            System.out.println("1. Find and reserve a room");
            System.out.println("2. See my reservations");
            System.out.println("3. Create an account");
            System.out.println("4. Admin");
            System.out.println("5. Exit");

            System.out.println("(Only Press number 1-5)\n");

                try {
                    int response = scanner.nextInt();
                    switch (response) {
                        case 1:
                            finsAndReserveARoom();
                            break;
                        case 2:
                            seeMyReservation();
                            break;
                        case 3:
                            createAnAccount();
                            break;
                        case 4:
                            AdminMenu ad = new AdminMenu();
                            ad.AdminMenu();
                            break;
                        case 5:
                            System.exit(0);
                            //break;
                        default:
                            System.out.println("Invalid Input");

                    }
                }
                catch (Exception e){
                    System.out.println("Invalid Input");
                    scanner.next();

                }
        }

    }
    public static void seeMyReservation(){
        System.out.println("Enter email address: ");
        Scanner scanner = new Scanner(System.in);
        Customer customer = hotelResource.getCustomer(scanner.next());
        System.out.println(rsvobj.getCustomersReservation(customer));
        System.out.println(customer.getFirstname()+" "+customer.getLastname() +"has booked Room ");

    }
    public static boolean confirmReservation(Optional<IRoom> roomChosen){
//        Scanner sc = new Scanner(System.in);
//        String choice = null;
//        if(roomChosen.isPresent()){
//            System.out.println("Book? Enter y or n");
//            do{
//
//            }while();
//
//        }
        return false;
    }
    public static void createAnAccount(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first name:");
        String firstname= scanner.next();
        System.out.println("Enter last name:");
        String lastname= scanner.next();
        System.out.println("Enter email address:");
        String email= scanner.next();

        hotelResource.createACustomer(firstname, lastname, email);
        scanner.close();
    }

    private static void finsAndReserveARoom(){
        try {
            System.out.println("Please Enter your Email address: ");
            Scanner scanner = new Scanner(System.in);

            Customer customer = hotelResource.getCustomer(scanner.next());

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MM-dd");
            System.out.println("Enter check-in date - format yyyy-mm-dd");
            String checkIn = scanner.next();
            Date checkInDate = dateFormat.parse(checkIn);
            System.out.println("Enter check-Out date - format yyyy-mm-dd");
            String checkOut = scanner.next();
            Date checkOutDate = dateFormat.parse(checkOut);

            //List<IRoom> availableRooms = hotelResource.findARoom(checkInDate, checkOutDate);

          //  if (!availableRooms.isEmpty()) {
                System.out.println("Which room would you like to book? Enter room Id");
                //rsvobj.getAllRoom();

                hotelResource.findARoom(checkInDate,checkOutDate);
                String roomId = scanner.next();
                IRoom room = hotelResource.getRoom(roomId);

                hotelResource.bookARoom(  customer.getEmail(), room, checkInDate, checkOutDate);
                System.out.println("Room "+roomId+ " is booked for " + custobj.getCustomer(customer.getEmail()));

        } catch (Exception e) {
            System.out.println("Exception is: " + e.toString());
        }
    }


}
