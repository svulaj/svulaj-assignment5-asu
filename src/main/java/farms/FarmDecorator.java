package main.java.farms;

public abstract class FarmDecorator extends Farm {

    protected Farm tempFarm;

    public FarmDecorator(Farm farm) {
        tempFarm = farm;
    }

    public abstract int getMoney();
    
    /**
     * Description: Gets name of this farm.
     * @return Returns the name of the farm.
     */
    public String getNameOfFarm() {
        return tempFarm.getName();
    }

}
