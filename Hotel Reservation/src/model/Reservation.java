package model;

import java.util.Date;

public class Reservation {
    private Customer customer;
    private IRoom room;
    private Date CheckInDate;
    private Date CheckOutDate;

    public Reservation(Customer customer, IRoom room, Date checkIn, Date checkOut){
            this.customer = customer;
            this.room = room;
            this.CheckInDate = checkIn;
            this.CheckOutDate = checkOut;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public IRoom getRoom() {
        return room;
    }

    public void setRoom(IRoom room) {
        this.room = room;
    }

    public Date getCheckInDate() {
        return CheckInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        CheckInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return CheckOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        CheckOutDate = checkOutDate;
    }

    @Override
    public String toString(){
        return customer +" "+room +" "+CheckInDate +" "+CheckOutDate;
    }
}
