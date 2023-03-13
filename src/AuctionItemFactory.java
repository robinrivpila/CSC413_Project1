import java.io.InvalidObjectException;
import java.util.Scanner;


public class AuctionItemFactory {

        public static AuctionItem createAuctionItem (String type) {
                Scanner scan = new Scanner(System.in);

                switch (type) {
                    case "car":
                        getDetailsMessage(type);
                        System.out.println("Make:");
                        String make = scan.nextLine();
                        System.out.println("Model: ");
                        String model = scan.nextLine();
                        System.out.println("Year manufactured: ");
                        int year = scan.nextInt();
                        System.out.println("Miles travelled (odometer): ");
                        int milesTravelled = scan.nextInt();
                        Car newCar = new Car(make, model, year, milesTravelled, type);
                        newCar.printItemInfo();
                        return newCar;
                    case "coin":
                        getDetailsMessage(type);
                        System.out.println("Description: ");
                        String description = scan.nextLine();
                        System.out.println("Grade: ");
                        String grade = scan.nextLine();
                        System.out.println("Year: ");
                        year = scan.nextInt();
                        Coin newCoin = new Coin(description, grade, year, type);
                        return newCoin;
                    case "collectable":
                        getDetailsMessage(type);
                        System.out.println("Description: ");
                        description = scan.nextLine();
                        System.out.println("Condition: ");
                        String condition = scan.nextLine();
                        Collectable newCollectable = new Collectable(description, condition, type);
                        return newCollectable;
                    case "book":
                        getDetailsMessage(type);
                        String bookCondition;
                        System.out.println("Title: ");
                        String title = scan.nextLine();
                        System.out.println("Author: ");
                        String author = scan.nextLine();
                        System.out.println("Year published: ");
                        int yearPublished = Integer.parseInt(scan.nextLine());
                        System.out.println("Condition: ");
                        bookCondition = scan.nextLine();
                        Book newBook = new Book(title, author, yearPublished, bookCondition, type);
                        return newBook;
                }
            System.out.println("Invalid object was entered. ");
            return null;
        }

        public static void getDetailsMessage(String type){
            System.out.println("Please enter the following details for your " + type + ": ");
        }
}
