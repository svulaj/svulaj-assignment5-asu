package main.java.animals;

public class Pig extends Animal{
    private final int maxSize = 20;
    

    public Pig(String name) {
        this.setName(name);
        this.setAge(0);
        this.setSize(1);
        this.setStomach(2);
        this.setType("pig");
        this.setYield(false);
        this.setYieldCount(0);
        this.setPrice(5);
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
