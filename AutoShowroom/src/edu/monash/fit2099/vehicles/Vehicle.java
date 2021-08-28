package edu.monash.fit2099.vehicles;

import edu.monash.fit2099.bids.BidsManager;
import edu.monash.fit2099.exceptions.VehicleException;
import edu.monash.fit2099.utils.GenerateId;

import static edu.monash.fit2099.utils.CheckValid.vehicleValidLength;

/**
 * @author Zixin
 * @version 5.0(week5-bootcamp-version)
 * @see "https://lms.monash.edu/mod/page/view.php?id=8894316"
 */
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

    /**
     * A Constructor to initialize the vehicle's maker and model
     * @param make vehicle's maker
     * @param model vehicle's model
     * @throws VehicleException when the maker or model are not valid, it will return the exception message
     */
    public Vehicle(String make, String model) throws VehicleException {
        if (setMake(make) && setModel(model)) {
            bidsManager = new BidsManager();
            vId = GenerateId.nextID();
        } else {
            throw new VehicleException("Incorrect Maker OR Model");
        }

    }

    /**
     * Vehicle constructor to initialize  its id, maker, and model
     * @param vId vehicle id
     * @param make vehicle's maker
     * @param model vehicle's model
     * @throws VehicleException when the maker or model are not valid, it will return the exception message
     */
    public Vehicle(String vId, String make, String model) throws VehicleException{
        if (setMake(make) && setModel(model)) {
            bidsManager = new BidsManager();
            this.vId = vId;
        } else {
            throw new VehicleException("Incorrect Maker OR Model");
        }

    }

    /**
     * Setter to set maker (attribute value)
     * @param make Truck's capacity
     * @return boolean value -- to judge if the input parameter(it's maker) is valid
     */
    public boolean setMake(String make) {
        boolean isValid =  vehicleValidLength(make);
        if (isValid){
            this.make = make;
        }
        return isValid;
    }

    /**
     * Setter to set maker (attribute value)
     * @param model Truck's capacity
     * @return Boolean value -- to judge if the input parameter(it's model) is valid
     */
    public boolean setModel(String model) {
        boolean isValid =  vehicleValidLength(model);
        if (isValid){
            this.model = model;
        }
        return isValid;
    }


    /**
     * Getter method
     * @return Vehicle id
     */
    public String getVId() {
        return vId;
    }

    /**
     * Override toString() to show objects information
     * @return all information about a vehicle
     */
    @Override
    public String toString() {
        return "Vehicle[" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", vId='" + vId + '\'' +
                ']';
    }

    /**
     * Getter method to get the vehicle's bids manager
     * @return bidsManager
     */
    public BidsManager getBidsManager() {
        return bidsManager;
    }
}
