package model;

public class FreeRoom extends Room{
    private Double price = 0.0;
    public FreeRoom( Double price){
        this.price =price;
    }

    @Override
    public String toString(){
        return "Free room price is: "+String.valueOf(price);
    }
}
