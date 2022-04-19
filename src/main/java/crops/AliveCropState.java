package main.java.crops;

public class AliveCropState implements CropState{

    
    @Override
    public void doAction(Crop crop) {
        System.out.println("crop is alive");
        
        crop.setState(this);
    }
    public String toString() {
        return "Alive state";
    }

}
