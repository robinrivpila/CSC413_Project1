import java.util.Scanner;


public class AuctionItemFactory {

        public static AuctionItem createAuctionItem(String type){
            Scanner scan = new Scanner(System.in);
            switch (type){
                case "car":
                    System.out.println("Please enter the following details for your car: ");
                    System.out.println("Make:");
                    String make = scan.nextLine();
                    System.out.println("Model: ");
                    String model = scan.nextLine();
                    System.out.println("Year manufactured: ");
                    int year = scan.nextInt();
                    System.out.println("Miles travelled (odometer): ");
                    int milesTravelled = scan.nextInt();
                    Car newCar = new Car(make, model,year, milesTravelled);
                    newCar.printItemInfo();
                    return newCar;
                default:
                    return new Coin();
            }
        }
}
