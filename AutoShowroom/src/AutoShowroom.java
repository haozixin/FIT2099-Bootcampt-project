import java.util.ArrayList;
import java.util.Scanner;

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


        int  selection;
        do{
            System.out.println("You are creating a buyer, fill information please!");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please input the buyer's ID: ");
            String buyerId = scanner.nextLine();
            System.out.println("Please input the buyer's givenName: ");
            String buyerGName = scanner.nextLine();
            System.out.println("Please input the buyer's FamilyName: ");
            String buyerFName = scanner.nextLine();
            Buyer buyer1 = new Buyer(buyerId,buyerGName,buyerFName);
            System.out.println("Have created one buyer instance! Chose next step! --> Continue creating another one(1), Stop to do(0)");
            selection = scanner.nextInt();
        }while (selection==1);


        Buyer buyer2 = new Buyer("2222222","Yuanchang","Feng");


        car1.addBid(buyer1,32900.90f,"2/3/2020");
        car2.addBid(buyer2,73880f,"1/2/2021");
        car2.addBid(buyer1,100000f,"6/5/2021");
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

            System.out.println("Car ("+(i+1)+") "+ car.description()+"  "+ aL);
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
