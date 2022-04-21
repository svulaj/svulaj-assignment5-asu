package main.java.farmers;

public class FarmerFactory {

    int numOfHayCropFarmers;
    int numOfAnimalFarmers;

    /**
     * Description: Constructor.
     * @param choice The farmer your want.
     * @param name The name of the farmer.
     * @return Returns a farmer.
     */
    public Farmer makeNewFarmer(int choice, String name) {
        if (choice == 1) {
            return new AnimalFarmer(name);
        } else if (choice == 2) {
            return new CropFarmer(name);
        } else {
            return null;
        }
    }

    /**
     * Description: Generates random name for the farmer.
     * @return Returns a name for the farmer.
     */
    public String nameGenCropFarmer() {
        String newNameString = "animal_Farmer_".concat(Integer.toString(numOfHayCropFarmers));
        numOfHayCropFarmers++;
        return newNameString;
    }

    /**
     * Description: Generates random name for the farmer.
     * @return Returns a name for the farmer.
     */
    public String nameGenAnimalFarmer() {
        String newNameString = "Crop_Farmer_".concat(Integer.toString(numOfAnimalFarmers));
        numOfAnimalFarmers++;
        return newNameString;
    }
}
