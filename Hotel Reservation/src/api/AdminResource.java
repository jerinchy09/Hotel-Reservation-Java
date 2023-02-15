package api;

import Service.CustomerService;
import Service.ReservationService;
import model.*;

import java.util.Collection;
import java.util.List;

public class AdminResource {
    private static AdminResource adminResObj;
    private static final ReservationService RESERVATION_SERVICE = ReservationService.getInstance();
    private static final CustomerService CUSTOMER_SERVICE = CustomerService.getInstance();

    public static void getAdminResObj(AdminResource adminResObj) {
        AdminResource.adminResObj = adminResObj;
    }
    private AdminResource(){

    }
    public static AdminResource getInstance(){
        if(adminResObj == null) {
            adminResObj = new AdminResource();
        }
        return adminResObj;
    }
    public Customer getCustomer(String firstname, String lastname,String email){
        return null;
    }
    public void addRoom(String roomNum, Double price, RoomType roomType){
        RESERVATION_SERVICE.addRoom(new IRoom() {
            @Override
            public String getRoomNumber() {
                return roomNum;
            }

            @Override
            public Double getRoomPrice() {
                return price;
            }

            @Override
            public RoomType getRoomType() {
                return roomType;
            }

            @Override
            public boolean isFree() {
                return false;
            }

            @Override
            public boolean isAvailable() {
                return true;
            }
        });
    }
    public Collection<Room> getAllRooms(){

        return RESERVATION_SERVICE.getRooms();

    }
    public Collection<Customer> getAllCustomers(){

        return CUSTOMER_SERVICE.getAllCustomers();
    }
    public void displayAllReservations(){
        //resvObj.getReservations();
        for(Reservation res : RESERVATION_SERVICE.getReservations()) {
            System.out.println(res);
        }
    }
    public void displayAllCustomers(){
        for(Customer cus : getAllCustomers()) {
            System.out.println(cus);
        }
    }
}
