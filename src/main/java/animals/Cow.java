package main.java.animals;

public class Cow extends Animal{
    private final int maxSize = 20;
    
    public Cow(String name) {
        this.setName(name);
        this.setAge(1);
        this.setSize(1);
        this.setStomach(1);
        this.setType("cow");
    }

    @Override
    public int graze() {
        // TODO Auto-generated method stub
        return 0;
    }
    
    
    
    

}
