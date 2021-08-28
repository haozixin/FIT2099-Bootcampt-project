package edu.monash.fit2099.vehicles;

import edu.monash.fit2099.exceptions.TruckException;
import edu.monash.fit2099.exceptions.VehicleException;


/**
 * @author Zixin
 * @version 5.0(week5-bootcamp-version)
 * @see "https://lms.monash.edu/mod/page/view.php?id=8894316"
 */
public class Truck extends Vehicle {
    /**
     * Truck's capacity; Unit is tons
     */
    private int capacity;
    /**
     * Truck's wheels number
     */
    private int wheels;
    /**
     * Minimum wheel number
     */
    private static final int WHEEL_UNDER_BOUNDARY = 4;
    /**
     * Maximum wheel number
     */
    private static final int WHEEL_UP_BOUNDARY = 16;
    /**
     * Maximum capacity for a truck
     */
    private static final int CAPACITY_UNDER_BOUNDARY = 1;
    /**
     * Maximum capacity for a truck
     */
    private static final int CAPACITY_UP_BOUNDARY = 15;

    /**
     * Constructor to initialize maker, model, capacity, wheels' number
     * @param capacity Truck ID
     * @param make Truck's maker
     * @param model Truck's model
     * @param wheels Truck's wheels
     * @throws VehicleException when the capacity or wheels are not valid, it will return the exception message
     */
    public Truck(String make, String model, int capacity, int wheels) throws VehicleException {
        super(make, model);
        if (setCapacity(capacity) && setWheels(wheels)) {
        } else {
            throw new TruckException("Incorrect capacity OR wheels");
        }
    }


/*
    public Truck(String vId, String make, String model, int capacity, int wheels) throws VehicleException {
        super(vId, make, model);
        if (setCapacity(capacity) && setWheels(wheels)) {
        } else {
            throw new TruckException("Incorrect capacity OR wheels");
        }
    }
*/

    /**
     * Setter to set capacity (attribute value)
     * @param capacity Truck's capacity
     * @return boolean value -- to judge if the input parameter(it's capacity) is valid
     */
    public boolean setCapacity(int capacity) {
        boolean isValid=false;
        if(capacity>=CAPACITY_UNDER_BOUNDARY && capacity<=CAPACITY_UP_BOUNDARY){
            this.capacity = capacity;
            isValid=true;
        }
        return isValid;

    }

    /**
     * Setter to set wheels (attribute value)
     * @param wheels Truck's wheels number
     * @return boolean value -- to judge if the input parameter(it's capacity) is valid
     */
    public boolean setWheels(int wheels) {
        boolean isValid=false;
        if(wheels>=WHEEL_UNDER_BOUNDARY && wheels<=WHEEL_UP_BOUNDARY){
            this.wheels = wheels;
            isValid=true;
        }
        return isValid;
    }
}
