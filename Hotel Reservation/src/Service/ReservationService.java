package Service;

import model.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

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
//    public Collection<IRoom> getAllRoom(){
//        for(Room rm: rooms){
//            System.out.println("Room number: "+ rm.getRoomNumber() +
//                    " Room Price: "+rm.getRoomPrice() +
//                    " Room Type: "+ rm.getRoomType());
//        }
//        return rooms;
//    }
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
        System.out.println(reservation);
        return reservation;

    }
    public List<IRoom> findRooms(Date CheckInDate, Date CheckOutDate) {
        //ArrayList<IRoom> noRooms = new ArrayList<>();
//        if(CheckInDate.before(new Date())|| CheckOutDate.before(new Date())){
//            System.out.println("No rooms");
//           // return noRooms;
//        }
//        if(CheckInDate.equals(CheckOutDate)|| CheckInDate.after(CheckOutDate)){
//            //return noRooms;
//            System.out.println("No rooms");
//
//        }
        List<IRoom> availableRoom = new ArrayList<>();
        List<Reservation> filterReservations = new ArrayList<>();

        //.stream
        for(Reservation res: reservations){

            //.filter
            if((CheckOutDate.after(res.getCheckInDate())) && CheckInDate.before(res.getCheckOutDate())){
                filterReservations.add(res);
            }
            else System.out.println("Please enter a valid date for check-in and check-out");
        }
        List<IRoom> mapRoom = new ArrayList<>();
        //.map(Reservation::getRoom)
        for(Reservation filRes: filterReservations){
            System.out.println(mapRoom.add(filRes.getRoom()));

        }
//        List<IRoom> unavailableRoom = reservations.stream()
//                .filter(r-> (CheckOutDate.after(r.getCheckInDate())) && CheckInDate.before(r.getCheckOutDate()))
//                .map(Reservation::getRoom)
//                .collect(Collectors.toCollection(ArrayList::new));
      //  return rooms.values().stream().filter(r->!unavailableRoom.contains((r)).collect(Collectors.toCollection(ArrayList::new)));
        if(!rooms.contains(mapRoom)){

        }
        else{System.out.println("No room Available");}
        return availableRoom;
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
