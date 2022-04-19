package main.java.farmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

import main.java.animals.AliveAnimalState;
import main.java.animals.Animal;
import main.java.animals.AnimalDeadState;
import main.java.animals.AnimalFactory;
import main.java.animals.Cow;
import main.java.animals.NotPregnantAnimalState;
import main.java.animals.PregnantAnimalState;
import main.java.animals.ProductNotReadyState;
import main.java.animals.ProductReadyState;
import main.java.crops.Crop;
import main.java.crops.CropFactory;
import main.java.crops.DeadCropState;
import main.java.crops.DiseasedCropState;
import main.java.crops.Grass;
import main.java.crops.HealthyState;
import main.java.crops.NotReadyToSellState;
import main.java.crops.ReadyToSellState;
import main.java.farms.Farm;
import main.java.farms.FarmLevel2;

public abstract class Farmer{

    //Types: crop = crop affinities, breeder=animal affinities
    private String name;
    private String type;
    private int affinity; // Affinity = 0 = animals grow faster. || Affinity = 1 = crops grow faster.
    private int money;    // How much money a farmer has to 
    private Farm farm;
    
    
    
//======================================================================================================================
//FARM SECTION  
    /**
     * Description: This method simply upgrade the farm to a level 2 farm.
     *              Which now allows the farm to have animals
     * @param farm - The farm that you wish to upgrade
     * 
     * NOTE: This method uses the Decorator DP.
     * NOTE: works
     */
    public void upgradeFarm(Farm farm) {
        farm = new FarmLevel2(farm);
        this.farm = farm;
        System.out.println("Farm upgraded!");
    }
//======================================================================================================================
//FARM SECTION  
    
    
    
    
//======================================================================================================================
//ANIMAL SECTION  
    
    /**
     * Description: Buys the max amount of animals the farmer can afford
     * 
     * NOTE: Works
     * 
     */
    public void buyAnimals() {
        int temp = 0;
        
        AnimalFactory animalFactory = new AnimalFactory();
        
        
        for(int i = 0; i < 10;i++) {
            Animal newAnimal = animalFactory.makeNewAnimal(1, animalFactory.nameGenCow());
            System.out.println("tying to buy Cow-->" + temp + " for: $" + newAnimal.getPrice());
            
            if(this.getMoney()-newAnimal.getPrice() <= 0) {
                System.out.println("NOT ENOUGH MONEY TO BUY COW");
                break;
            }
            System.out.println("animal bought");
            this.setMoney(this.getMoney()-newAnimal.getPrice());
            System.out.println("player has: " + this.getMoney());
            this.farm.getAnimalArr().add(newAnimal);
            temp++;
        }
    }
    
    /**
     * Description: Ages all of the animals that a farmer owns
     * 
     * NOTE: works
     */
    public void ageAnimals() {
        AnimalDeadState dead = new AnimalDeadState();
        AliveAnimalState alive = new AliveAnimalState();
        
        ProductReadyState ready = new ProductReadyState();
        ProductNotReadyState notReady = new ProductNotReadyState();
        
        PregnantAnimalState prego = new PregnantAnimalState();
        NotPregnantAnimalState notPrego = new NotPregnantAnimalState();
        
        //ages all the animals by one day
        for(Animal r : this.getFarm().getAnimalArr()) {
            //if animal is level 2 is grows faster
            if(r.getName().equals("Level 2")) {
                System.out.println("This animal is level 2 so it grows twice as fast");
                r.setAge(r.getAge()+2);
            }else {
                r.setAge(r.getAge()+1);
            }
        }
        //every 2 days animal product is ready. Also animal has to be older than 3yo.
        for(Animal r : this.getFarm().getAnimalArr()) {
            if(r.getAge()%2 == 0 && r.getAge() > 3) {
                r.setProductState(ready);
            }
        }
        //runs the chance of an animal being born
        birthAnimal();
    }
    
