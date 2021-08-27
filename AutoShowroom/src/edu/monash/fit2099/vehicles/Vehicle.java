package edu.monash.fit2099.vehicles;

import edu.monash.fit2099.bids.BidsManager;
import edu.monash.fit2099.buyers.Buyer;
import edu.monash.fit2099.utility.GenerateId;

import static edu.monash.fit2099.utility.CheckValid.vehicleValidLength;

abstract public class Vehicle {
    private String make;
    private String model;
    private String vId;
    private BidsManager bidsManager;
    
    public Vehicle(String make, String model) {
        vId = GenerateId.nextID();
        bidsManager = new BidsManager();
        this.make = make;
        this.model = model;

    }
    public Vehicle(String vId, String make, String model){
        this.make = make;
        this.model = model;
        this.vId = vId;
        bidsManager = new BidsManager();
    }

    public boolean setMake(String make) {
        boolean isValid =  vehicleValidLength(make);
        if (isValid){
            this.make = make;
        }
        return isValid;
    }

    public boolean setModel(String model) {
        boolean isValid =  vehicleValidLength(model);
        if (isValid){
            this.model = model;
        }
        return isValid;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getVId() {
        return vId;
    }

    @Override
    public String toString() {
        return "Vehicle[" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", vId='" + vId + '\'' +
                ']';
    }

    //accepting the three parameter is requirement
    public void addBid(Buyer newBuyer, Float price, String date){
        bidsManager.addBid(newBuyer.getBuyerId(),price,date);
    }


    public BidsManager getBidsManager() {
        return bidsManager;
    }
}
