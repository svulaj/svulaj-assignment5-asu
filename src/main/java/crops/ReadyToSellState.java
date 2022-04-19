package main.java.crops;

public class ReadyToSellState implements CropState{

    @Override
    public void doAction(Crop crop) {
        System.out.println("crop is ready to be sold");
        
        crop.setState(this);
    }
    public String toString() {
        return "Ready to sell state";
    }
}
