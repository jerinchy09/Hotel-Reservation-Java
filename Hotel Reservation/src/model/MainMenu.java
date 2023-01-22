package model;

import Service.ReservationService;

import java.util.Scanner;
import java.util.regex.Pattern;

public class MainMenu {

    //1.Find and reserve a room
    //2. See my reservations
    //3. Create an account
    //4. Admin
    //5. Exit

    public void Mainmenu() {
        System.out.println("Welcome to Hotel Reservation.");
        System.out.println("--------------------------------------");
        System.out.println("1. Find and reserve a room");
        System.out.println("2. See my reservations");
        System.out.println("3. Create an account");
        System.out.println("4. Admin");
        System.out.println("5. Exit");

        System.out.println("(Only Press number 1-5)\n");

        Scanner scanner = new Scanner(System.in);
        int response = scanner.nextInt();

        if((response >= 1) && (response <= 5) ){
            switch(response) {
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
                    AdminMenu ad = new AdminMenu();
                    ad.Adminmenu();
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
