package main.java.animals;

public class PregnantAnimalState implements AnimalState{

    @Override
    public void doAction(Animal animal) {
        System.out.println("Animal is pregnant");
        animal.setPregnant(this);
    }
    public String toString() {
        return "Pregnant animal state";
    }
}