    /**
     * Description: Runs the chance of an animal being born.
     * 
     * NOTE: uses DP Factory
     */
    public void birthAnimal() {
        AnimalFactory animalFactory = new AnimalFactory();
        Animal newAnimal = animalFactory.makeNewAnimal(1, animalFactory.nameGenCow());
        //ArrayList<Animal> tempArr = new ArrayList<Animal>(10);
        Random random = new Random();
        
            //if 2 cows exist a baby cow has a 1/4 chance of being born
            if(liveStockNumCount() >= 2 && random.nextInt(4) == 1) {
                this.farm.getAnimalArr().add(newAnimal);
                System.out.println("//////////////////////////////////////////////////////");
                System.out.println("A baby cow has been born!");
                System.out.println("//////////////////////////////////////////////////////");
            }
        
    }
    
    /**
     * Description: Simply returns the number of animals a farmer has
     * @return
     */
    public int liveStockNumCount() {
        int count = 0;
        
        for(Animal r : this.getFarm().getAnimalArr()) {
            count++;
        }
        System.out.println("Livestock count = " + count + " animals in farm");
        return count;
    }
    
    /**
     * Description: Utility method to tell us how many products are available
     * @return the number of milk that is a available to sell
     */
    public int productAvailCount() {
        ProductReadyState ready = new ProductReadyState();
        int count = 0;
        
        for(Animal r : this.getFarm().getAnimalArr()) {
            if(r.getProductState().toString().equals(ready.toString())) {
                count++;
            }
        }
        System.out.println("Product count = " + count + " milk available");
        return count;
    }
    
    
    /**
     * Description: Simulates an animal attack
     */
    public void predatorAttack() {
        Random random = new Random();
        ArrayList<Animal> tempArr = new ArrayList<Animal>(10);
        AnimalDeadState dead = new AnimalDeadState();
        AliveAnimalState alive = new AliveAnimalState();
        
      //chance for getting killed by a predator
        for(Animal r : this.getFarm().getAnimalArr()) {
            // 1/3 chance of a predator killing an animal
            if(random.nextInt(2) == 1) {
                System.out.println("Anaimal ATTACK!!!! Animal state = " + r.getState());
                r.setState(dead);
                System.out.println("after animal attack the Animal state = " + r.getState());
            }
        }
        //add all animals that survived to a temp list of animals
        for(Animal r : this.getFarm().getAnimalArr()) {
            if(r.getState().toString().equals(alive.toString())) {
                tempArr.add(r);
            }
        }
        //Sets list of all animals that survived to the farmer
        this.farm.setAnimalArr(tempArr);
    }
    
    
    /**
     * Description: finds all of the dead animals that a farmer has and then
     *              puts all of the healthy animals in a new list
     * @return
     */
    public void findDeadAnimals() {
        ArrayList<Animal> tempArr = new ArrayList<Animal>(10);
        
        AnimalDeadState dead = new AnimalDeadState();
        AliveAnimalState alive = new AliveAnimalState();
       
        
        for(Animal z : this.farm.getAnimalArr()) {
            
            if(z.getState().toString().equals(alive.toString())) {
                System.out.println("Crop state: " + z.getState().toString() + "Age is: " + z.getAge());
                tempArr.add(z);
            }else if(z.getState().toString().equals(dead.toString())) {
                System.out.println("Dead Animal FOUND!!! The state of it is: " + z.getState().toString() + " .....DISCARDING");
            }
            
        }
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        
         
        //sets farms crop list to the new list with all the health crops in it
        this.farm.setAnimalArr(tempArr);
    }
    
