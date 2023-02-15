package Service;

import api.HotelResource;
import model.*;

import java.time.LocalDate;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ReservationService {
    private static ReservationService resObj;
    private static Set<Room> rooms = new HashSet<>();
    private final static Set<Reservation> reservations = new HashSet<>();

    public Set<Room> getRooms() {
        System.out.println(rooms);
        return rooms;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public static ReservationService getInstance() {
        if (resObj == null) {
            resObj = new ReservationService();
        }
        return resObj;

    }

    public void addRoom(IRoom room) {
        try {

            Room rm = new Room(room.getRoomNumber(), room.getRoomPrice(), room.getRoomType());
            rooms.add(rm);
            System.out.println("Room Added");
            AdminMenu.AdminMenu();

        } catch (IllegalArgumentException e) {
            System.out.println("Please try again.");
        }
    }

    public IRoom getARoom(String roomId) throws Exception {
        for (IRoom room : rooms) {
            if (room.getRoomNumber().equals(roomId)) {
                return room;
            }
        }
        return null;
    }

    public Reservation reserveARoom(Customer customer, IRoom room, LocalDate checkInDate, LocalDate checkOutDate) {
        Reservation reservation = new Reservation(customer, room, checkInDate, checkOutDate);
        reservations.add(reservation);

        System.out.println("Room booked!");
        System.out.println(reservation);
        return reservation;

    }

    public Collection<IRoom> findRooms(LocalDate CheckInDate, LocalDate CheckOutDate) {
        List<Reservation> filterReservations = new ArrayList<>();
        //.stream
        for (Reservation res : reservations) {
            //.filter
            //System.out.println(res.getRoom().isAvailable());

            if ((CheckOutDate.isAfter(res.getCheckInDate())
                    || CheckOutDate.isEqual(res.getCheckInDate()))
                    &&
                    (CheckInDate.isBefore(res.getCheckOutDate())
                    ||CheckInDate.isBefore(res.getCheckOutDate())
                    || CheckInDate.isEqual(res.getCheckOutDate()))
                    &&
                    res.getRoom().isAvailable()


            ){
                filterReservations.add(res);
            } else if (CheckInDate.isAfter(res.getCheckOutDate())
                    ||CheckInDate.isBefore(res.getCheckOutDate())
                    || CheckInDate.isEqual(res.getCheckOutDate())){
                Room rm = new Room(res.getRoom().getRoomNumber(), res.getRoom().getRoomPrice(), res.getRoom().getRoomType());
                rooms.add(rm);
            }
            else {
                    System.out.println("Not a valid check-in/check-out date");
                    MainMenu.Mainmenu();
            }

        }
        List<IRoom> mapRoom = new ArrayList<>();

        //.map(Reservation::getRoom)
        for (Reservation mapRes : filterReservations) {
            mapRoom.add(mapRes.getRoom());

        }
        //reservations.retainAll(filterReservations);
        rooms.removeAll(mapRoom);
        List<IRoom> unreserved = new ArrayList<>(rooms);

        return unreserved;
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
