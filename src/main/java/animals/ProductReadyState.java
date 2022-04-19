package main.java.animals;

public class ProductReadyState implements AnimalState{

    @Override
    public void doAction(Animal animal) {
        System.out.println("Product is ready");
        animal.setProductState(this);
    }
    public String toString() {
        return "Product ready state";
    }
}
