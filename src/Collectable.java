public class Collectable implements AuctionItem{
    private String description;
    private String condition;

    private String type;
    public Collectable(String description, String condition, String type){
        this.description = description;
        this.condition = condition;
        this.type = type;
    }

    public String getDescription(){
        return description;
    }

    public String getCondition(){
        return condition;
    }

    @Override
    public String getType(){
        return type;
    }

    @Override
    public void printItemInfo() {
        System.out.println( type +"Description: " + description + "\nCondition: " + condition);
    }
}
