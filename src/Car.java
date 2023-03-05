public class Car implements AuctionItem{
    private String make;
    private String model;
    private int year;
    private int milesTravelled;

    public Car(String make, String model, int year, int milesTravelled){
        this.make = make;
        this.model = model;
        this.year = year;
        this.milesTravelled = milesTravelled;
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
    public void printItemInfo() {
        System.out.println("\nMake: " + make + "\nModel: " +
                model + "\nYear: " + year + "\nMiles Travelled: " +milesTravelled);
    }

    @Override
    public String toString(){
        return "\nMake: " + make + "\nModel: " +
                model + "\nYear: " + year + "\nMiles Travelled: " +milesTravelled;
    }
}
