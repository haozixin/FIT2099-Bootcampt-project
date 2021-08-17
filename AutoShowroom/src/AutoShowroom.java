import edu.monash.fit2099.bids.Bid;
import edu.monash.fit2099.buyers.Buyer;
import edu.monash.fit2099.vehicles.Sedan;
import edu.monash.fit2099.vehicles.Truck;
import edu.monash.fit2099.vehicles.Vehicle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class AutoShowroom {

    private ArrayList<Vehicle> vehicleArrayList;
    //task4(|||)
    private ArrayList<Buyer> buyerArrayList;

    public AutoShowroom() {
        vehicleArrayList = new ArrayList<>();
        buyerArrayList = new ArrayList<>();
    }

    public void createSedan(){
        System.out.println("You are creating a Sedan, fill details please!");
        System.out.print("Sedan maker: ");
        Scanner scanner = new Scanner(System.in);
        String maker = scanner.nextLine();
        System.out.print("Sedan model: ");
        String model = scanner.nextLine();
        System.out.print("Sedan seats: ");
        int seats = Integer.parseInt(scanner.nextLine());
        Sedan sedan = new Sedan(maker,model,seats);
        vehicleArrayList.add(sedan);

        showVehicle(sedan);
    }

    public void createTruck(){
        System.out.println("You are creating a Truck, fill details please!");
        System.out.print("Truck maker: ");
        Scanner scanner = new Scanner(System.in);
        String maker = scanner.nextLine();
        System.out.print("Truck model: ");
        String model = scanner.nextLine();
        System.out.print("Truck wheels: ");
        int wheels = Integer.parseInt(scanner.nextLine());
        System.out.print("Truck capacity(integer/unit is tons): ");
        int capacity = Integer.parseInt(scanner.nextLine());
        Truck truck = new Truck(maker,model,capacity,wheels);
        vehicleArrayList.add(truck);

        showVehicle(truck);
    }

    public void createBuyer(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("You are creating a Buyer, fill details please!");
        System.out.print("Given name: ");
        String givenName = scanner.nextLine();
        System.out.print("Family Name: ");
        String familyName = scanner.nextLine();
        Buyer buyer = new Buyer(givenName,familyName);
        buyerArrayList.add(buyer);

        System.out.println(buyer.description());
    }

    public void createBid(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("You are creating a bid, fill details please!");
        System.out.print("Vehicle ID: ");
        int vId = Integer.parseInt(scanner.nextLine());
        System.out.print("Buyer ID: ");
        String buyerId = scanner.nextLine();
        System.out.print("Bid price(unit is thousands): ");
        float price = Float.parseFloat(scanner.nextLine());
        System.out.print("Bid date: ");
        String date = scanner.nextLine();

        for(Vehicle pointer:vehicleArrayList){
            if (vId == (pointer.getVId())){
                pointer.getBidsManager().addBid(buyerId,price,date);
                System.out.println("Have added this bid!");
            }else {
            }
        }


    }
    public void showVehicle(Vehicle vehicle){
        HashMap bidHashMap = vehicle.getBidsManager().getBidHashMap();
        String vId = "Vehicle ID: "+vehicle.getVId();
        String vMake = "Make: "+vehicle.getMake();
        String vModel = "Model: "+vehicle.getModel();
        if (bidHashMap.isEmpty()){
            System.out.println(("[ "+vehicle.description()+" ]: {no bid now} "));
        }
        else{
            System.out.println(("[ "+vehicle.description()+" ]: "));
            for (Object key:bidHashMap.keySet()) {
                String buyerId = (String) key;
                Bid bid = (Bid) bidHashMap.get(buyerId);
                String bidInf = "{BidID："+bid.getBidId()+" || BuyerID: "+buyerId+
                        " || BideDate: " +bid.getBidDate()+ " || BidPrice: "+bid.getBidPrice()+"}";
                System.out.println(bidInf);
            }

        }
    }

    public void displayFleet(){
        for(Vehicle pointer:vehicleArrayList){
            showVehicle(pointer);
        }
    }
    public void displayBuyers(){
        for(Buyer buyer:buyerArrayList){
            System.out.println(buyer.description());
        }

    }


    // previous work
 /*   public void createCars() {
        Vehicle vehicle1 = new Sedan("BMW", "X7", 5);
        Vehicle vehicle2 = new Sedan("Audi", "A8", 5);
        Vehicle vehicle3 = new Sedan("Mercedes", "GLS", 5);
        vehicleArrayList.add(vehicle1);
        vehicleArrayList.add(vehicle2);
        vehicleArrayList.add(vehicle3);


        consoleCreator(vehicle1);//create buyer and then create bid and add it to the car
        consoleCreator(vehicle1);


    }


    public Buyer consoleCreator(Vehicle vehicle) {

        System.out.print("You are creating a buyer, fill information please!");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please input the buyer's ID: ");
        String buyerId = scanner.nextLine();
        System.out.print("Please input the buyer's givenName: ");
        String buyerGName = scanner.nextLine();
        System.out.print("Please input the buyer's FamilyName: ");
        String buyerFName = scanner.nextLine();
        Buyer buyer = new Buyer(buyerId, buyerGName, buyerFName);
        System.out.print("Have created one buyer instance!");

        System.out.print("Do you want to create the buyer's bid and add it to one car? \n type 1 for yes, 0 for no: ");
        int selection = Integer.parseInt(scanner.nextLine());
        if (selection == 1) {

            System.out.print("Please input the date: ");
            String date = scanner.nextLine();

            System.out.print("Please input the price: ");
            Float price = Float.parseFloat(scanner.nextLine());

            vehicle.addBid(buyer, price, date);
            System.out.println("Have add bid to the car!");

        } else {
            return buyer;
        }
        return buyer;
    }

    public void displayCars() {
        for (int i = 0; i < vehicleArrayList.size(); i++) {
            Vehicle vehicle = vehicleArrayList.get(i);
            ArrayList<String> aL = new ArrayList<>();

            for (Bid bidPointer : vehicle.getBidsManager().getBidHashMap().values()) {
                String bidInformation =
                        "BidID: " + bidPointer.getBidId() +
                                "; BidPrice: " + bidPointer.getBidPrice() +
                                "; BidDate: " + bidPointer.getBidDate();
                String buyerInformation = ";   Buyer: " + bidPointer.getBuyer().getBuyerId();
                aL.add(bidInformation + buyerInformation);
            }
            if (aL.isEmpty()) {
                System.out.println("Car (" + (i + 1) + ") " + vehicle.description() + "------- No bids and buyers now");
            } else {
                System.out.println("Car (" + (i + 1) + ") " + vehicle.description() + " ------- " + aL);
            }


        }
    }
*/
    public void printStatus() {

        System.out.println("Welcome to FIT2099 Showroom");
        System.out.println("Thank you for visiting FIT2099 Showroom");
        //createCars();
        //displayCars();
        System.out.println("Thank you for visiting FIT2099 Showroom");

    }
}
