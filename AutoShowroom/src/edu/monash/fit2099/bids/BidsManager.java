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

    /**
     * Constructor to initialize bid HashMap
     */
    public BidsManager() {
        bidHashMap = new HashMap<>();
    }

    /**
     * @param buyer Buyer instance - who gives the bid
     * @param bidPrice Bid price - float type
     * @param bidDate The date of adding to a car
     * @throws BidException When bid date( yyyy{1930-2021}; MM{1-12}; dd{legal for each month}) or bid price(less than 0) is invalid, throw an exception message
     * @exception BidException Bid exception (when it has invalid attributes)
     */
    //accepting the three parameter is requirement
    public void addBid (Buyer buyer, float bidPrice, String bidDate) throws BidException{
        try {
            Bid bid = new Bid(buyer, bidPrice, bidDate);
            bidHashMap.put(buyer.getBuyerId(),bid);
        } catch (BidException e) {
            System.out.println(e.getMessage());
        }
    }


    /**
     * @return Bid's hashmap containing (String buyerID,Bid bid) pairs
     */
    public HashMap<String, Bid> getBidHashMap() {
        return bidHashMap;
    }
}
