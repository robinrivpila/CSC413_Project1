import java.util.Scanner;


public class AuctionItemFactory {

        public static AuctionItem createAuctionItem(String type){
            Scanner scan = new Scanner(System.in);
                System.out.println("Please enter the following details for your " + type + ": ");
            switch (type){
                case "car":
                    System.out.println("Make:");
                    String make = scan.nextLine();
                    System.out.println("Model: ");
                    String model = scan.nextLine();
                    System.out.println("Year manufactured: ");
                    int year = scan.nextInt();
                    System.out.println("Miles travelled (odometer): ");
                    int milesTravelled = scan.nextInt();
                    Car newCar = new Car(make, model,year, milesTravelled, type);
                    newCar.printItemInfo();
                    return newCar;
                case "coin":
                    System.out.println("Description: ");
                    String description = scan.nextLine();
                    System.out.println("Grade: " );
                    String grade = scan.nextLine();
                    System.out.println("Year: ");
                    year = scan.nextInt();
                    Coin newCoin = new Coin(description, grade, year, type);
                    return newCoin;
                case "collectable":
                    System.out.println("Description: ");
                    description = scan.nextLine();
                    System.out.println("Condition: " );
                    String condition = scan.nextLine();
                    Collectable newCollectable = new Collectable(description, condition, type);
                    return newCollectable;
                case "book":
                    System.out.println("Title: ");
                    String title = scan.nextLine();
                    System.out.println("Author: ");
                    String author = scan.nextLine();
                    System.out.println("Year published: ");
                    int yearPublished = scan.nextInt();
                    System.out.println("Condition");
                    condition = scan.nextLine();
                    Book newBook = new Book(title, author, yearPublished, condition);
                    return newBook;
                default:
                    return new Collectable("something", "good", "book" );
            }
        }
}
