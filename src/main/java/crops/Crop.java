package main.java.crops;

public abstract class Crop {
    private String name;
    private int price;// how much this crop is worth(to sell)
    private String type;// ID for the type of crop we are dealing with
    private int age;// how long a crop has been in existence
    private boolean diseased;// lets us know if a crop is diseased or not
    private int diseaseDayCount;// keeps track of how long a crop has been diseased
    private boolean isDead; // lets us know if this crop is dead or alive

    CropState state;
    CropState sellState;

    public CropState getSellState() {
        return sellState;
    }

    public void setSellState(CropState sellState) {
        this.sellState = sellState;
    }

    public Crop() {
        state = new HealthyState();
        sellState = new NotReadyToSellState();
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


}
