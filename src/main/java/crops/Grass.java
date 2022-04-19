package main.java.crops;

public class Grass extends Crop{

    public Grass(String name) {
        this.setName(name);
        this.setPrice(30); //grain starts at $2 per crop at age 0
        this.setAge(0);
        this.setDiseased(false);
        this.setType("grain");
//      this.setGrowthRate(1);
//      this.setYield(1);
    }
}
