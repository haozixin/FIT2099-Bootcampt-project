import java.util.ArrayList;
import java.util.Scanner;

public class AutoShowroom {

    private ArrayList<Vehicle> vehicleArrayList;

    public AutoShowroom() {
        vehicleArrayList = new ArrayList<>();
    }

    public void createCars(){
        Vehicle vehicle1 = new Sedan("BMW","X7",5);
        Vehicle vehicle2 = new Sedan("Audi","A8",5);
        Vehicle vehicle3 = new Sedan("Mercedes","GLS",5);
        vehicleArrayList.add(vehicle1);
        vehicleArrayList.add(vehicle2);
        vehicleArrayList.add(vehicle3);


        consoleCreator(vehicle1);//create buyer and then create bid and add it to the car
        consoleCreator(vehicle1);


    }



    public Buyer consoleCreator(Vehicle vehicle){

        System.out.print("You are creating a buyer, fill information please!");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please input the buyer's ID: ");
        String buyerId = scanner.nextLine();
        System.out.print("Please input the buyer's givenName: ");
        String buyerGName = scanner.nextLine();
        System.out.print("Please input the buyer's FamilyName: ");
        String buyerFName = scanner.nextLine();
        Buyer buyer = new Buyer(buyerId,buyerGName,buyerFName);
        System.out.print("Have created one buyer instance!");

        System.out.print("Do you want to create the buyer's bid and add it to one car? \n type 1 for yes, 0 for no: ");
        int selection = Integer.parseInt(scanner.nextLine());
        if (selection ==1){

            System.out.print("Please input the date: ");
            String date = scanner.nextLine();

            System.out.print("Please input the price: ");
            Float price = Float.parseFloat(scanner.nextLine());

            vehicle.addBid(buyer,price,date);
            System.out.println("Have add bid to the car!");

        }else{
            return buyer;
        }
        return buyer;
    }

    public void displayCars(){
        for(int i = 0; i< vehicleArrayList.size(); i++){
            Vehicle vehicle = vehicleArrayList.get(i);
            ArrayList<String> aL=new ArrayList<>();

            for (Bid bidPointer: vehicle.getBids()){
                String bidInformation ="BidID: "+bidPointer.getBidId()+"; BidPrice: "+bidPointer.getBidPrice()
                        +"; BidDate: "+bidPointer.getBidDate();
                String buyerInformation = "; Buyer: "+bidPointer.getBuyer().description();
                aL.add(bidInformation+buyerInformation);
            }
            if (aL.isEmpty()){
                System.out.println("Car ("+(i+1)+") "+ vehicle.description()+"------- No bids and buyers now");
            }else{
                System.out.println("Car ("+(i+1)+") "+ vehicle.description()+" ------- "+ aL);
            }


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
