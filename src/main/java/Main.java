package main.java;
import main.java.animals.Animal;
import main.java.animals.AnimalFactory;
import main.java.crops.Crop;
import main.java.crops.CropFactory;
import main.java.farms.Farm;
import main.java.farms.FarmFactory;

public class Main {
    //Used to be able to give unique names for all of the animals
    

    /**
     * Description: the main system of the bear store.
     * @param args Is what the customer could potentially input in the future.
     */
    public static void main(String[] args) {
        //System.out.println("Hello world!!! {:^D");
        //------------------------------------------------------------------------------
        // Farm test
        FarmFactory farmFactory = new FarmFactory();
        
        Farm newFarm = farmFactory.makeNewFarm(1, farmFactory.nameGenAnimalFarm());
        Farm newFarm2 = farmFactory.makeNewFarm(1, farmFactory.nameGenAnimalFarm());
        
        Farm newFarm3 = farmFactory.makeNewFarm(2, farmFactory.nameGenCropFarm());
        Farm newFarm4 = farmFactory.makeNewFarm(2, farmFactory.nameGenCropFarm());
        
        System.out.println(newFarm.getName());
        System.out.println(newFarm2.getName());
        System.out.println(newFarm3.getName());
        System.out.println(newFarm4.getName());
        //------------------------------------------------------------------------------
        // Animals check
        AnimalFactory factory = new AnimalFactory();
        //Testing naming and creation of animals
        Animal newCow = factory.makeNewAnimal(1,factory.nameGenCow());
        Animal newCow2 = factory.makeNewAnimal(1,factory.nameGenCow());
        
        Animal newPig = factory.makeNewAnimal(2,factory.nameGenPig());
        Animal newPig2 = factory.makeNewAnimal(2,factory.nameGenPig());
        
        Animal newGoat = factory.makeNewAnimal(3,factory.nameGenGoat());
        Animal newGoat2 = factory.makeNewAnimal(3,factory.nameGenGoat());
        
        System.out.println(newCow.getName());
        System.out.println(newCow2.getName());
        
        System.out.println(newPig.getName());
        System.out.println(newPig2.getName());
        
        System.out.println(newGoat.getName());
        System.out.println(newGoat2.getName());
        //------------------------------------------------------------------------------
        // Crops check
        CropFactory cropFactory = new CropFactory();
        
        Crop newCrop = cropFactory.makeNewCrop(1, cropFactory.nameGenHay());
        Crop newCrop2 = cropFactory.makeNewCrop(1, cropFactory.nameGenHay());
        
        Crop newCrop3 = cropFactory.makeNewCrop(2, cropFactory.nameGenGrain());
        Crop newCrop4 = cropFactory.makeNewCrop(2, cropFactory.nameGenGrain());
        
        System.out.println(newCrop.getName());
        System.out.println(newCrop2.getName());
        System.out.println(newCrop3.getName());
        System.out.println(newCrop4.getName());
        //------------------------------------------------------------------------------
        // Famers check
        FarmerFactory farmerFactory = new FarmerFactory();
        
        Farmer newFarmer = farmerFactory.makeNewFarmer(1, farmerFactory.nameGenAnimalFarmer());
        Farmer newFarmer2 = farmerFactory.makeNewFarmer(1, farmerFactory.nameGenAnimalFarmer());
        
        Farmer newFarmer3 = farmerFactory.makeNewFarmer(2, farmerFactory.nameGenCropFarmer());
        Farmer newFarmer4 = farmerFactory.makeNewFarmer(2, farmerFactory.nameGenCropFarmer());
        
        
        System.out.println(newFarmer.getName());
        System.out.println(newFarmer2.getName());
        System.out.println(newFarmer3.getName());
        System.out.println(newFarmer4.getName());
    }
    
    
    
    
    
    
    
    
    
    
}
