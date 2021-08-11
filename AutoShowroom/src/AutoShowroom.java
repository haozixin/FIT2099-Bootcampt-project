import java.util.ArrayList;
import java.util.Scanner;

public class AutoShowroom {

    ArrayList<Car> carArrayList;

    public AutoShowroom() {
        carArrayList = new ArrayList<>();
    }

    public void createCars(){
        Car car1 = new Car("BMW","X7");
        Car car2 = new Car("Audi","A8");
        Car car3 = new Car("Mercedes","GLS");
        carArrayList.add(car1);
        carArrayList.add(car2);
        carArrayList.add(car3);


        Buyer buyer1 = consoleCreator(car1);
        Buyer buyer2 = consoleCreator(car1);


    }



    public Buyer consoleCreator(Car car){

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
        int selection = scanner.nextInt();
        if (selection ==1){

            System.out.print("Please input the date: ");
            String date = scanner.nextLine();

            System.out.print("Please input the price: ");
            Float price = scanner.nextFloat();

            car.addBid(buyer,price,date);

        }else{
            return buyer;
        }
        return buyer;
    }

    public void displayCars(){
        for(int i = 0; i< carArrayList.size(); i++){
            Car car = carArrayList.get(i);
            ArrayList<String> aL=new ArrayList<>();

            for (Bid bidPointer:car.getBids()){
                String bidInformation ="BidID: "+bidPointer.getBidId()+"; BidPrice: "+bidPointer.getBidPrice()
                        +"; BidDate: "+bidPointer.getBidDate();
                String buyerInformation = "; Buyer: "+bidPointer.getBuyer().description();
                aL.add(bidInformation+buyerInformation);
            }
            if (aL.isEmpty()){
                System.out.println("Car ("+(i+1)+") "+ car.description()+"------- No bids and buyers now");
            }else{
                System.out.println("Car ("+(i+1)+") "+ car.description()+" ------- "+ aL);
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
