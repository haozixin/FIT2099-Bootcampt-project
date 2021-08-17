package edu.monash.fit2099.bids;

import edu.monash.fit2099.bids.Bid;
import edu.monash.fit2099.buyers.Buyer;

import java.util.ArrayList;
import java.util.HashMap;

public class BidsManager {

    HashMap<String,Bid> bidHashMap;

    public BidsManager() {
        bidHashMap = new HashMap<>();
    }

    //accepting the three parameter is requirement
    public void addBid (String buyerId, float bidPrice, String bidDate){
        Buyer buyer = new Buyer(buyerId);
        Bid bid = new Bid(buyer, bidPrice, bidDate);
        bidHashMap.put(buyerId,bid);
    }

    public HashMap<String, Bid> getBidHashMap() {
        return bidHashMap;
    }
}
