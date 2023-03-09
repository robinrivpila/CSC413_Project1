public class Book implements AuctionItem{
    private String title;
    private String author;
    private int yearPublished;
    private String condition;

    private String type;

    public Book(String title, String author, int yearPublished, String condition){
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.condition = condition;
    }

    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }

    public int getYearPublished(){
        return yearPublished;
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
        System.out.println( type + "\nTitle: " + title + "\nAuthor: " + author +
                "\nYear published: " + yearPublished + "\nCondition: " + condition);
    }
}
