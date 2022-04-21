package main.java.crops;

public class DiseasedCropState implements CropState { 

    
    @Override
    public void doAction(Crop crop) {
        System.out.println("is diseased");
        crop.setState(this);
    }
    
    public String toString() {
        return "diseased state";
    }
    
}
