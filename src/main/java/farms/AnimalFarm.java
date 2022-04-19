package main.java.farms;

import java.util.LinkedList;
import main.java.animals.Animal;

public class AnimalFarm extends Farm{
    private final int MAX_ANIMALS = 10;//Maximum number of animals allowed on an animal farm
    private int[] animals;//the array used to hold all the animals within it
    
    public AnimalFarm(String name) {
        this.setAnimals(new int[MAX_ANIMALS]);
        this.setName(name);
        this.setPrice(200);
    }

    public int[] getAnimals() {
        return animals;
    }
    public void setAnimals(int[] animals) {
        this.animals = animals;
    }

    
    
    

    
}
