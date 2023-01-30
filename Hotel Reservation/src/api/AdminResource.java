package api;

import Service.CustomerService;
import Service.ReservationService;
import model.Customer;
import model.IRoom;
import model.RoomType;

import java.util.Collection;
import java.util.List;

public class AdminResource {
    private static AdminResource adminResObj;
    private static final ReservationService resvObj = ReservationService.getInstance();

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
        resvObj.addRoom(new IRoom() {
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
        });
    }
    public List<IRoom> getAllRooms(){
        return null;

    }
    public Collection<Customer> getAllCustomers(){
        return null;
    }
    public void displayAllReservations(){

    }
}
