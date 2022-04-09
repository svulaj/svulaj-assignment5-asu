package main.java;

public abstract class Farmer {

    //Types: crop = crop affinities, breeder=animal affinities
    private String name;
    private String type;
    private int affinity; // Affinity = 0 = animals grow faster. || Affinity = 1 = crops grow faster.
    //private int money;    // How much money a farmer has to 
    
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public int getAffinity() {
        return affinity;
    }
    public void setAffinity(int affinity) {
        this.affinity = affinity;
    }
//    public int getMoney() {
//        return money;
//    }
//    public void setMoney(int money) {
//        this.money = money;
//    }
    
    
}