    /**
     * Description: Checks if animals product state equals ready, if it does then
     *              product is sold to $60 profit and the state set back to not ready.
     */
    public void sellanimalProduct() {
        ProductReadyState ready = new ProductReadyState();
        ProductNotReadyState notReady = new ProductNotReadyState();
        
        for(Animal r : this.getFarm().getAnimalArr()) {
            //if animal has product
            if(r.getProductState().toString().equals(ready.toString())) {
                System.out.println("product = ready. animal prod. state= " + r.getProductState());
                this.setMoney(this.getMoney()+60);
                //then set product state back to not ready
                r.setProductState(notReady);
                System.out.println("product = sold. animal prod. state= " + r.getProductState());
            }
            
            else if(r.getProductState().toString().equals(notReady.toString())){
                System.out.println("no product to be sold");
            }
            
            
        }
        System.out.println("after trying to sell animals, players money on hand is now: $" + this.getMoney());
        
    }
    
    
    /**
     * Description: Simple toString method to print out the list of animals a farmer has
     */
    public void animalListToString() {
        int idx = 0;
        for(Animal z : this.farm.getAnimalArr()) {
            System.out.println("Animal " + idx +  " now: " + z.getName() + " " + z.getState());
            idx++;
        }
    }
    
    
    
   
//======================================================================================================================
//CROP SECTION
    /**
     * Description: This method checks to see if any crops are ready to be sold based on the toStrings of the state
     * @return True if there are crops to be sold, else returns false if there are non that are ready
     * @author Shaun Vulaj
     * 
     * NOTE: works
     */
    public void areCropsReady() {
        ReadyToSellState ready = new ReadyToSellState();
        int idx = 0;
        for(Crop z : this.farm.getCropsArr()) {
            if(z.getState() == ready.toString()) {
                System.out.println("this crop is ready to be sold");
            }else {
                System.out.println(idx + " crop is not ready. Crop state= " + z.getState());
                
                
            }
            idx++;
        }
    }
    /**
     * Description: finds & Removes dead crops from crop list.
     */
    public boolean DeadCropsCheck() {
        int idx = 0;
        boolean found = false;
        DiseasedCropState diseased = new DiseasedCropState();
        System.out.println("idx=" + idx);
        while(idx <= this.farm.getCropsArr().size()) {
            
            
            for(Crop z : this.farm.getCropsArr()) {
                //checks if there is a diseased crop. If true signals that one is found and needs to be deleted
                if(z.getState().toString().equals(diseased.toString())) {
                    //this.farm.getCropsArr().remove(idx);
                    found = true;
                    System.out.println("found a dead crop. That now makes: " + idx + " a dead crops and is now cleaned out");
                    return true;
                }
                idx++;
            }
        }
        return false;
        }
    
    /**
     * Description: Finds the dead crops that a farmer has. 
     * @return Returns a new crop list with all the healthy crops
     */
    public void findDeadCrops() {
        DiseasedCropState diseased = new DiseasedCropState();// disease check
        HealthyState healthyState = new HealthyState(); // healthy check
        DeadCropState deadCropState = new DeadCropState();
        ArrayList<Crop> crops = new ArrayList<Crop>(10); // new list to return back
        
        for(Crop z : this.farm.getCropsArr()) {
            
            if(z.getState().toString().equals(healthyState.toString())) {
                System.out.println("Crop state: " + z.getState().toString());
                crops.add(z);
            }else if(z.getState().toString().equals(diseased.toString())) {
                System.out.println("Diseased Crop FOUND!!! The state of it is: " + z.getState().toString() + " .....DISCARDING");
            }else if(z.getState().toString().equals(deadCropState.toString())) {
                System.out.println("Dead Crop FOUND!!! The state of it is: " + z.getState().toString() + " .....DISCARDING");
            }
            
        }
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        
            //this.cropListToString();
        
        //sets farms crop list to the new list with all the health crops in it
        this.farm.setCropsArr(crops);
    }
    
    /**
     * Description: Simply a toString method for the list of crops a farmer has
     */
    public void cropListToString() {
        int idx = 0;
        for(Crop z : this.farm.getCropsArr()) {
            System.out.println("crop " + idx +  "now: " + z.getName() + " " + z.getState());
            idx++;
        }
    }
    
