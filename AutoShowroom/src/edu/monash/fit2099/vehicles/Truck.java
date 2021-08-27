package edu.monash.fit2099.vehicles;

public class Truck extends Vehicle {
    private int capacity;
    private int wheels;
    private static final int WHEEL_UNDER_BOUNDARY = 4;
    private static final int WHEEL_UP_BOUNDARY = 16;
    private static final int CAPACITY_UNDER_BOUNDARY = 1;
    private static final int CAPACITY_UP_BOUNDARY = 15;

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

    public boolean setCapacity(int capacity) {
        boolean isValid=false;
        if(capacity>=CAPACITY_UNDER_BOUNDARY && capacity<=CAPACITY_UP_BOUNDARY){
            this.capacity = capacity;
            isValid=true;
        }
        return isValid;

    }

    public boolean setWheels(int wheels) {
        boolean isValid=false;
        if(wheels>=WHEEL_UNDER_BOUNDARY && wheels<=WHEEL_UP_BOUNDARY){
            this.wheels = wheels;
            isValid=true;
        }
        return isValid;

    }
}
