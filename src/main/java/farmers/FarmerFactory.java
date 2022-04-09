package main.java.farmers;

public class FarmerFactory {

    int numOfHayCropFarmers;
    int numOfAnimalFarmers;
    
    public Farmer makeNewFarmer(int choice, String name) {
        if(choice == 1) {
            return new AnimalFarmer(name);
        }else if(choice == 2) {
            return new CropFarmer(name);
        }else {
            return null;
        }
    }
    
    public String nameGenCropFarmer() {
        String newNameString = "animal_Farmer_".concat(Integer.toString(numOfHayCropFarmers));
        numOfHayCropFarmers++;
        return newNameString;
    }
    public String nameGenAnimalFarmer() {
        String newNameString = "Crop_Farmer_".concat(Integer.toString(numOfAnimalFarmers));
        numOfAnimalFarmers++;
        return newNameString;
    }
}
