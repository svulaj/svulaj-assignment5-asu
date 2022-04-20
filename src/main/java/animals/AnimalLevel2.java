package main.java.animals;

public class AnimalLevel2 extends AnimalDecorator{

    public AnimalLevel2(Animal animal) {
        super(animal);
        this.setName("Level 2");
        this.setAffinity(2);
        this.setAge(animal.getAge());
        this.setName(animal.getName());
        this.setPregnantState(animal.getPregnantState());
        this.setPrice(animal.getPrice());
        this.setProductState(animal.getProductState());
        this.setState(animal.getState());
    }

    
}
