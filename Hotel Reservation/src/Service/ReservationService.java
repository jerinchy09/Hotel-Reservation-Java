package Service;

import model.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ReservationService {
    private static ReservationService resObj;
    private static List<Room> rooms = new ArrayList<>();
    private static List<Reservation> reservations = new ArrayList<>();

    public List<Room> getRooms() {
        return rooms;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public static ReservationService getInstance(){
        if(resObj == null) {
            resObj = new ReservationService();
        }
        return resObj;

    }
    public void addRoom(IRoom room){
        try{

            Room rm = new Room(room.getRoomNumber(), room.getRoomPrice(), room.getRoomType());
            rooms.add(rm);
            System.out.println("Room Added" );
            AdminMenu.AdminMenu();
            // rooms.add(room.getRoomNumber(),room.getRoomPrice(),room.getRoomType());
//            System.out.println("Room Added");
//            MainMenu.Mainmenu();
        }catch(IllegalArgumentException e){
            System.out.println("Please try again.");
        }
    }
    public IRoom getARoom(String roomId){

        return null;

    }
    public List<Room> getAllRoom(){
        for(Room rm: rooms){
            System.out.println("Room number: "+ rm.getRoomNumber() +
                    " Room Price: "+rm.getRoomPrice() +
                    " Room Type: "+ rm.getRoomType());
        }
        return rooms;
    }
    public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate){
//        if(checkInDate.before(new Date())|| checkOutDate.before(checkInDate)){
//            System.out.println("Wrong Date");
//        }
//        if (IfDatesAvailable(room, checkInDate, checkOutDate)) {
//            Reservation reservation = new Reservation(customer, room, checkInDate, checkOutDate);
//            reservations.add(reservation);
//            return reservation;
//        }
        Reservation reservation = new Reservation(customer, room, checkInDate, checkOutDate);
        reservations.add(reservation);
        System.out.println("Room booked!");
        return reservation;

    }
    public List<IRoom> findRooms(Date CheckInDate, Date CheckOutDate) {
        ArrayList<IRoom> noRooms = new ArrayList<>();
        if(CheckInDate.before(new Date())|| CheckOutDate.before(new Date())){
            return noRooms;
        }
        if(CheckInDate.equals(CheckOutDate)|| CheckInDate.after(CheckOutDate)){
            return noRooms;
        }
       List<IRoom> unavailableRoom = new ArrayList<>();

       // List<IRoom> unavailableRoom = reservations.stream().filter(r-> (CheckOutDate.after(r.getCheckInDate()))&& CheckInDate.before(r.getCheckOutDate())).map(Reservation::getRoom).collect(Collectors.toCollection(ArrayList::new));
       // return rooms.values().stream().filter(r->!unavailableRoom.contains((r)).collect(Collectors.toCollection(ArrayList::new)));

        return unavailableRoom;
    }
//    public List<Reservation> getCustomersReservation(Customer customer){
//        return reservations;
//
//    }
    public void printAllReservation(){

    }


}
