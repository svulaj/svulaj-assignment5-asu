package main.java.animals;

public class AnimalLevel2 extends AnimalDecorator{

    public AnimalLevel2(Animal animal) {
        super(animal);
        this.setName("Level 2");
    }

    
}
