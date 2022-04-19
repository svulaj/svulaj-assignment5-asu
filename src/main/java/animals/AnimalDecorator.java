package main.java.animals;

public class AnimalDecorator extends Animal{

    protected Animal tempAnimal;
    
    public AnimalDecorator(Animal animal) {
        tempAnimal = animal;
    }
    
    
    @Override
    public int feed() {
        // TODO Auto-generated method stub
        return 0;
    }

}
