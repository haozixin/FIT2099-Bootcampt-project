import java.util.Scanner;

public class AutoShowroomDriver {
    public static void main(String[] args) {
        AutoShowroom autoShowroom = new AutoShowroom();
        int selection;
        do{
            selection = selectMenuItem();
            switch (selection){
                case 1:
                    //......
                    break;
                case 2:
                    //......
                    break;
            }
        }while (selection!=7);

        autoShowroom.printStatus();


    }

    public static int selectMenuItem(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("+----------------------------------------+");
        System.out.println("|           Welcome to Bootcamp          |");
        System.out.println("|                 Week4                  |");
        System.out.println("+----------------------------------------+");

        System.out.println("1) New Sedan");
        System.out.println("2) New Truck");
        System.out.println("3) Display Fleet");
        System.out.println("4) Add Buyer");
        System.out.println("5) List Buyers");
        System.out.println("6) Add Bid");
        System.out.println("7) Exit");
        int selection = Integer.parseInt(scanner.nextLine());
        return selection;
    }
}
