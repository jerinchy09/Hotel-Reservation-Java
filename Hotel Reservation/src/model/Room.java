package model;

import java.util.*;

public class Room implements IRoom{
    private String roomNumber;
    private Double price;
    private roomType enumeration;

//
//    public Room(String roomNumber, Double price, roomType enumeration){
//            this.roomNumber = roomNumber;
//            this.price = price;
//            this.enumeration = enumeration;
//
//    }
    public void room (){
        System.out.println("Enter room number: ");
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        this.setRoomNumber(input);

        System.out.println("Enter price per night: ");
        Scanner scp = new Scanner(System.in);
        Double inputPrice = scp.nextDouble();
        this.setPrice(inputPrice);

        System.out.println("Enter room type: 1 for single bed, 2 for double bed ");
        Scanner scType = new Scanner(System.in);
        String inputType = scType.next();
        this.setEnumeration(inputType);

        System.out.println("Do you want to add another room?");


    }
    @Override
    public String toString() {
        return "Room{" +
                "roomNumber='" + roomNumber + '\'' +
                ", Room price=" + price +
                ", Room type=" + enumeration +
                '}';
    }
    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {

        Set<String> rn = new HashSet<String>();
        rn.add(roomNumber);
        for (String r : rn)
            System.out.println(r);
        //this.roomNumber = roomNumber;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {

        List<Double> rp = new <String>ArrayList();
        rp.add(price);
        for (Double p : rp)
            System.out.println(p);
    }

    public roomType getEnumeration() {
        return enumeration;
    }

    public void setEnumeration(String enumeration) {
        List<String> rtype = new <String>ArrayList();

        if (enumeration == "1") enumeration = "SINGLE";
        else enumeration = "DOUBLE";
        rtype.add(enumeration);
        for (String rt : rtype){
            System.out.println(rt);
        }
        //this.enumeration = enumeration;
    }

    @Override
    public String getRoomNumber(String rn) {
        return null;
    }

    @Override
    public Double getRoomPrice() {
        return null;
    }

    @Override
    public roomType getRoomType() {
        return null;
    }

    @Override
    public boolean isFree() {
        return false;
    }


}
