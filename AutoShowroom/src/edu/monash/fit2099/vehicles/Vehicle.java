package edu.monash.fit2099.vehicles;

import edu.monash.fit2099.bids.BidsManager;
import edu.monash.fit2099.buyers.Buyer;

import java.util.ArrayList;
import java.util.Random;

abstract public class Vehicle {
    private String make;
    private String model;
    private int vId;
    private BidsManager bidsManager;
    
    public Vehicle(String make, String model) {
        vId = this.nextID();
        bidsManager = new BidsManager();
        this.make = make;
        this.model = model;

    }
    public Vehicle(int vId, String make, String model){
        this.make = make;
        this.model = model;
        this.vId = vId;
        bidsManager = new BidsManager();
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getVId() {
        return vId;
    }

    /*public String description(){
        return  String.format("Vehicle ID:%s || Maker:%s || Model:%s",getVId(), getMake(),getModel());
    }

    //accepting the three parameter is requirement
    public void addBid(Buyer newBuyer, Float price, String date){
        bidsManager.addBid(newBuyer.getBuyerId(),price,date);
    }*/

    public int nextID(){
        Random r = new Random();
        int low = 100000;//using literal values is not a good idea, replace them with input parameters
        int high = 999999;
        return (r.nextInt(high - low) + low);
    }

    public BidsManager getBidsManager() {
        return bidsManager;
    }
}
