import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.security.InvalidParameterException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Menu {
    private ArrayList<AuctionItem> auctionItemList = new ArrayList<AuctionItem>();
    Scanner scan = new Scanner(System.in);

    public void mainMenu(){

        boolean isInUse = true;
        try {
        while (isInUse) {
            System.out.println("Select an option: ");
            System.out.println("1)Add a new item for auction");
            System.out.println("2)View items offered for auction");
            System.out.println("3)Remove an item");
            System.out.println("4)Save & Exit");
            System.out.println("5)Exit without saving");

                int userInput = scan.nextInt();

                switch (userInput) {
                    case 1:
                        addAuctionItem();
                        break;
                    case 2:
                        viewAuctionItems();
                        break;
                    case 3:
                        removeAuctionItem();
                        break;
                    case 4:
                        try {
                            saveAsCSV();
                            System.out.println("Saving to auctionItems.csv");
                            isInUse = false;
                        } catch (FileNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    case 5:
                        isInUse = false;
                        break;
                }

        }
        }catch(Exception e){
            System.out.println("Invalid Input");

        }
    }

    public void addAuctionItem(){
        AuctionItemFactory factory = new AuctionItemFactory();
        try {
            System.out.println("What kind of item would you like to add? (car, coin, collectable, or book):");
            String auctionType = scan.next();
            AuctionItem newItem = factory.createAuctionItem(auctionType.toLowerCase(Locale.ROOT));
            auctionItemList.add(newItem);
        }catch(Exception e){
            System.out.println("Invalid object was entered.");
            e.getMessage();
        }
    }

    public void viewAuctionItems(){
        for (int i = 0; i < auctionItemList.size(); i++) {
            System.out.print(i+1 + ")" );
            auctionItemList.get(i).printItemInfo();
        }
    }

    public void removeAuctionItem(){
        if(auctionItemList.size() < 1){
            System.out.println("Currently no auction items in list.");
            return;
        }
        System.out.println("The following items will be listed for auction: ");
        viewAuctionItems();
        try {
            System.out.println("Which item would you like to remove? ");
            int itemToRemove = scan.nextInt();
            auctionItemList.remove(itemToRemove - 1);
            System.out.println("Removing item " + (itemToRemove) + "..." );
        }catch (Exception e){
            System.out.println("Item number entered is invalid.");
        }

    }

    public void saveAsCSV() throws FileNotFoundException {
        File csvFile = new File("auctionItem.csv");
        PrintWriter out = new PrintWriter(csvFile);
        out.println("car-make, car-model, car-year, car-miles-travelled, " +
                " coin-description, coin-grade, coin-year, collectable-description, collectable-condition, " +
                "book-title, book-author, book-year-published, book-condition");
        for(AuctionItem auctionItem: auctionItemList){
            if(auctionItem instanceof Car){
                Car carAuctionItem = (Car)auctionItem;
                out.printf( "%s, %s, %d, %d,,,,,,,,,\n" , carAuctionItem.getMake(), carAuctionItem.getModel(), carAuctionItem.getYear(), carAuctionItem.getMilesTravelled());
            } else if(auctionItem instanceof Coin){
                Coin coinAuctionItem = (Coin) auctionItem;
                out.printf(",,,,%s, %s, %d,,,,,,\n", coinAuctionItem.getDescription(), coinAuctionItem.getGrade(), coinAuctionItem.getYear());
            } else if(auctionItem instanceof Collectable){
                Collectable collectableAuctionItem = (Collectable) auctionItem;
                out.printf(",,,,,,,%s, %s,,,,\n ",collectableAuctionItem.getDescription(), collectableAuctionItem.getCondition());
            }else{
                Book bookAuctionItem = (Book) auctionItem;
                out.printf(",,,,,,,,,%s, %s, %d, %s,\n ", bookAuctionItem.getTitle(), bookAuctionItem.getAuthor(), bookAuctionItem.getYearPublished(), bookAuctionItem.getCondition());
            }
        }

        out.close();
    }
}
