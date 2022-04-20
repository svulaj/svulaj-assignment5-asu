package main.java.crops;

public class Grass extends Crop { 

    /**
    * Description: Constructor.
    * @param name The name of the crop.
    */
    public Grass(String name) {
        this.setName(name);
        this.setPrice(30);
        this.setAge(0);
        this.setDiseased(false);
        this.setType("grain");
    }
}
