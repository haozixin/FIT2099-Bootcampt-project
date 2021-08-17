package edu.monash.fit2099.buyers;

import java.util.Random;

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
        this.buyerId = nextID();
        this.givenName = newGivenName;
        this.familyName = newFamilyName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String description(){
        return buyerId+" | "+givenName+" | "+familyName;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public String nextID(){
        Random r = new Random();
        int low = 100000;//using literal values is not a good idea, replace them with input parameters
        int high = 999999;
        return String.valueOf(r.nextInt(high - low) + low);
    }
}
