
package edu.monash.fit2099.buyers;
import edu.monash.fit2099.utils.GenerateId;

import static edu.monash.fit2099.utils.CheckValid.buyerValidLength;

/**
 * @author Zixin
 * @version 5.0(week5-bootcamp-version)
 * @see "https://lms.monash.edu/mod/page/view.php?id=8894316"
 */
public class Buyer {
    /**
     * Unique buyerID
     */
    private String buyerId;
    // Because some people have middle name, so, using "givenName" and "familyName" is exact.
    // And for different culture/country, people are confused about which name should be considered "first",so, it will create ambiguity.
    // Variable name of "firstName/lastName" is not meaningful enough.
    /**
     * Buyer's givenName
     */
    private String givenName;
    /**
     * Buyer's familyName
     */
    private String familyName;

    /**
     * Empty constructor
     */
    private Buyer(){}


/*    private Buyer(String newBuyerId) {
        this.buyerId = newBuyerId;
    }

    private Buyer(String newBuyerId, String newGivenName, String newFamilyName) {
        this.buyerId = newBuyerId;
        this.givenName = newGivenName;
        this.familyName = newFamilyName;
    }

    private Buyer(String newGivenName, String newFamilyName){
        this.buyerId = GenerateId.nextID();
        this.givenName = newGivenName;
        this.familyName = newFamilyName;
    }*/

    /**
     * Setter method - set buyer's given name
     * @param givenName Buyer's given name
     * @return Boolean value -- to judge if the input parameter is valid
     */
    public boolean setGivenName(String givenName) {
        boolean isValid =  buyerValidLength(givenName);
        if (isValid){
            this.givenName = givenName;
        }
        return isValid;

    }

    /**
     * Setter method - set buyer's family name
     * @param familyName Buyer's family name
     * @return Boolean value -- to judge if the input parameter is valid
     */
    public boolean setFamilyName(String familyName) {
        boolean isValid =  buyerValidLength(familyName);
        if (isValid){
            this.familyName = familyName;
        }
        return isValid;
    }

    /**
     * Static Factory Method
     * @param givenName Buyer's given name
     * @param familyName Buyer's family name
     * @return Buyer type instance with initialed attributes
     */
    public static Buyer getInstance(String givenName, String familyName){
        Buyer buyer = new Buyer();
        if (buyer.setGivenName(givenName) && buyer.setFamilyName(familyName) ){
            buyer.setBuyerId();
            return buyer;
        }
        return null;
    }

    /**
     * Setter method - set buyer's id
     */
    public void setBuyerId() {
        buyerId = GenerateId.nextID();
    }

    /**
     * Getter method - get buyer's id
     * @return String data - buyer's id
     */
    public String getBuyerId() {
        return buyerId;
    }

    /**
     * Override toString() to show objects information
     * @return all information about a buyer
     */
    @Override
    public String toString() {
        return "Buyer{" +
                "buyerId='" + buyerId + '\'' +
                ", givenName='" + givenName + '\'' +
                ", familyName='" + familyName + '\'' +
                '}';
    }
}
