package main.java.animals;

public class NotPregnantAnimalState implements AnimalState {

    @Override
    public void doAction(Animal animal) {
        System.out.println("Animal is NOT pregnant");
        animal.setPregnantState(this);
    }

    public String toString() {
        return "NOT Pregnant animal state";
    }
}
