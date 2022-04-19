package main.java.crops;

public class Grain extends Crop{
    


    public Grain(String name) {
        this.setPrice(50); //grain starts at $2 per crop at age 0
        this.setAge(0);
        this.setDiseased(false);
        this.setType("grain");
        this.setName(name);
        this.state = null;
    }

    
    
    
   
}
