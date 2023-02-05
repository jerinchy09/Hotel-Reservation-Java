package api;

import Service.CustomerService;
import Service.ReservationService;
import model.Customer;
import model.IRoom;
import model.Reservation;


import java.text.ParseException;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class HotelResource {
    private static HotelResource hotelResObj;
    private static final CustomerService custObj = CustomerService.getInstance();
    private static final ReservationService resObj = ReservationService.getInstance();
    public static void getHotelResObj(HotelResource hotelResObj) {
        HotelResource.hotelResObj = hotelResObj;
    }
    public static HotelResource getInstance(){
        if(hotelResObj == null) {
            hotelResObj = new HotelResource();
        }
        return hotelResObj;
    }
    private HotelResource(){

    }
    public Customer getCustomer(String email){
            try {
                return custObj.getCustomer(email);
            } catch (Exception e) {
                System.out.println("Failed to retrieve customer");
                throw new RuntimeException(e);
            }

    }
    public void createACustomer(String firstName, String lastName, String email){
        custObj.addCustomer(firstName,lastName,email);

    }
    public IRoom getRoom(String roomNumber){
        return resObj.getARoom(roomNumber);

    }
    public Reservation bookARoom(String customerEmail, IRoom room, Date checkInDate, Date checkOutDate){
        return resObj.reserveARoom(getCustomer(customerEmail),room,checkInDate,checkOutDate);

    }
    public Collection<Reservation> getCustomersReservations(String customerEmail) throws Exception{

            Customer customer = custObj.getCustomer(customerEmail);
            return resObj.getCustomersReservation(customer);
    }
    public List<IRoom> findARoom(Date checkIn, Date checkOut) throws ParseException {
        return resObj.findRooms(checkIn, checkOut);

    }


}

