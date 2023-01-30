package model;

import java.util.*;

public class Room implements IRoom{
    private final String roomNumber;
    private final Double roomprice;
    private final RoomType roomType;
    private boolean isFree;
   // private RoomType enumeration;


    public Room(String roomNumber, Double price, RoomType roomType){
        this.roomNumber = roomNumber;
        this.roomprice = price;
        this.roomType = roomType;
        if(roomprice == 0){
            isFree = true;
        }else{
            isFree = false;
        }

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

    public void setFree(boolean free) {
        isFree = free;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber='" + roomNumber + '\'' +
                ", roomprice=" + roomprice +
                ", roomType=" + roomType +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return roomNumber.equals(room.roomNumber) && roomType == room.roomType;
    }

    @Override
    public int hashCode() {

        return Objects.hash(roomNumber, roomType);
    }
    //
//    public void room (){
//        System.out.println("Enter price per night: ");
//        Scanner scp = new Scanner(System.in);
//        Double inputPrice = scp.nextDouble();
//        this.setPrice(inputPrice);
//
//        System.out.println("Enter room type: 1 for single bed, 2 for double bed ");
//        Scanner scType = new Scanner(System.in);
//        String inputType = scType.next();
//        this.setEnumeration(inputType);
//
//        System.out.println("Do you want to add another room?");
//
//    }
//    @Override
//    public String toString() {
//        return "Room{" +
//                "roomNumber='" + roomNumber + '\'' +
//                ", Room price=" + price +
//                ", Room type=" + enumeration +
//                '}';
//    }
//    public String getRoomNumber() {
//        return roomNumber;
//    }
//    public void setRoomNumber(String roomNumber) {
//        //Set<String> rn = new HashSet<String>();
//        List<IRoom> rooms = new ArrayList<>();
//       // rooms.add(roomNumber);
////        for (String r : rn)
////            System.out.println(r);
//        //this.roomNumber = roomNumber;
//    }
//
//    public Double getPrice() {
//        return price;
//    }
//    public void setPrice(Double price) {
//        List<Double> rp = new <String>ArrayList();
//        rp.add(price);
//        for (Double p : rp)
//            System.out.println(p);
//    }
//    public RoomType getEnumeration() {
//        return enumeration;
//    }
//    public void setEnumeration(String enumeration) {
//        List<String> rtype = new <String>ArrayList();
//
//        if (enumeration == "1") enumeration = "SINGLE";
//        else enumeration = "DOUBLE";
//        rtype.add(enumeration);
//        for (String rt : rtype){
//            System.out.println(rt);
//        }
//        //this.enumeration = enumeration;
//    }



}
