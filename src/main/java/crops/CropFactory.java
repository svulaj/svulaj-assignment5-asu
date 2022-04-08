package main.java.crops;

import main.java.farms.AnimalFarm;
import main.java.farms.CropFarm;
import main.java.farms.Farm;

public class CropFactory {
    int numOfHayCrops;
    int numOfGrainCrops;
    
    public Crop makeNewCrop(int choice, String name) {
        if(choice == 1) {
            return new Hay(name);
        }else if(choice == 2) {
            return new Grain(name);
        }else {
            return null;
        }
    }
    
    public String nameGenHay() {
        String newNameString = "Hay_".concat(Integer.toString(numOfHayCrops));
        numOfHayCrops++;
        return newNameString;
    }
    public String nameGenGrain() {
        String newNameString = "Grain_".concat(Integer.toString(numOfGrainCrops));
        numOfGrainCrops++;
        return newNameString;
    }

}
