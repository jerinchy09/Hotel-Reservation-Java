package model;

public interface IRoom {
    public String getRoomNumber(String rn);
    public Double getRoomPrice();
    public roomType getRoomType();
    public boolean isFree();

}
