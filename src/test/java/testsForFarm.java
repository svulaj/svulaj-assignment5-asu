

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert.*;

import main.java.Main;
import main.java.animals.AliveAnimalState;
import main.java.animals.Animal;
import main.java.animals.AnimalDeadState;
import main.java.animals.AnimalFactory;
import main.java.animals.Cow;
import main.java.animals.Goat;
import main.java.animals.Pig;
import main.java.animals.ProductReadyState;
import main.java.crops.DeadCropState;
import main.java.crops.DiseasedCropState;
import main.java.crops.HealthyState;
import main.java.crops.ReadyToSellState;
import main.java.farmers.AnimalFarmer;
import main.java.farmers.CropFarmer;
import main.java.farmers.Farmer;
import main.java.farmers.FarmerFactory;
import main.java.farms.AnimalFarm;
import main.java.farms.CropFarm;
import main.java.farms.Farm;
import main.java.farms.FarmFactory;

public class testsForFarm {

    
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
    }
    
    @Test
    public void factoryTest() {
        FarmFactory farmFactory = new FarmFactory();
        Farm baseFarm = farmFactory.makeNewFarm(1, "test");
        CropFarm expected = new CropFarm("test");
        
        Farm baseFarm2 = farmFactory.makeNewFarm(2, "test");
        AnimalFarm expected2 = new AnimalFarm("test");
        
        equals(baseFarm.equals(expected));
        equals(baseFarm2.equals(expected2));
        //---------------------------------------------------
        AnimalFactory aFactory = new AnimalFactory(); 
        Animal animal1 =aFactory.makeNewAnimal(1, "cow1"); 
        Animal animal2 =aFactory.makeNewAnimal(2, "pig1");
        Animal animal3 =aFactory.makeNewAnimal(3, "goat1");
        
        Cow expectedCow = new Cow("test1");
        Pig expectedPig = new Pig("test1");
        Goat epectedGoat = new Goat("test1");
        
        equals(animal1.equals(expectedCow));
        equals(animal2.equals(expectedPig));
        equals(animal3.equals(epectedGoat));
        
        
        FarmerFactory farmerFactory = new FarmerFactory();
        Farmer farmer1 = farmerFactory.makeNewFarmer(1, "test1");
        Farmer farmer2 = farmerFactory.makeNewFarmer(2, "test2");
        
        AnimalFarmer animalFarmer = new AnimalFarmer("expect1");
        CropFarmer cropFarmer = new CropFarmer("expect2");
        
        equals(farmer1.equals(animalFarmer));
        equals(farmer2.equals(cropFarmer));
    }

    
    @Test
    public void farmerUpgradeFarm() {
        FarmerFactory farmerFactory = new FarmerFactory();
        Farmer farmer1 = farmerFactory.makeNewFarmer(1, "test1");
        farmer1.upgradeFarm(farmer1.getFarm());
        
        equals(farmer1.getFarm().getName().equals("Level 2"));
    }
    
    @Test
    public void farmerBuyAnimals() {
        FarmerFactory farmerFactory = new FarmerFactory();
        Farmer farmer1 = farmerFactory.makeNewFarmer(1, "test1");
        
        FarmFactory farmFactory = new FarmFactory();
        Farm baseFarm = farmFactory.makeNewFarm(1, farmFactory.nameGenCropFarm());
        farmer1.setFarm(baseFarm);
        
        farmer1.setMoney(500);
        farmer1.buyAnimals();
        
        assertEquals(200,farmer1.getMoney());
        
    }
    
    
    @Test
    public void farmerAgeAnimals() {
        FarmerFactory farmerFactory = new FarmerFactory();
        Farmer farmer1 = farmerFactory.makeNewFarmer(1, "test1");
        FarmFactory farmFactory = new FarmFactory();
        Farm baseFarm = farmFactory.makeNewFarm(1, farmFactory.nameGenCropFarm());
        farmer1.setFarm(baseFarm);
        farmer1.setMoney(500);
        farmer1.buyAnimals();
        
        farmer1.ageAnimals();
        
        assertEquals(1,farmer1.getFarm().getAnimalArr().get(0).getAge());
        
        
        for(Animal f : farmer1.getFarm().getAnimalArr()) {
            f.setName("Level 2");
        }
        farmer1.ageAnimals();
        
        assertEquals(3,farmer1.getFarm().getAnimalArr().get(0).getAge());
    }
    
    @Test
    public void farmerProductAvail() {
        FarmerFactory farmerFactory = new FarmerFactory();
        Farmer farmer1 = farmerFactory.makeNewFarmer(1, "test1");
        FarmFactory farmFactory = new FarmFactory();
        Farm baseFarm = farmFactory.makeNewFarm(1, farmFactory.nameGenCropFarm());
        farmer1.setFarm(baseFarm);
        farmer1.setMoney(500);
        farmer1.buyAnimals();
        
        farmer1.ageAnimals();
        farmer1.ageAnimals();
        farmer1.ageAnimals();
        farmer1.ageAnimals();
        farmer1.ageAnimals();
        
        equals(0 < farmer1.productAvailCount());
    }
    
    
    @Test
    public void farmerPredAttack() {
        FarmerFactory farmerFactory = new FarmerFactory();
        Farmer farmer1 = farmerFactory.makeNewFarmer(1, "test1");
        FarmFactory farmFactory = new FarmFactory();
        Farm baseFarm = farmFactory.makeNewFarm(1, farmFactory.nameGenCropFarm());
        farmer1.setFarm(baseFarm);
        farmer1.setMoney(500);
        farmer1.buyAnimals();
        
        farmer1.predatorAttack();
        farmer1.predatorAttack();
        farmer1.predatorAttack();
        
        
        assertNotEquals(10,farmer1.liveStockNumCount());
    }
    
    
    @Test
    public void farmerFindDeadAnimals() {
        FarmerFactory farmerFactory = new FarmerFactory();
        Farmer farmer1 = farmerFactory.makeNewFarmer(1, "test1");
        FarmFactory farmFactory = new FarmFactory();
        Farm baseFarm = farmFactory.makeNewFarm(1, farmFactory.nameGenCropFarm());
        farmer1.setFarm(baseFarm);
        farmer1.setMoney(500);
        farmer1.buyAnimals();
        
        AnimalDeadState dead = new AnimalDeadState();
        AliveAnimalState alive = new AliveAnimalState();
        farmer1.getFarm().getAnimalArr().get(0).setState(dead);
        farmer1.predatorAttack();
        farmer1.predatorAttack();
        farmer1.predatorAttack();
        farmer1.predatorAttack();
        
        farmer1.findDeadAnimals();
        assertEquals(farmer1.getFarm().getAnimalArr().get(0).getState().toString(), alive.toString());
    }
    
    
    @Test
    public void farmerSellAnimalProd() {
        FarmerFactory farmerFactory = new FarmerFactory();
        Farmer farmer1 = farmerFactory.makeNewFarmer(1, "test1");
        FarmFactory farmFactory = new FarmFactory();
        Farm baseFarm = farmFactory.makeNewFarm(1, farmFactory.nameGenCropFarm());
        farmer1.setFarm(baseFarm);
        farmer1.setMoney(500);
        farmer1.buyAnimals();
        
        farmer1.ageAnimals();
        farmer1.ageAnimals();
        farmer1.ageAnimals();
        farmer1.ageAnimals();
        
        farmer1.sellanimalProduct();
        assertEquals(800,farmer1.getMoney());
    }
    
    @Test
    public void farmerAgeCropAndBuyCrop() {
        FarmerFactory farmerFactory = new FarmerFactory();
        Farmer farmer1 = farmerFactory.makeNewFarmer(1, "test1");
        FarmFactory farmFactory = new FarmFactory();
        Farm baseFarm = farmFactory.makeNewFarm(1, farmFactory.nameGenCropFarm());
        farmer1.setFarm(baseFarm);
        farmer1.setMoney(500);
        farmer1.buyCrop();
        
        farmer1.ageCrops();
        farmer1.ageCrops();
        farmer1.ageCrops();
        farmer1.ageCrops();
        ReadyToSellState ready = new ReadyToSellState();
        assertEquals(farmer1.getFarm().getCropsArr().get(0).getSellState().toString(),ready.toString());
    }
    
    @Test
    public void farmerSellCrop() {
        FarmerFactory farmerFactory = new FarmerFactory();
        Farmer farmer1 = farmerFactory.makeNewFarmer(1, "test1");
        FarmFactory farmFactory = new FarmFactory();
        Farm baseFarm = farmFactory.makeNewFarm(1, farmFactory.nameGenCropFarm());
        farmer1.setFarm(baseFarm);
        farmer1.setMoney(500);
        farmer1.buyCrop();
        
        farmer1.ageCrops();
        farmer1.ageCrops();
        farmer1.ageCrops();
        farmer1.ageCrops();
        
        farmer1.sellCrops();
        equals(200 < farmer1.getMoney());
    }
    
    @Test
    public void farmerFindDEadCrop() {
        FarmerFactory farmerFactory = new FarmerFactory();
        Farmer farmer1 = farmerFactory.makeNewFarmer(1, "test1");
        FarmFactory farmFactory = new FarmFactory();
        Farm baseFarm = farmFactory.makeNewFarm(1, farmFactory.nameGenCropFarm());
        farmer1.setFarm(baseFarm);
        farmer1.setMoney(500);
        farmer1.buyCrop();
    
        
        HealthyState healthyState = new HealthyState(); // healthy check
        farmer1.ageCrops();
        farmer1.ageCrops();
        farmer1.ageCrops();
        farmer1.ageCrops();
        farmer1.ageCrops();
        farmer1.ageCrops();
        farmer1.ageCrops();
        farmer1.ageCrops();
        
        farmer1.findDeadCrops();
        assertEquals(farmer1.getFarm().getCropsArr().get(0).getState().toString(),healthyState.toString());
        
        
    }
    
    
}
