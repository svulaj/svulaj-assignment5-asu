package main.java.animals;

public class Cow extends Animal{
    private final int maxSize = 20;
    


    public Cow(String name) {
        this.setName(name);
        this.setAge(0);
        this.setSize(1);
        this.setStomach(3);
        this.setType("cow");
        this.setYield(false);
        this.setYieldCount(0);
        this.setPrice(15);
    }
    
    


    @Override
    public int feed() {
        // TODO Auto-generated method stub
        return 0;
    }

    
    
    
    

}
