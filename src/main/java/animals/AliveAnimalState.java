package main.java.animals;

public class AliveAnimalState implements AnimalState{

    @Override
    public void doAction(Animal animal) {
        System.out.println("Animal is alive");
        animal.setState(this);
    }
    public String toString() {
        return "Alive animal state";
    }

}
