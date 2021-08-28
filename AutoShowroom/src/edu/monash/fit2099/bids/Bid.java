package edu.monash.fit2099.bids;

import edu.monash.fit2099.buyers.Buyer;
import edu.monash.fit2099.exceptions.BidException;
import edu.monash.fit2099.utils.GenerateId;

import static edu.monash.fit2099.utils.CheckValid.*;

/**
 * @author Zixin Hao
 * @version 5.0 (week5-bootcamp-version)
 * @see "https://lms.monash.edu/mod/page/view.php?id=8894316"
 */
public class Bid {

    /**
     * Unique Bid ID
     */
    private String bidId;
    /**
     * Buyer type(reference dataType)  as a Bid class attribute
     */
    private Buyer buyer;
    /**
     * The price of the bid
     */
    private float bidPrice; //since assuming the unit of price is "Thousands"
    /**
     * The date when the bid is biding(created)
     */
    private String bidDate;


    /**
     * @param buyer    Buyer type parameter
     * @param bidPrice float type - Bid price - unit is thousand
     * @param bidDate  String type - date of creating bid
     * @throws BidException When bid date yyyy--[1930-2021]; MM--[1-12]; dd--[legal for each month] or bid price(less than 0) is invalid, throw an exception message
     */
    public Bid(Buyer buyer, float bidPrice, String bidDate) throws BidException {
        if (setBidDate(bidDate) && setBidPrice(bidPrice)) {
            this.bidId = GenerateId.nextID();
            this.buyer = buyer;
        } else {
            throw new BidException("Incorrect bid date OR bid price");
        }


    }

    /**
     *
     * @param bidPrice float number - price of the bid
     * @return Boolean value -- to judge if the input parameter is valid
     */
    public boolean setBidPrice(float bidPrice) {
        boolean isValid = false;
        if (bidPrice >= 0) {
            isValid = true;
            this.bidPrice = bidPrice;
        }
        return isValid;
    }

    /**
     * @param bidDate The date of the bid created
     * @return Boolean value -- to judge if the input parameter(the date) is valid
     */
    public boolean setBidDate(String bidDate) {
        boolean isValid = false;
        boolean isLegalDate = isLegalDate(bidDate.length(), bidDate, "yyyy-MM-dd");
        boolean rightYearRange = yearRange(bidDate);

        if (isLegalDate && rightYearRange) {
            isValid = true;
            this.bidDate = bidDate;
        }
        return isValid;

    }

    /**
     * Getter methods
     * @return bid's ID
     */
    public String getBidId() {
        return bidId;
    }

    /**
     * Getter methods
     * @return bid's price
     */
    public float getBidPrice() {
        return bidPrice;
    }


    /**
     * Override toString() to show objects information
     * @return All information about a bid
     */
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
