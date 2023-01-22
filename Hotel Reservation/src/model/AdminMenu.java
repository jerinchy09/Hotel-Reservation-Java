package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class AdminMenu {

    //1. See al customers
    //2. See all rooms
    //3. See all reservations
    //4. Add a room
    //5. Back to Main Menu
    public void Adminmenu() {
        System.out.println("Welcome to Hotel Reservation Admin Menu.\n");
        System.out.println("--------------------------------------");
        System.out.println("1. See all customers");
        System.out.println("2. See all rooms");
        System.out.println("3. See all reservations");
        System.out.println("4. Add a room");
        System.out.println("5. Back to Main menu");
        System.out.println("");
        System.out.println("(Only Press number 1-5)");


        Scanner scanner = new Scanner(System.in);
        int response = scanner.nextInt();

        if((response >= 1) && (response <= 5) ) {
            switch (response) {
//                case 1:
//                    ReservationService r = new ReservationService();
//                    r.serveARoom();
//                    break;
//                case 2:
//                    ReservationService rs = new ReservationService();
//                    rs.getCustomersReservation();
//                    break;
//                case 3:
//                    ReservationService rc = new ReservationService();
//                    rc.serveARoom();
//                    break;
                case 4:
                    Room rm = new Room();
                    rm.room();
                   // rm.setRoomNumber(input);
                    break;
                case 5:
                    System.out.println("See you Soon.");
                    break;

                default:
                    throw new IllegalStateException("Unexpected value: " + response);
            }
        }
        else throw new IllegalArgumentException("Input not Valid");
    }
}
