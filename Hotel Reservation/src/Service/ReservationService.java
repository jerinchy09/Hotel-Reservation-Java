package Service;

import model.*;

import java.util.*;
import java.util.stream.Collectors;

public class ReservationService {
    private static ReservationService resObj;
    private static List<Room> rooms = new ArrayList<>();
    private final static Set<Reservation> reservations = new HashSet<>();

    public List<Room> getRooms() {
        System.out.println(rooms);
        return rooms;
    }

    public Set<Reservation> getReservations() {
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

        }catch(IllegalArgumentException e){
            System.out.println("Please try again.");
        }
    }
    public IRoom getARoom(String roomId){
        for(Room rm : rooms ) {
            if(rm.getRoomNumber().equals(roomId)){
                return rm;
            }
        }
        return null;

    }

    public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate){

        Reservation reservation = new Reservation(customer, room, checkInDate, checkOutDate);
        reservations.add(reservation);
        System.out.println("Room booked!");
        System.out.println(reservation);

        return reservation;

    }
    public Collection<IRoom> findRooms(Date CheckInDate, Date CheckOutDate) {
//        ArrayList<IRoom> noRooms = new ArrayList<>();
//        if(CheckInDate.before(new Date()) || CheckOutDate.before(new Date())){
//            return noRooms;
//        }
//        if(CheckInDate.after(CheckOutDate) || CheckOutDate.equals(CheckInDate)){
//            return noRooms;
//        }

        List<IRoom> unavailableRooms = reservations.stream()
                                                  .filter(r->CheckOutDate.after(r.getCheckInDate()) && CheckInDate.before(r.getCheckOutDate()))
                                                  .map(Reservation::getRoom)
                                                  .collect(Collectors.toCollection(ArrayList::new));
        return rooms.stream()
                .filter(r->!unavailableRooms.contains(r))
                .collect(Collectors.toCollection(ArrayList::new));


    }
    public Collection<Reservation> getCustomersReservation(Customer customer){
        List<Reservation> customerReservation = new ArrayList<>();

        for(Reservation res: reservations){
            if (res.getCustomer().equals(customer)){
                customerReservation.add(res);
            }
        }
        return customerReservation;
    }


}
