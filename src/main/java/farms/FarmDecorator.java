package main.java.farms;

public abstract class FarmDecorator extends Farm{

    protected Farm tempFarm;
    
    public FarmDecorator(Farm farm) {
        tempFarm = farm;
    }
    
    public abstract int getMoney();
    
}
