import edu.monash.fit2099.bids.Bid;
import edu.monash.fit2099.buyers.Buyer;
import edu.monash.fit2099.exceptions.BidException;
import edu.monash.fit2099.exceptions.SedanException;
import edu.monash.fit2099.exceptions.TruckException;
import edu.monash.fit2099.exceptions.VehicleException;
import edu.monash.fit2099.vehicles.Sedan;
import edu.monash.fit2099.vehicles.Truck;
import edu.monash.fit2099.vehicles.Vehicle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class AutoShowroom {

    private ArrayList<Vehicle> vehicleArrayList;
    //task4(|||)
    private ArrayList<Buyer> buyerArrayList;

    public AutoShowroom() {
        vehicleArrayList = new ArrayList<>();
        buyerArrayList = new ArrayList<>();
    }

    public int getIntegerInput(String output, Scanner scanner){
        int number=0;
        do{
            System.out.println(output);
            try{
                number = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.print("This fields should be an integer");
            }
        }while(number==0);
        return number;
    }

    public void createSedan(){
        System.out.println("You are creating a Sedan, fill details please!");
        System.out.print("Sedan maker: ");
        Scanner scanner = new Scanner(System.in);
        String maker = scanner.nextLine();
        System.out.print("Sedan model: ");
        String model = scanner.nextLine();


        int seats = getIntegerInput("Sedan seats: ",scanner);



        Sedan sedan = null;
        try {
            sedan = new Sedan(maker,model,seats);
            vehicleArrayList.add(sedan);
        } catch (SedanException e){
            System.out.println(e.getMessage());
        }
        catch (VehicleException e) {
            System.out.println(e.getMessage());
        }

        showVehicle(sedan);
    }

    public void createTruck() {
        System.out.println("You are creating a Truck, fill details please!");
        System.out.print("Truck maker: ");
        Scanner scanner = new Scanner(System.in);
        String maker = scanner.nextLine();
        System.out.print("Truck model: ");
        String model = scanner.nextLine();


        int wheels = getIntegerInput("Truck wheels: ",scanner);

        int capacity = getIntegerInput("Truck capacity(integer/unit is tons): ",scanner);


        Truck truck = null;
        try {
            truck = new Truck(maker,model,capacity,wheels);
            vehicleArrayList.add(truck);
        } // small scope first
        catch (TruckException e){
            System.out.println(e.getMessage());
        } catch (VehicleException e) {
            System.out.println(e.getMessage());
        }

        showVehicle(truck);
    }

    public void createBuyer(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("You are creating a Buyer, fill details please!");
        System.out.print("Given name: ");
        String givenName = scanner.nextLine();
        System.out.print("Family Name: ");
        String familyName = scanner.nextLine();

        Buyer buyer = Buyer.getInstance(givenName, familyName);
        if (buyer != null) {
            buyerArrayList.add(buyer);
            System.out.println(buyer);
        } else
            System.out.println("Something wrong with the buyer's values!!!");

        buyerArrayList.add(buyer);

        System.out.println(buyer);
    }

    public void createBid() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("You are creating a bid, fill details please!");
        System.out.print("Vehicle ID: ");
        String vId = scanner.nextLine();
        System.out.print("Buyer ID: ");
        String buyerId = scanner.nextLine();
        System.out.print("Bid price(unit is thousands): ");
        float price = Float.parseFloat(scanner.nextLine());
        System.out.print("Bid date: ");
        String date = scanner.nextLine();



        for(Vehicle pointer:vehicleArrayList){
            if (vId.equals (pointer.getVId())){

                try {
                    pointer.getBidsManager().addBid(findBuyer(buyerId),price,date);
                    System.out.println("Have added this bid!");
                }catch (BidException e){
                    System.out.println(e.getMessage());
                }

                catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            }else {
            }
        }


    }
    public void showVehicle(Vehicle vehicle){
        HashMap bidHashMap = vehicle.getBidsManager().getBidHashMap();


        if (bidHashMap.isEmpty()){
            System.out.println(vehicle+" : {no bid now} ");
        }
        else{
            System.out.println(vehicle+" :");
            for (Object key:bidHashMap.keySet()) {
                String buyerId = (String) key;
                Bid bid = (Bid) bidHashMap.get(buyerId);
                System.out.println(bid);
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
            System.out.println(buyer);
        }

    }


    public void printStatus() {

        System.out.println("Welcome to FIT2099 Showroom");
        System.out.println("Thank you for visiting FIT2099 Showroom");
        System.out.println("Thank you for visiting FIT2099 Showroom");

    }

    public Buyer findBuyer(String buyerId){
        for (Buyer buyer:buyerArrayList){
            if (buyer.getBuyerId()==buyerId){
                return buyer;
            }
        }
        return null;
    }
}
