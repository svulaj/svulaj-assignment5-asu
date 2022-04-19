package main.java.crops;

public class CropFactory {
    int numOfHayCrops;
    int numOfGrainCrops;
    int numOfGrainGrass;
    
    public Crop makeNewCrop(int choice, String name) {
        if(choice == 1) {
            return new Hay(name);
        }else if(choice == 2) {
            return new Grain(name);
        }else if(choice ==3){
            return new Grass(name); 
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
    public String nameGenGrass() {
        String newNameString = "Grain_".concat(Integer.toString(numOfGrainGrass));
        numOfGrainGrass++;
        return newNameString;
    }

}
