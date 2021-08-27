package edu.monash.fit2099.vehicles;

import edu.monash.fit2099.bids.BidsManager;
import edu.monash.fit2099.exceptions.VehicleException;
import edu.monash.fit2099.utils.GenerateId;

import static edu.monash.fit2099.utils.CheckValid.vehicleValidLength;

abstract public class Vehicle {
    /**
     * Vehicle's maker
     */
    private String make;
    /**
     * Vehicle's model
     */
    private String model;
    /**
     * Vehicle's ID
     */
    private String vId;
    /**
     * bids' manager; BidsManager type (reference datatype)
     */
    private BidsManager bidsManager;
    
    public Vehicle(String make, String model) throws VehicleException {
        if (setMake(make) && setModel(model)) {
            bidsManager = new BidsManager();
            vId = GenerateId.nextID();
        } else {
            throw new VehicleException("Incorrect Maker OR Model");
        }

    }
    public Vehicle(String vId, String make, String model) throws VehicleException{
        if (setMake(make) && setModel(model)) {
            bidsManager = new BidsManager();
            vId = GenerateId.nextID();
        } else {
            throw new VehicleException("Incorrect Maker OR Model");
        }
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


    public BidsManager getBidsManager() {
        return bidsManager;
    }
}
