package main.java.crops;

public class Hay extends Crop { 
    
    /**
     * Description: Constructor.
     * @param name The name of the crop.
     */
    public Hay(String name) {
        this.setName(name);
        this.setPrice(40);
        this.setAge(0);
        this.setDiseased(false);
        this.setType("grain");
    }

}
