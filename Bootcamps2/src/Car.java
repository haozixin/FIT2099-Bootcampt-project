public class Car {
    private String make;
    private String model;

    public Car(String make, String model) {
        this.make = make;
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getCarDescription(){

        return  String.format("Maker:%s and Model:%s",getMake(),getModel());
    }

}
