package main.java.farms;

import java.util.ArrayList;

import main.java.animals.Animal;
import main.java.animals.Cow;
import main.java.crops.Crop;
import main.java.farmers.Farmer;

public class FarmLevel2 extends FarmDecorator {

    private ArrayList<Animal> animalArr = new ArrayList<Animal>(10);

    /**
     * Description: Constructor.
     * @param baseFarm Farm to upgrade.
     */
    public FarmLevel2(Farm baseFarm) {
        super(baseFarm);
        this.setName("Level 2");
        this.setLvl(2);
        // TODO Auto-generated constructor stub
    }

    @Override
    public int getMoney() {
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     * Description: Lets us know how many animals we have.
     * @return Returns the size of the list.
     */
    public int sizeOfArr() {
        return animalArr.size();
    }

}
