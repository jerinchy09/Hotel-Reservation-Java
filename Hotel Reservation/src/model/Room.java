package model;

import java.util.*;

public class Room implements IRoom{
    private final String roomNumber;
    private final Double roomprice;
    private final RoomType roomType;
    private boolean isFree;
   // private RoomType enumeration;
    private boolean isAvailable;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Room)) return false;
        Room room = (Room) o;
        return isFree == room.isFree && isAvailable == room.isAvailable && Objects.equals(roomNumber, room.roomNumber) && Objects.equals(roomprice, room.roomprice) && roomType == room.roomType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomNumber, roomprice, roomType, isFree, isAvailable);
    }

    public Room(String roomNumber, Double price, RoomType roomType){
        this.roomNumber = roomNumber;
        this.roomprice = price;
        this.roomType = roomType;
        boolean isAvailable = true;
        if(roomprice == 0){
            isFree = true;
        }else{
            isFree = false;
        }

    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public String getRoomNumber() {
        return roomNumber;
    }
    @Override
    public Double getRoomPrice() {
        return roomprice;
    }
    @Override
    public RoomType getRoomType() {
        return roomType;
    }

    @Override
    public boolean isFree() {
        return isFree;
    }
    @Override
    public String toString() {
        return "Room{" +
                "roomNumber='" + roomNumber + '\'' +
                ", roomprice=" + roomprice +
                ", roomType=" + roomType +
                '}';
    }


}
