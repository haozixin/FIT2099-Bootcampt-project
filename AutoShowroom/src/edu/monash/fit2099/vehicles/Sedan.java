package edu.monash.fit2099.vehicles;

public class Sedan extends Vehicle {
    private int seats;

    public Sedan(String make, String model, int seats) {
        super(make, model);
        this.seats = seats;
    }

    public Sedan(int vId, String make, String model, int seats) {
        super(vId, make, model);
        this.seats = seats;
    }
}
