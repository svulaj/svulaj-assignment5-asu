package main.java.animals;

public class Goat extends Animal {

    /**
    * Description: Constructor.
    * 
    * @param name Name of the animal.
    */
    public Goat(String name) {
        this.setName(name);
        this.setAge(0);
        this.setSize(1);
        this.setStomach(1);
        this.setType("goat");
        this.setYield(false);
        this.setYieldCount(0);
        this.setPrice(10);
        this.setState(new AliveAnimalState());
        this.setPregnantState(new NotPregnantAnimalState());
        this.setProductState(new ProductNotReadyState());
    }

}
