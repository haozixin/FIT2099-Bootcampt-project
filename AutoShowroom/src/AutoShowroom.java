public class AutoShowroom {
    //Task 3
    //private Car car;
    private Car[] carAr;

    public void createCars(){
        Car car1 = new Car("BMW","X7");
        Car car2 = new Car("Audi","A8");
        Car car3 = new Car("Mercedes","GLS");
        carAr = new Car[] {car1,car2,car3};

    }

    public void displayCars(){
        for(int i = 0; i< carAr.length; i++){
            System.out.println("Car ("+(i+1)+") "+carAr[i].getCarDescription());
        }
    }

    public void printStatus(){
        //Task 3
//        car = new Car("BMW","X7");


        System.out.println("Welcome to FIT2099 Showroom");
        System.out.println("Thank you for visiting FIT2099 Showroom");
        createCars();
        displayCars();
        System.out.println("Thank you for visiting FIT2099 Showroom");

        //Task 3
//        System.out.println(car.getCarDescription());
    }
}
