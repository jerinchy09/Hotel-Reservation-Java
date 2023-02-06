package model;

import java.util.Objects;

public class FreeRoom extends Room {
    private Double price = 0.0;


    public FreeRoom(String roomNumber, RoomType roomType) {
        super(roomNumber, (double) 0, roomType);

    }
    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}


