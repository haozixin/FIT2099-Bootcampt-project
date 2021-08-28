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
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Zixin
 * @version 5.0(week5-bootcamp-version)
 * @see "https://lms.monash.edu/mod/page/view.php?id=8894316"
 */
public class AutoShowroom {

    /**
     * ArrayList for vehicle to contain all vehicles created in the AutoShowroom
     */
    private ArrayList<Vehicle> vehicleArrayList;
    //task4(|||)
    /**
     * ArrayList for Buyer to contain all vehicles created in the AutoShowroom
     */
    private ArrayList<Buyer> buyerArrayList;

    public AutoShowroom() {
        vehicleArrayList = new ArrayList<>();
        buyerArrayList = new ArrayList<>();
    }

    public int getIntegerInput(String output, Scanner scanner){
        int number=0;
        do{
            System.out.print(output);
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
        } else{
            System.out.println("Something wrong with the buyer's values!!!");
        }

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
        System.out.print("Bid date(format:yyyy-MM-dd): ");
        String date = scanner.nextLine();



        for(Vehicle pointer:vehicleArrayList){
            if (vId.equals(pointer.getVId())){

                try {
                    pointer.getBidsManager().addBid(findBuyer(buyerId),price,date);
                    System.out.println("Have added/update this bid!");
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
    public ArrayList<Float> bidsPrice(String vehicleId){
        if (vehicleArrayList.isEmpty()){
            return null;
        }else{
            HashMap bidHashMap = new HashMap();
            for (Vehicle vehicle:vehicleArrayList){
                if (vehicle.getVId().equals(vehicleId)) {
                    bidHashMap = vehicle.getBidsManager().getBidHashMap();
                }
            }

            ArrayList<Float> price = new ArrayList<>();

            for (Object bids: bidHashMap.values()){
                Bid bid = (Bid)bids;
                price.add(bid.getBidPrice());
            }
            price.sort(Comparator.naturalOrder());
            return price;
        }

    }
    public void lowestPrice(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the vehicleID to get its lowest Price: ");
        String vehicleId = scanner.nextLine();
        System.out.println(bidsPrice(vehicleId).get(0));
    }
    public void highestPrice(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the vehicleID to get its highest Price: ");
        String vehicleId = scanner.nextLine();
        int index = (bidsPrice(vehicleId).size()-1);
        System.out.println(bidsPrice(vehicleId).get(index));
    }
    public void deleteBid(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the bid ID to delete it: ");
        String bidId = scanner.nextLine();

        boolean hasRemoved = false;
        for (Vehicle vehicle:vehicleArrayList){
            HashMap<String,Bid> bidHashMap = vehicle.getBidsManager().getBidHashMap();

            if (!hasRemoved){
                for(String key: bidHashMap.keySet()){
                    Boolean isEqual=bidHashMap.get(key).getBidId().equals(bidId);
                    if (isEqual) {
                        bidHashMap.remove(key);
                        System.out.println("you have delete this bid!");
                        hasRemoved=true;
                    }
                }
            }else{

            }

        }
        if (!hasRemoved){
            System.out.println("There is no bid with this ID!");
        }
    }


    public void printStatus() {

        System.out.println("Welcome to FIT2099 Showroom");
        System.out.println("Thank you for visiting FIT2099 Showroom");
        System.out.println("Thank you for visiting FIT2099 Showroom");

    }

    public Buyer findBuyer(String buyerId){
        for (Buyer buyer:buyerArrayList){
            if (buyer.getBuyerId().equals(buyerId)){
                return buyer;
            }
        }
        return null;
    }
}
