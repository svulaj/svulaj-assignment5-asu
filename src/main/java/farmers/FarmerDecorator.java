package main.java.farmers;

public class FarmerDecorator extends Farmer {

    protected Farmer tempFarmer;

    public FarmerDecorator(Farmer farmer) {
        tempFarmer = farmer;
    }

    public String toString() {
        return tempFarmer.getName();
    }
}
