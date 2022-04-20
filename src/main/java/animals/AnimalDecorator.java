package main.java.animals;

public class AnimalDecorator extends Animal { 

    protected Animal tempAnimal;
    
    public AnimalDecorator(Animal animal) {
        tempAnimal = animal;
    }
    
    public String toString() {
        return tempAnimal.getName();
    }
    

}
