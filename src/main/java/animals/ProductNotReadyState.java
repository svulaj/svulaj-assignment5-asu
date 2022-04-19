package main.java.animals;

public class ProductNotReadyState implements AnimalState{

    @Override
    public void doAction(Animal animal) {
        System.out.println("Product is NOT ready");
        animal.setProduct(this);
    }
    public String toString() {
        return "Product: NOT ready state";
    }

    
}
