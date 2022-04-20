package main.java.farms;

import java.util.LinkedList;

import main.java.animals.Animal;

public class FarmFactory {
    int numOfAnimalFarms;
    int numOfCropFarms;

    /**
     * Description: Constructor.
     * 
     * @param choice Farm you want.
     * @param name   Name of the farm.
     * @return Returns a farm.
     */
    public Farm makeNewFarm(int choice, String name) {
        if (choice == 1) {
            return new CropFarm(name);
        } else if (choice == 2) {
            return new AnimalFarm(name);
        } else {
            return null;
        }
    }

    /**
     * Description: Generates a random name for the farm.
     * @return Returns a name for the farm.
     */
    public String nameGenAnimalFarm() {
        String newNameString = "Animal_Farm: ".concat(Integer.toString(numOfAnimalFarms));
        numOfAnimalFarms++;
        return newNameString;
    }

    /**
     * Description: Generates a random name for the farm.
     * @return Returns a name for the farm.
     */
    public String nameGenCropFarm() {
        String newNameString = "Crop_Farm: ".concat(Integer.toString(numOfCropFarms));
        numOfCropFarms++;
        return newNameString;
    }

}
