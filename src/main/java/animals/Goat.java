package main.java.animals;

public class Goat extends Animal{
    private final int maxSize = 10;
    
    
    public Goat(String name) {
        this.setName(name);
        this.setAge(1);
        this.setSize(1);
        this.setStomach(1);
        this.setType("goat");
    }

    @Override
    public int graze() {
        // TODO Auto-generated method stub
        return 0;
    }

}
