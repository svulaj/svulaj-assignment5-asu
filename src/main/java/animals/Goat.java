package main.java.animals;

public class Goat extends Animal{
    private final int maxSize = 10;
    
    
    public Goat(String name) {
        this.setName(name);
        this.setAge(0);
        this.setSize(1);
        this.setStomach(1);
        this.setType("goat");
        this.setYield(false);
        this.setYieldCount(0);
        this.setPrice(10);
    }

    @Override
    public int feed() {
        // TODO Auto-generated method stub
        return 0;
    }

    public int getMaxSize() {
        return maxSize;
    }

}
