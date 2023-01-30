package model;

import Service.ReservationService;
import api.HotelResource;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

public class MainMenu {
    private static HotelResource hotelResource=HotelResource.getInstance();
    private static ReservationService rsvobj=ReservationService.getInstance();
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
            //Scanner scanner = new Scanner(System.in);

           // while((response >= 1) && (response <= 5)) {
                try {
                    int response = scanner.nextInt();
                    switch (response) {
                        case 1:
                            finsAndReserveARoom();
                            break;
                        case 2:
                        //                    ReservationService rs = new ReservationService();
                        //                    rs.getCustomersReservation();
                        //                    break;
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
                            break;
                        default:
                            //throw new IllegalStateException("Unexpected value: " + response);
                            System.out.println("Invalid Input");

                    }
                }
                catch (Exception e){
                    System.out.println("Invalid Input");
                    scanner.next();

                }
        }

    }
    public static void seeMyReservation(){}
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
            System.out.println("Enter your email address: ");
            Scanner scanner = new Scanner(System.in);
            String email = scanner.next();

            System.out.println("Which room would you like to reserve? Enter room number\n");
            rsvobj.getAllRoom();
            String roomnumber = scanner.next();
            for (Room room : rooms) {
                if (room.getRoomNumber().contains(roomnumber)) {

//                    Double price = room.getRoomPrice();
//                    RoomType roomType = room.getRoomType();
                    System.out.println(" got it " );
                }
                System.out.println(room.getRoomPrice());

            }



            //IRoom bookroom= new Room();
          //  bookroom.getRoomNumber();
//            System.out.println("Enter check-in Date: (Please use this format dd/mm/yy) ");
//            String checkinDate = scanner.next();
//            SimpleDateFormat dateF = new SimpleDateFormat("dd/MM/yyyy");
//            Date checkInDate = dateF.parse(checkinDate);
//
//            System.out.println("Enter check-out Date: ");
//            String checkoutDate = scanner.next();
//            Date checkOutDate = dateF.parse(checkoutDate);
//
//            hotelResource.bookARoom(email, roomnumber, checkinDate, checkoutDate);


        } catch (Exception e) {
            System.out.println("Exception is: " + e.toString());
        }
    }

}
