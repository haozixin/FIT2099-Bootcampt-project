package edu.monash.fit2099.bids;

import edu.monash.fit2099.buyers.Buyer;
import edu.monash.fit2099.exceptions.BidException;

import java.util.HashMap;

/**
 * @author Zixin
 * @version 5.0(week5-bootcamp-version)
 * @see "https://lms.monash.edu/mod/page/view.php?id=8894316"
 */
public class BidsManager {

    /**
     * HashMap contains Bid as value, Buyer's ID(String) as key
     */
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
