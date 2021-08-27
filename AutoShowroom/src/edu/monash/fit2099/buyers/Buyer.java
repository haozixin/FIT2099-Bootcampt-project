
package edu.monash.fit2099.buyers;
import edu.monash.fit2099.utility.GenerateId;

import static edu.monash.fit2099.utility.CheckValid.buyerValidLength;


public class Buyer {
    private String buyerId;
    // Because some people have middle name, so, using "givenName" and "familyName" is exact.
    // And for different culture/country, people are confused about which name should be considered "first",so, it will create ambiguity.
    // Variable name of "firstName/lastName" is not meaningful enough.
    private String givenName;
    private String familyName;


    public Buyer(String newBuyerId) {
        this.buyerId = newBuyerId;
    }

    public Buyer(String newBuyerId, String newGivenName, String newFamilyName) {
        this.buyerId = newBuyerId;
        this.givenName = newGivenName;
        this.familyName = newFamilyName;
    }

    public Buyer(String newGivenName, String newFamilyName){
        this.buyerId = GenerateId.nextID();
        this.givenName = newGivenName;
        this.familyName = newFamilyName;
    }

    public boolean setGivenName(String givenName) {
        boolean isValid =  buyerValidLength(givenName);
        if (isValid){
            this.givenName = givenName;
        }
        return isValid;

    }

    public boolean setFamilyName(String familyName) {
        boolean isValid =  buyerValidLength(familyName);
        if (isValid){
            this.familyName = familyName;
        }
        return isValid;
    }




    public String getBuyerId() {
        return buyerId;
    }

    @Override
    public String toString() {
        return "Buyer{" +
                "buyerId='" + buyerId + '\'' +
                ", givenName='" + givenName + '\'' +
                ", familyName='" + familyName + '\'' +
                '}';
    }
}
