package model;

import Service.CustomerService;
import Service.ReservationService;
import api.HotelResource;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class MainMenu {
    private static HotelResource HOTEL_RESOURCE=HotelResource.getInstance();
//    private static ReservationService rsvobj=ReservationService.getInstance();
    private static CustomerService CUSTOMER_SERVICE=CustomerService.getInstance();


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
    public static void seeMyReservation() throws Exception {
        System.out.println("Enter email address: ");
        Scanner scanner = new Scanner(System.in);
        Customer customer = HOTEL_RESOURCE.getCustomer(scanner.next());
        System.out.println(HOTEL_RESOURCE.getCustomersReservations(customer.getEmail()));

        //System.out.println(customer.getFirstname()+" "+customer.getLastname() +"has booked Room ");

    }
    public static boolean confirmReservation(Optional<IRoom> roomChosen){
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

        HOTEL_RESOURCE.createACustomer(firstname, lastname, email);
        scanner.close();
    }

    private static void finsAndReserveARoom(){
        try {
            System.out.println("Please Enter your Email address: ");
            Scanner scanner = new Scanner(System.in);

            Customer customer = HOTEL_RESOURCE.getCustomer(scanner.next());

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MM-dd");
            System.out.println("Enter check-in date - format yyyy-mm-dd");
            String checkIn = scanner.next();
            Date checkInDate = dateFormat.parse(checkIn);
            System.out.println("Enter check-Out date - format yyyy-mm-dd");
            String checkOut = scanner.next();
            Date checkOutDate = dateFormat.parse(checkOut);



                System.out.println("Which room would you like to book? Enter room Id");
                //Recommended room

                Collection<IRoom> available_rooms = HOTEL_RESOURCE.findARoom(checkInDate, checkOutDate);
                List<String> availableRoomNo = available_rooms.stream().map(room -> room.getRoomNumber()).collect(Collectors.toList());
                System.out.println(available_rooms);
            while(true) {

                String roomId = scanner.next();

                for (String rm : availableRoomNo) {

                        if (rm.equals(roomId)) {
                            IRoom room = HOTEL_RESOURCE.getRoom(roomId);
                            HOTEL_RESOURCE.bookARoom(customer.getEmail(), room, checkInDate, checkOutDate);
                            MainMenu.Mainmenu();
                        } else {
                            System.out.println("Please enter a valid room ID");
                        }

                    }
                }


        } catch (Exception e) {
            System.out.println("Exception is: " + e.toString());
        }
    }


}
