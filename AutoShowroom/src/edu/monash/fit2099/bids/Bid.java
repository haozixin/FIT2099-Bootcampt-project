package edu.monash.fit2099.bids;

import edu.monash.fit2099.buyers.Buyer;

import java.util.Random;
import java.util.Scanner;

public class Bid {
    private String bidId;
    private Buyer buyer;
    private float bidPrice; //since assuming the unit of price is "Thousands"
    private String bidDate;



    public Bid(Buyer buyer, float bidPrice, String bidDate) {

        this.bidId = nextID();
        this.buyer = buyer;
        this.bidPrice = bidPrice;
        this.bidDate = bidDate;
    }

    public void setBidId(String bidId) {
        this.bidId = bidId;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public void setBidPrice(float bidPrice) {
        this.bidPrice = bidPrice;
    }

    public void setBidDate(String bidDate) {
        this.bidDate = bidDate;
    }

    public String getBidId() {
        return bidId;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public float getBidPrice() {
        return bidPrice;
    }

    public String getBidDate() {
        return bidDate;
    }
    public String nextID(){
        Random r = new Random();
        int low = 100000;//using literal values is not a good idea, replace them with input parameters
        int high = 999999;
        return String.valueOf(r.nextInt(high - low) + low);
    }
}
