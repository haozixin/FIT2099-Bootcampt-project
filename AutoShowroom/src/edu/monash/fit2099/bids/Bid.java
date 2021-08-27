package edu.monash.fit2099.bids;

import edu.monash.fit2099.buyers.Buyer;
import edu.monash.fit2099.utility.GenerateId;

public class Bid {
    private String bidId;
    private Buyer buyer;
    private float bidPrice; //since assuming the unit of price is "Thousands"
    private String bidDate;



    public Bid(Buyer buyer, float bidPrice, String bidDate) {

        this.bidId = GenerateId.nextID();
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

    @Override
    public String toString() {
        return "Bid{" +
                "bidId='" + bidId + '\'' +
                ", buyer=" + buyer +
                ", bidPrice=" + bidPrice +
                ", bidDate='" + bidDate + '\'' +
                '}';
    }
}
