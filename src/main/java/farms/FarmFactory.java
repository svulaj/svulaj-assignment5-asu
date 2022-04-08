package main.java.farms;

import java.util.LinkedList;

import main.java.animals.Animal;

public class FarmFactory {
    int numOfAnimalFarms;
    int numOfCropFarms;
    
    public Farm makeNewFarm(int choice, String name) {
        if(choice == 1) {
            return new AnimalFarm(name);
        }else if(choice == 2) {
            return new CropFarm(name);
        }else {
            return null;
        }
    }
    
    public String nameGenAnimalFarm() {
        String newNameString = "Animal_Farm: ".concat(Integer.toString(numOfAnimalFarms));
        numOfAnimalFarms++;
        return newNameString;
    }
    public String nameGenCropFarm() {
        String newNameString = "Crop_Farm: ".concat(Integer.toString(numOfCropFarms));
        numOfCropFarms++;
        return newNameString;
    }
    
    
}
