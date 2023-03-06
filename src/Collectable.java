public class Collectable implements AuctionItem{
    private String description;
    private String condition;

    public Collectable(String description, String condition){
        this.description = description;
        this.condition = condition;
    }

    public String getDescription(){
        return description;
    }

    public String getCondition(){
        return condition;
    }

    @Override
    public void printItemInfo() {
        System.out.println("Description: " + description + "\nCondition: " + condition);
    }
}
