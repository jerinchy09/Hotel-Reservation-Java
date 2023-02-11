package model;

import Service.CustomerService;
import Service.ReservationService;
import api.AdminResource;
import api.HotelResource;

import java.util.*;
import java.util.regex.Pattern;

public class AdminMenu {
    private static final CustomerService custObj = CustomerService.getInstance();
    private static AdminResource ADMIN_RESOURCE= AdminResource.getInstance();
    //private static ReservationService rsvobj=ReservationService.getInstance();
    private static Set<Room> rooms = new HashSet<>();
    //private static String inputroomNumber;
    private static HotelResource HOTEL_RESOURCE=HotelResource.getInstance();

    public static void AdminMenu() {
        while (true) {
            System.out.println("Welcome to Hotel Reservation Admin Menu.");
            System.out.println("--------------------------------------");
            System.out.println("1. See all customers");
            System.out.println("2. See all rooms");
            System.out.println("3. See all reservations");
            System.out.println("4. Add a room");
            System.out.println("5. Back to Main menu");
            System.out.println("(Only Press number 1-5)");

            Scanner scanner = new Scanner(System.in);
            int response = scanner.nextInt();

            if ((response >= 1) && (response <= 5)) {
                switch (response) {
                    case 1:
                        ADMIN_RESOURCE.displayAllCustomers();
                        break;
                    case 2:

                        ADMIN_RESOURCE.getAllRooms();
                        break;
                    case 3:
                        seeAllReservation();
                        break;
                    case 4:
                        addroom();
                        break;
                    case 5:
                        MainMenu Mmenu = new MainMenu();
                        Mmenu.Mainmenu();
                        break;

                    default:
                        throw new IllegalStateException("Unexpected value: " + response);
                }
            } else throw new IllegalArgumentException("Input not Valid");

        }
    }
    public static void addroom(){
        String inputroomNumber;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter room number: ");

       //boolean roomInput= true;
        while(true) {
            try {
                inputroomNumber = sc.next();
                String RoomNoRegex = "[0-9]+";
                Pattern pattern = Pattern.compile(RoomNoRegex);
                boolean res = pattern.matcher(inputroomNumber).matches();

                if (res == true){
                    if(HOTEL_RESOURCE.getRoom(inputroomNumber)!=null ){
                        System.out.println("Room Exist");
                        continue;
                    }break;
                }
                else{
                    throw new IllegalArgumentException();
                }


            } catch (IllegalArgumentException e) {
                System.out.println("Please enter a valid room number.");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Enter room Price: ");
        Double inputroomPrice = sc.nextDouble();
        System.out.println("Enter room Type: (Please type Single or Double)");
        String inputroomType = sc.next();
        RoomType roomtype = RoomType.valueOf(inputroomType.toUpperCase());

        if(roomtype.equals(RoomType.SINGLE) || roomtype.equals(RoomType.DOUBLE)  ){
           ADMIN_RESOURCE.addRoom(inputroomNumber, inputroomPrice, roomtype);
        }
        else{
            System.out.println("Please enter 'Single' or 'Double'");
        }
    }
    public static void seeAllReservation(){
        ADMIN_RESOURCE.displayAllReservations();

    }
}
