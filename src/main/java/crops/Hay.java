package main.java.crops;

public class Hay extends Crop{
    
    public Hay(String name) {
        this.setName(name);
        this.setPrice(40); //grain starts at $2 per crop at age 0
        this.setAge(0);
        this.setDiseased(false);
        this.setType("grain");
//      this.setGrowthRate(1);
//      this.setYield(1);
    }

}
