package main.java.animals;

public class Cow extends Animal { 
    /**
     * Description: Constructor.
     * @param name The name of the animal.
     */
    public Cow(String name) {
        this.setName(name);
        this.setAge(0);
        this.setSize(1);
        this.setStomach(3);
        this.setType("cow");
        this.setYield(false);
        this.setYieldCount(0);
        this.setPrice(30);
        this.setState(new AliveAnimalState());
        this.setPregnantState(new NotPregnantAnimalState());
        this.setProductState(new ProductNotReadyState());
        this.setAffinity(1);
    }

}
