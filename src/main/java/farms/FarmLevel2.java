package main.java.farms;

import java.util.ArrayList;

import main.java.animals.Animal;
import main.java.animals.Cow;
import main.java.crops.Crop;
import main.java.farmers.Farmer;

public class FarmLevel2 extends FarmDecorator{
    
    private ArrayList<Animal> animalArr = new ArrayList<Animal>(10);
    

    public FarmLevel2(Farm baseFarm) {
        super(baseFarm);
        this.setName("Level 2");
        // TODO Auto-generated constructor stub
    }

    
    public void buyAnimals(Farmer farmer) {
        int temp = 0;
        for(int i = 0; i < 10;i++) {
            Cow cow = new Cow("Cow");
            System.out.println("buying grass-->" + temp + " for: " + cow.getPrice());
            
            if(this.getMoney()-cow.getPrice() <= 0) {
                break;
            }
            
            this.setMoney(this.getMoney()-cow.getPrice());
            System.out.println("player has: " + this.getMoney());
            this.animalArr.add(cow);
            temp++;
        }
    }
    
    /**
     * Description: Simply a toString method for the list of crops a farmer has
     */
    public void animalListToString() {
        int idx = 0;
        for(Animal z : this.animalArr) {
            System.out.println("Animal " + idx +  "now: " + z.getName() + " " + z.getState());
            idx++;
        }
    }
    
    
    
    
    
    @Override
    public int getMoney() {
        return tempFarm.getMoney() + 100;
        
    }

    public ArrayList<Animal> getAnimalArr() {
        return animalArr;
    }

    public void setAnimalArr(ArrayList<Animal> animalArr) {
        this.animalArr = animalArr;
    }
    
    

}
