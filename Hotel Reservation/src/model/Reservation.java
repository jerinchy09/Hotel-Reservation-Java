package model;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Reservation {
    private final Customer customer;
    private final IRoom room;
    private final LocalDate CheckInDate;
    private final LocalDate CheckOutDate;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reservation)) return false;
        Reservation that = (Reservation) o;
        return customer.equals(that.customer) && room.equals(that.room) && CheckInDate.equals(that.CheckInDate) && CheckOutDate.equals(that.CheckOutDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customer, room, CheckInDate, CheckOutDate);
    }


//    public boolean isAvailable(Date checkInDate , Date checkOutDate) {
//        if(checkInDate.equals(checkOutDate)){
//        isAvailable=true;
//        }
//        return isAvailable;
//    }

    public Reservation(Customer customer, IRoom room, LocalDate checkIn, LocalDate checkOut){
            this.customer = customer;
            this.room = room;
            this.CheckInDate = checkIn;
            this.CheckOutDate = checkOut;
            //this.isAvailable = isAvailable;


    }
//
//    public void setAvailable(boolean available) {
//        isAvailable = available;
//    }
//
//    public boolean isAvailable(){
//            return isAvailable;
//    }

    public Customer getCustomer() {
        return customer;
    }
    public IRoom getRoom() {
        return room;
    }
    public LocalDate getCheckInDate() {
        return CheckInDate;
    }
    public LocalDate getCheckOutDate() {
        return CheckOutDate;
    }
    @Override
    public String toString(){
        return customer +" "+room +" "+CheckInDate +" "+CheckOutDate;
    }
}
