package edu.monash.fit2099.vehicles;

import edu.monash.fit2099.exceptions.VehicleException;

public class Sedan extends Vehicle {
    private static final int SEAT_UNDER_BOUNDARY = 4;
    private static final int SEAT_UP_BOUNDARY = 5;
    private int seats;

    public Sedan(String make, String model, int seats) throws VehicleException {
        super(make, model);
        if (setSeats(seats)) {
        } else {
            throw new VehicleException("Incorrect Seat number");
        }
    }

    public Sedan(String vId, String make, String model, int seats) throws VehicleException {
        super(vId, make, model);
        if (setSeats(seats)) {
        } else {
            throw new VehicleException("Incorrect Seat number");
        }
    }

    public boolean setSeats(int seats) {
        boolean isValid=false;
        if(seats>=SEAT_UNDER_BOUNDARY && seats<=SEAT_UP_BOUNDARY){
            isValid=true;
            this.seats = seats;
        }
        return isValid;
    }
}
