package main.java.animals;

public class Pig extends Animal {
    
    /**
     * Description: Constructor.
     * @param name Name of animal.
     */
    public Pig(String name) {
        this.setName(name);
        this.setAge(0);
        this.setSize(1);
        this.setStomach(2);
        this.setType("pig");
        this.setYield(false);
        this.setYieldCount(0);
        this.setPrice(5);
        this.setState(new AliveAnimalState());
        this.setPregnantState(new NotPregnantAnimalState());
        this.setProductState(new ProductNotReadyState());
    }

}
