package api;

import Service.CustomerService;
import Service.ReservationService;
import model.*;


import java.text.ParseException;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class HotelResource {
    private static HotelResource hotelResObj;
    private static final CustomerService CUSTOMER_SERVICE = CustomerService.getInstance();
    private static final ReservationService RESERVATION_SERVICE = ReservationService.getInstance();
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
                return CUSTOMER_SERVICE.getCustomer(email);
            } catch (Exception e) {
                System.out.println("Failed to retrieve customer");
                throw new RuntimeException(e);
            }

    }
    public void createACustomer(String firstName, String lastName, String email){
        CUSTOMER_SERVICE.addCustomer(firstName,lastName,email);

    }
    public IRoom getRoom(String roomNumber){
        return RESERVATION_SERVICE.getARoom(roomNumber);

    }
    public Reservation bookARoom(String customerEmail, IRoom room, Date checkInDate, Date checkOutDate){
        return RESERVATION_SERVICE.reserveARoom(getCustomer(customerEmail),room,checkInDate,checkOutDate);

    }
    public Collection<Reservation> getCustomersReservations(String customerEmail) throws Exception{

            Customer customer = CUSTOMER_SERVICE.getCustomer(customerEmail);
            return RESERVATION_SERVICE.getCustomersReservation(customer);
    }
    public Collection<IRoom> findARoom(Date checkIn, Date checkOut) throws ParseException {
        if(RESERVATION_SERVICE.findRooms(checkIn, checkOut ).isEmpty()){
            System.out.println("No Rooms Available");
            MainMenu.Mainmenu();
        }
        return RESERVATION_SERVICE.findRooms(checkIn, checkOut );

    }


}

