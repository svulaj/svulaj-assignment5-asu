package main.java.farms;

import java.util.LinkedList;
import main.java.animals.Animal;

public class AnimalFarm extends Farm{
    // list to keep track of all the animals in this particular farm
    private LinkedList<Animal> animals;
    
    public AnimalFarm(String name) {
        this.animals = new LinkedList<Animal>();
        this.setName(name);
    }
    
    

    public LinkedList<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(LinkedList<Animal> animals) {
        this.animals = animals;
    }
}
