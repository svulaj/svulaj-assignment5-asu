package main.java.farmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

import main.java.crops.Crop;
import main.java.crops.DeadCropState;
import main.java.crops.DiseasedCropState;
import main.java.crops.Grass;
import main.java.crops.HealthyState;
import main.java.crops.ReadyToSellState;
import main.java.farms.Farm;

public abstract class Farmer{

    //Types: crop = crop affinities, breeder=animal affinities
    private String name;
    private String type;
    private int affinity; // Affinity = 0 = animals grow faster. || Affinity = 1 = crops grow faster.
    private int money;    // How much money a farmer has to 
    private Farm farm;
    
    
    
   
    
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
                    System.out.println("found a dead crop. That no makes: " + idx + " a dead crops and is now cleaned out");
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
    public ArrayList<Crop> findDeadCrops() {
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
        
            
        return crops;
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
        ReadyToSellState ready = new ReadyToSellState();
        boolean found = false;
        int idx = 0;
        
        while(idx <= this.farm.getCropsArr().size()) {
            
            for(Crop z : farm.getCropsArr()) {
                if(z.getState() == ready.toString()) {
                    found = true;
                    break;
                }
                idx++;
            }
            
            if(found == true) {
                //get profits
                this.setMoney(this.getMoney() + this.farm.getCropsArr().get(idx).getPrice());      
                //this.farm.getCropsArr().get(idx).getPrice();
                //remove sold crop from list of crops that farmer has
                this.farm.getCropsArr().remove(idx);
                found = false;
            }
            
        }
        
        System.out.println("player now has $"+this.getMoney() + " after selling crops");
        System.out.println("0000000000000000000000000000000000000000");
        
        for(Crop z : farm.getCropsArr()) {
            System.out.println("crop: " + z + z.getState().toString());
        }
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
            Grass grass = new Grass("grass");
            System.out.println("buying grass-->" + temp + " for: " + grass.getPrice());
            
            if(this.getMoney()-grass.getPrice() <= 0) {
                break;
            }
            
            this.setMoney(this.getMoney()-grass.getPrice());
            System.out.println("player has: " + this.getMoney());
            this.farm.getCropsArr().add(grass);
            temp++;
        }
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
            Random random = new Random();
            s.setAge(s.getAge() + 1);
            //every 4th day the crops will be ready to sell
            if(s.getAge()%4 == 0) {
                s.setState(new ReadyToSellState());
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