    /*
     * Description: This method sells the crops that are ready to be sold.
     * @author Shaun Vulaj 
     * 
     * NOTE: Works
     */
    public void sellCrops() {
        ArrayList<Crop> sellArr = new ArrayList<Crop>(10);
        ArrayList<Crop> keepArr = new ArrayList<Crop>(10);
        ReadyToSellState ready = new ReadyToSellState();
        NotReadyToSellState notReady = new NotReadyToSellState();
        //boolean found = false;
        
            
            for(Crop z : farm.getCropsArr()) {
                //if crop is ready to be sold, we sell
                if(z.getSellState().toString().equals(ready.toString())) {
                    System.out.println("crop to be sold, age: " + z.getAge());
                    //adds ready to sell crop to list
                    sellArr.add(z);
                }
                //if crop is not ready to be sold, we keep it
                else if(z.getSellState().toString().equals(notReady.toString())) {
                    keepArr.add(z);
                }
            }
         
        
      //selling crops in sell list
        for(Crop s : sellArr) {
            this.setMoney(this.getMoney() + s.getPrice());
           // System.out.println("crop sold");
        }
        
        //updated list of crops that 
        this.getFarm().setCropsArr(keepArr);
        System.out.println("after trying to sell crops, players money on hand is now: $" + this.getMoney());
    }
    
    /**
     * Description: Simply purchases a crop for the farmer
     * @param crop
     * 
     * NOTE: Works
     */
    public void buyCrop() {
        
        int temp = 0;
        for(int i = 0; i < 10;i++) {
//            Grass grass = new Grass("grass");
            CropFactory cropFactory = new CropFactory();
            Crop newcrop = cropFactory.makeNewCrop(3, cropFactory.nameGenGrass());
            System.out.println("Trying to buy grass-->" + temp + " for: $" + newcrop.getPrice());
            
            if(this.getMoney()-newcrop.getPrice() <= 0) {
                System.out.print("not enough money to buy crop. ");
                System.out.println("Player only has $" + this.getMoney() + " left!");
                break;
            }
            System.out.println("Crop " + temp + " bought");
            this.setMoney(this.getMoney()-newcrop.getPrice());
            System.out.println("player has: " + this.getMoney());
            this.farm.getCropsArr().add(newcrop);
            temp++;
        }
        System.out.println("Total amount of money player has left $" + this.getMoney() + " left!");
    }
    
    
    
    
    /**
     * Description: Utility to retrieve the size of the crop arrayList of the farmers farm
     * @return
     */
    public int getFarmsCropInventorySize() {
        return this.getFarm().getCropsArr().size();
    }
   
    /**
     * Description: Utility to retrieve the size of the animal arrayList of the farmers farm
     * @return
     */
//    public int getFarmsAnimalInventorySize() {
//        return this.getFarm().getAnimalArr().size();
//    }
    
    /**
     * Description: This method ages the crops in a farmers farm by one day.
     *              When aging, there is a 1/10 chance of a crop becoming diseased.
     *              Every 4th day the crop will become ready to sell
     */
    public void ageCrops() {
        DiseasedCropState diseased = new DiseasedCropState();// disease check
        for(Crop s : this.farm.getCropsArr()) {
            //System.out.println("age check: " + s.getAge());
            Random random = new Random();
            //if the farmer has reached level 2 then crops will grow twice as fast
            //allowing them to be sold faster
            if(s.getName().equals("Level 2")) {
                System.out.println("Crop is affected by farmers affinity so a crop grows by 2 instead of 1");
                s.setAge(s.getAge() + 2);
            }else {
                s.setAge(s.getAge() + 1);
                 //System.out.println("crop age = " + s.getAge());
            }
            //every 4th day the crops will be ready to sell
            if(s.getAge()%4 == 0) {
                s.setSellState(new ReadyToSellState());
            }
            //Crops have a 1/10 chances of becoming diseases
            if(random.nextInt(10) == 5) {
                //if already diseased, crop dies
                s.setState(new DiseasedCropState());
            }
            else if(s.getState().toString().equals(diseased.toString())) {
                s.setState(new DeadCropState());
            }
        }
        
    }
    //======================================================================================================
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public int getAffinity() {
        return affinity;
    }
    public void setAffinity(int affinity) {
        this.affinity = affinity;
    }
    
    public int getMoney() {
        return money;
    }
    public void setMoney(int money) {
        this.money = money;
    }
    public Farm getFarm() {
        return farm;
    }
    public void setFarm(Farm farm) {
        this.farm = farm;
    }
    
    
}