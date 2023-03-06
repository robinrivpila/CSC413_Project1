public class Coin implements AuctionItem{
    private String description;
    private String grade;
    private int year;
    public Coin(String description, String grade, int year){
        this.description = description;
        this.grade = grade;
        this.year = year;
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
    public void printItemInfo() {
        System.out.println("Description: " + description + "\nGrade: " + grade +
                "\nYear: " + year);

    }
}
