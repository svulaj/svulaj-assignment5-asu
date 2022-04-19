package main.java.crops;

public class DeadCropState implements CropState{

    
    @Override
    public void doAction(Crop crop) {
        System.out.println("crop is dead");
        
        crop.setState(this);
    }
    public String toString() {
        return "Dead state";
    }
}
