package main.java.crops;

public class HealthyState implements CropState{

    @Override
    public void doAction(Crop crop) {
       System.out.println("Crop is healthy");
        crop.setState(this);
    }
    public String toString() {
        return "Healthy state";
    }
}
