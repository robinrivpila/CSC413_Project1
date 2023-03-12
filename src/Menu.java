import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
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
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 5:
                    isInUse = false;
                    break;
            }

        }
    }

    public void addAuctionItem(){
        AuctionItemFactory factory = new AuctionItemFactory();
        System.out.println("What kind of item would you like to add? (car, coin, collectable, or book):");
        String auctionType = scan.next();
        AuctionItem newItem= factory.createAuctionItem(auctionType.toLowerCase(Locale.ROOT));
        auctionItemList.add(newItem);
    }

    public void viewAuctionItems(){
        for (int i = 0; i < auctionItemList.size(); i++) {
            System.out.print(i+1 + ")" );
            auctionItemList.get(i).printItemInfo();
        }
    }

    public void removeAuctionItem(){
        System.out.println("The following items will be listed for auction: ");
        viewAuctionItems();
        System.out.println("Which item would you like to remove? ");
        int itemToRemove = scan.nextInt();
        auctionItemList.remove(itemToRemove-1);
        viewAuctionItems();
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
