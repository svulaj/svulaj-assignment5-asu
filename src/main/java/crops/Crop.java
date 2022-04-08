package main.java.crops;

public abstract class Crop {
    private String name;
    private int growthRate;
    private int price;
    private String type;
    
    
    
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getGrowthRate() {
        return growthRate;
    }
    public void setGrowthRate(int growthRate) {
        this.growthRate = growthRate;
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
    
}
