package Service;

import model.*;

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
        System.out.println(rooms);
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
        List<IRoom> availableRoom = new ArrayList<>();
        List<Reservation> filterReservations = new ArrayList<>();
        //.stream
        for(Reservation res: reservations){
            //.filter
            if((CheckOutDate.after(res.getCheckInDate())) && CheckInDate.before(res.getCheckOutDate())){
                filterReservations.add(res);
                System.out.println("reservation Added");
            }
            else System.out.println("Please enter a valid date for check-in and check-out");
        }
        List<IRoom> mapRoom = new ArrayList<>();
        //.map(Reservation::getRoom)
        for(Reservation mapRes: filterReservations){
            System.out.println(mapRoom.add(mapRes.getRoom()));
        }

            return rooms.stream()
                    .filter(r->!availableRoom.contains(r))
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
    public Collection<Reservation> printAllReservation() {

        return reservations;
    }
}
