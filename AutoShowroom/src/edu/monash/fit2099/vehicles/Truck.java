package edu.monash.fit2099.vehicles;

public class Truck extends Vehicle {
    private int capacity;
    private int wheels;

    public Truck(String make, String model, int capacity, int wheels) {
        super(make, model);
        this.capacity = capacity;
        this.wheels = wheels;
    }

    public Truck(String vId, String make, String model, int capacity, int wheels) {
        super(vId, make, model);
        this.capacity = capacity;
        this.wheels = wheels;
    }
}
