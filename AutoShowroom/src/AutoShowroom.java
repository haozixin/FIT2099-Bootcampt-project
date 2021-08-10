import java.util.ArrayList;

public class AutoShowroom {

    ArrayList<Car> carArrayList;

    public AutoShowroom() {
        carArrayList = new ArrayList<Car>();
    }

    public void createCars(){
        Car car1 = new Car("BMW","X7");
        Car car2 = new Car("Audi","A8");
        Car car3 = new Car("Mercedes","GLS");
        carArrayList.add(car1);
        carArrayList.add(car2);
        carArrayList.add(car3);

        Buyer buyer = new Buyer();

    }

    public void displayCars(){
        for(int i = 0; i< carArrayList.size(); i++){
            System.out.println("Car ("+(i+1)+") "+ carArrayList.get(i).description());
        }
    }

    public void printStatus(){

        System.out.println("Welcome to FIT2099 Showroom");
        System.out.println("Thank you for visiting FIT2099 Showroom");
        createCars();
        displayCars();
        System.out.println("Thank you for visiting FIT2099 Showroom");

    }
}
