package main.java.crops;

public class NotReadyToSellState implements CropState { 

    @Override
    public void doAction(Crop crop) {
        crop.setState(this);
        System.out.println("crop is NOT ready to be sold");
    }
    
    public String toString() {
        return "not ready to sell state";
    }

}
