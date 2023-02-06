package model;

import java.util.Date;
import java.util.Objects;

public class Reservation {
    private final Customer customer;
    private final IRoom room;
    private final Date CheckInDate;
    private final Date CheckOutDate;

    private boolean isAvailable;

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


    public boolean isAvailable() {
        return isAvailable;
    }

    public Reservation(Customer customer, IRoom room, Date checkIn, Date checkOut){
            this.customer = customer;
            this.room = room;
            this.CheckInDate = checkIn;
            this.CheckOutDate = checkOut;
            isAvailable = false;
    }

    public Customer getCustomer() {
        return customer;
    }
    public IRoom getRoom() {
        return room;
    }
    public Date getCheckInDate() {
        return CheckInDate;
    }
    public Date getCheckOutDate() {
        return CheckOutDate;
    }
    @Override
    public String toString(){
        return customer +" "+room +" "+CheckInDate +" "+CheckOutDate;
    }
}
