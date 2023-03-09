public class Coin implements AuctionItem{
    private String description;
    private String grade;
    private int year;

    private String type;
    public Coin(String description, String grade, int year, String type){
        this.description = description;
        this.grade = grade;
        this.year = year;
        this.type = type;

    }

    public String getDescription(){
        return description;
    }

    public String getGrade(){
        return grade;
    }

    public int getYear(){
        return year;
    }

    @Override
    public String getType(){
        return type;
    }

    @Override
    public void printItemInfo() {
        System.out.println(type + "\nDescription: " + description + "\nGrade: " + grade +
                "\nYear: " + year);

    }
}
