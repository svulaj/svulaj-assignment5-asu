package main.java.farms;

import java.util.ArrayList;

import main.java.animals.Animal;

public class FarmLevel2 extends FarmDecorator{
    
    private ArrayList<Animal> animalArr = new ArrayList<Animal>(10);

    public FarmLevel2(Farm baseFarm) {
        super(baseFarm);
        this.setName("Level 2");
        // TODO Auto-generated constructor stub
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
