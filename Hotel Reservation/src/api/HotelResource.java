package api;

import Service.CustomerService;
import Service.ReservationService;
import model.*;


import java.text.ParseException;
import java.time.LocalDate;
import java.util.Collection;


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
                if(CUSTOMER_SERVICE.getCustomer(email)==null){
                    MainMenu.Mainmenu();
                }
                return CUSTOMER_SERVICE.getCustomer(email);

            } catch (Exception e) {
                System.out.println("Failed to retrieve customer");
                throw new RuntimeException(e);
            }

    }
    public void createACustomer(String firstName, String lastName, String email){
        CUSTOMER_SERVICE.addCustomer(firstName,lastName,email);

    }
    public IRoom getRoom(String roomNumber) throws Exception {
            return RESERVATION_SERVICE.getARoom(roomNumber);

    }
    public Reservation bookARoom(String customerEmail, IRoom room, LocalDate checkInDate, LocalDate checkOutDate){
        return RESERVATION_SERVICE.reserveARoom(getCustomer(customerEmail),room,checkInDate,checkOutDate);

    }
    public Collection<Reservation> getCustomersReservations(String customerEmail) throws Exception{

        Customer customer = CUSTOMER_SERVICE.getCustomer(customerEmail);
        return RESERVATION_SERVICE.getCustomersReservation(customer);
    }
    public Collection<IRoom> findARoom(LocalDate checkIn, LocalDate checkOut) throws ParseException {
        return RESERVATION_SERVICE.findRooms(checkIn, checkOut );
    }
    public Boolean DateValidation(LocalDate checkin , LocalDate checkout){
        boolean validate;
        LocalDate today = LocalDate.now();
        if(!checkin.equals(checkout)
                    &&
                    checkin.isBefore(checkout)
                    &&
                (checkin.isAfter(today) || checkin.isEqual(today))
                    &&
                    checkout.isAfter(today)
                    &&
                    checkout.isAfter(checkin)
        ){
            validate= true;
        }else {
            validate= false;
            System.out.println("Not a valid date");
            MainMenu.Mainmenu();
        }

        return validate;
    }

}

