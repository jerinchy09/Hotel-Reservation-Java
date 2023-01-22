package Service;

import model.Customer;
import model.IRoom;
import model.Reservation;

import java.util.Collection;
import java.util.Date;

public class ReservationService {
    public void addRoom(IRoom room){

    }
    public IRoom getARoom(String roomId){
        return null;
    }
    public Reservation serveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate){
        return null;
    }
    public Collection<IRoom> findRooms(Date CheckInDate, Date CheckOutDate){
        return null;

    }
    public Collection<Reservation> getCustomersReservation(Customer customer){
        return null;

    }
    public void printAllReservation(){}

}
