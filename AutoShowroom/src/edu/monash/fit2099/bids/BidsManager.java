package edu.monash.fit2099.bids;

import edu.monash.fit2099.buyers.Buyer;
import edu.monash.fit2099.exceptions.BidException;

import java.util.HashMap;

public class BidsManager {

    HashMap<String,Bid> bidHashMap;

    public BidsManager() {
        bidHashMap = new HashMap<>();
    }

    //accepting the three parameter is requirement
    public void addBid (Buyer buyer, float bidPrice, String bidDate) throws BidException {
        Bid bid = new Bid(buyer, bidPrice, bidDate);
        bidHashMap.put(buyer.getBuyerId(),bid);
    }

    public HashMap<String, Bid> getBidHashMap() {
        return bidHashMap;
    }
}
