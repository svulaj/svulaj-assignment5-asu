package main.java.crops;

public abstract class Crop {
    private String name;
    //private int growthRate;//how fast it grows
    private int price;// how much this crop is worth(to sell)
    private String type;// ID for the type of crop we are dealing with
    //private int yield;// <<------- idk know just yet
    private int age;// how long a crop has been in existence
    private boolean diseased;// lets us know if a crop is diseased or not
    private int diseaseDayCount;// keeps track of how long a crop has been diseased
    private boolean isDead; // lets us know if this crop is dead or alive
    
    CropState state;
    
    public Crop() {
        state = new HealthyState();
    }
    
    
    public String getState() {
        return state.toString();
    }
    public void setState(CropState state) {
        this.state = state;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
//    public int getGrowthRate() {
//        return growthRate;
//    }
//    public void setGrowthRate(int growthRate) {
//        this.growthRate = growthRate;
//    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
//    public int getYield() {
//        return yield;
//    }
//    public void setYield(int yield) {
//        this.yield = yield;
//    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public boolean getDiseased() {
        return diseased;
    }
    public void setDiseased(boolean diseased) {
        this.diseased = diseased;
    }
    public boolean getIsDead() {
        return isDead;
    }
    public void setDead(boolean isDead) {
        this.isDead = isDead;
    }
    public int getDiseaseDayCount() {
        return diseaseDayCount;
    }
    public void setDiseaseDayCount(int diseaseDayCount) {
        this.diseaseDayCount = diseaseDayCount;
    }
    
    //Used to check if a crop is diseased
    public boolean isDiseased() {
        if(this.getDiseased() == true) {
            return true;
        }else {
            return false;
        }
    }
    //Used to check if a crop is alive
    public boolean isAlive() {
        if(this.getIsDead() == false) {
            return true;
        }else {
            return false;
        }
    }
    
}
