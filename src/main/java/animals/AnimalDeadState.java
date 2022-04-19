package main.java.animals;

public class AnimalDeadState implements AnimalState{

    @Override
    public void doAction(Animal animal) {
        System.out.println("Animal is dead");
        animal.setState(this);
        
    }
    public String toString() {
        return "Dead animal state";
    }

}
