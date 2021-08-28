package edu.monash.fit2099.vehicles;

import edu.monash.fit2099.exceptions.SedanException;
import edu.monash.fit2099.exceptions.VehicleException;

/**
 * @author Zixin
 * @version 5.0(week5-bootcamp-version)
 * @see "https://lms.monash.edu/mod/page/view.php?id=8894316"
 */
public class Sedan extends Vehicle {
    /**
     * Minimum seat number for a Sedan
     */
    private static final int SEAT_UNDER_BOUNDARY = 4;
    /**
     * Maximum seat number for a Sedan
     */
    private static final int SEAT_UP_BOUNDARY = 5;
    /**
     * Seat number for a Sedan
     */
    private int seats;

    /**
     * Constructor
     * @param make Sedan's maker
     * @param model Sedan's model
     * @param seats Sedan's seats number
     * @throws SedanException When seat number are invalid, it will throw the exception message
     */
    public Sedan(String make, String model, int seats) throws VehicleException {
        super(make, model);
        if (setSeats(seats)) {
        } else {
            throw new SedanException("Incorrect Seat number");
        }
    }

    /**
     * Constructor
     * @param vId vehicle ID
     * @param make Sedan's maker
     * @param model Sedan's model
     * @param seats Sedan's seats number
     * @throws SedanException When seat number are invalid, it will throw the exception message
     */
    public Sedan(String vId, String make, String model, int seats) throws VehicleException {
        super(vId, make, model);
        if (setSeats(seats)) {
        } else {
            throw new SedanException("Incorrect Seat number");
        }
    }

    /**
     * Setter methods
     * @param seats Seat number
     * @return Boolean value -- to judge if the input parameter(seats) is valid
     */
    public boolean setSeats(int seats) {
        boolean isValid=false;
        if(seats>=SEAT_UNDER_BOUNDARY && seats<=SEAT_UP_BOUNDARY){
            isValid=true;
            this.seats = seats;
        }
        return isValid;
    }
}
