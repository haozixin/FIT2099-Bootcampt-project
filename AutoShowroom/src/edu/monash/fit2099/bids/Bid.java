package edu.monash.fit2099.bids;

import edu.monash.fit2099.buyers.Buyer;
import edu.monash.fit2099.exceptions.BidException;
import edu.monash.fit2099.utils.GenerateId;

import static edu.monash.fit2099.utils.CheckValid.*;

public class Bid {
    private String bidId;
    private Buyer buyer;
    private float bidPrice; //since assuming the unit of price is "Thousands"
    private String bidDate;



    public Bid(Buyer buyer, float bidPrice, String bidDate) throws BidException {
        if (setBidDate(bidDate) && setBidPrice(bidPrice)) {
            this.bidId = GenerateId.nextID();
            this.buyer = buyer;
        } else {
            throw new BidException("Incorrect bid date OR bid price");
        }



    }

    public void setBidId(String bidId) {
        this.bidId = bidId;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public boolean setBidPrice(float bidPrice) {
        boolean isValid=false;
        if (bidPrice>=0){
            isValid = true;
            this.bidPrice = bidPrice;
        }
        return isValid;
    }

    public boolean setBidDate(String bidDate) {
        boolean isValid = false;
        boolean isLegalDate = isLegalDate(bidDate.length(),bidDate,"yyyy-MM-dd");
        boolean rightYearRange = yearRange(bidDate);

        if (isLegalDate && rightYearRange){
            isValid = true;
            this.bidDate = bidDate;
        }
        return isValid;

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
