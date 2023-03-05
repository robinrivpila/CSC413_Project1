import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
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
                    break;
                case 4:
                    break;
                case 5:
                    isInUse = false;
                    break;
            }
            System.out.println( "List Size: " + auctionItemList.size());
        }
    }

    public void addAuctionItem(){
        AuctionItemFactory factory = new AuctionItemFactory();
        System.out.println("What kind of item would you like to add? (car, coin, collectable, or book):");
        String auctionType = scan.next();
        AuctionItem newItem= factory.createAuctionItem(auctionType);
        auctionItemList.add(newItem);
    }

    public void viewAuctionItems(){
        for (int i = 0; i < auctionItemList.size(); i++) {
            System.out.println( auctionItemList.get(i));
        }
    }
}
