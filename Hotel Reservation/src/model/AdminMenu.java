package model;

import Service.CustomerService;
import Service.ReservationService;
import api.AdminResource;
import api.HotelResource;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

public class AdminMenu {
    private static final CustomerService custObj = CustomerService.getInstance();
    private static AdminResource adminObj= AdminResource.getInstance();
    private static ReservationService rsvobj=ReservationService.getInstance();

    private static HotelResource hotelResource=HotelResource.getInstance();

    public static void AdminMenu() {

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

        if((response >= 1) && (response <= 5) ) {
            switch (response) {
                case 1:
                    adminObj.displayAllCustomers();
                    break;
                case 2:

                    adminObj.getAllRooms();
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
        }
        else throw new IllegalArgumentException("Input not Valid");

    }

    public static void addroom(){
        System.out.println("Enter room number: ");
        Scanner sc = new Scanner(System.in);
        String inputroomNumber = sc.next();

        System.out.println("Enter room Price: ");
        Double inputroomPrice = sc.nextDouble();

        System.out.println("Enter room Type: ");
        String inputroomType = sc.next();

        RoomType roomtype = RoomType.valueOf(inputroomType.toUpperCase());
        adminObj.addRoom(inputroomNumber, inputroomPrice,roomtype);
    }
    public static void seeAllReservation(){
        adminObj.displayAllReservations();

    }
}
