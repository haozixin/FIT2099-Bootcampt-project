import java.util.ArrayList;
import java.util.Random;

abstract public class Vehicle {
    private String make;
    private String model;
    private ArrayList<Bid> bids;
    private int vId;
    
    public Vehicle(String make, String model) {
        vId = this.nextID();
        bids = new ArrayList<>();
        this.make = make;
        this.model = model;

    }
    public Vehicle(int vId, String make, String model){
        this.make = make;
        this.model = model;
        this.vId = vId;
        bids = new ArrayList<>();
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


        String bidId = String.valueOf((int)(Math.random()*1000000));
        Bid bid = new Bid(bidId,newBuyer,price,date);
        bids.add(bid);
    }
    public int nextID(){
        Random r = new Random();
        int low = 100000;//using literal values is not a good idea, replace them with input parameters
        int high = 999999;
        return (r.nextInt(high - low) + low);
    }

    public ArrayList<Bid> getBids() {
        return bids;
    }
}
