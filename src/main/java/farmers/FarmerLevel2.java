package main.java.farmers;

public class FarmerLevel2 extends FarmerDecorator{

    public FarmerLevel2(Farmer farmer) {
        super(farmer);
        this.setName("level 2");
        this.setLvl(2);
        this.setFarm(farmer.getFarm());
        this.getFarm().setAnimalArr(this.getFarm().getAnimalArr());
        this.getFarm().setCropsArr(this.getFarm().getCropsArr());
        this.setAffinity(2);
        this.setMoney(farmer.getMoney());
    }
    
    

}
