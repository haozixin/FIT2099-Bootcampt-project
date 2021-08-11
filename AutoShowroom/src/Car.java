import java.util.ArrayList;

public class Car {
    private String make;
    private String model;

    private ArrayList<Bid> bids;


    public Car(String make, String model) {
        bids = new ArrayList<>();
        this.make = make;
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String description(){

        return  String.format("Maker:%s and Model:%s",getMake(),getModel());
    }

    public void addBid(Buyer newBuyer, Float price, String date){
        Bid bid = new Bid(newBuyer,price,date);
        bids.add(bid);
    }

    public ArrayList<Bid> getBids() {
        return bids;
    }
}
