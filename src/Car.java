public class Car implements AuctionItem{
    private String make;
    private String model;
    private int year;
    private int milesTravelled;

    private String type;

    public Car(String make, String model, int year, int milesTravelled, String type){
        this.make = make;
        this.model = model;
        this.year = year;
        this.milesTravelled = milesTravelled;
        this.type = type;
    }

    public Car(){

    }

    public String getMake(){
        return make;
    }

    public String getModel(){
        return model;
    }

    public int getYear(){
        return year;
    }

    public int getMilesTravelled(){
        return milesTravelled;
    }

    @Override
    public String getType(){
        return type;
    }

    @Override
    public void printItemInfo() {
        System.out.println(type +"\nMake: " + make + "\nModel: " +
                model + "\nYear: " + year + "\nMiles Travelled: " +milesTravelled);
    }


}
