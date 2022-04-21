package main.java.farms;

import java.util.ArrayList;
import java.util.LinkedList;

import main.java.animals.Animal;
import main.java.crops.Crop;
import main.java.farmers.Farmer;

public abstract class Farm {
    private static final int MAX_CROPS = 30;
    private static final int MAX_Animals = 30;
    private String name;
    private int money;  
    private ArrayList<Crop> cropsArr = new ArrayList<Crop>(10);
    private int price = 250;
    private ArrayList<Animal> animalArr = new ArrayList<Animal>(10);
    private int lvl = 1;




    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getMoney() {
        return money;
    }
    
    public void setMoney(int money) {
        this.money = money;
    }
    
    public int getPrice() {
        return price;
    }
    
    public void setPrice(int price) {
        this.price = price;
    }
    
    public int getMax_Crops() {
        return MAX_CROPS;
    }
    
    public int getMax_Animals() {
        return MAX_Animals;
    }
    
    public ArrayList<Crop> getCropsArr() {
        return cropsArr;
    }
    
    public void setCropsArr(ArrayList<Crop> cropsArr) {
        this.cropsArr = cropsArr;
    }
    
    public ArrayList<Animal> getAnimalArr() {
        return animalArr;
    }
    
    public void setAnimalArr(ArrayList<Animal> animalArr) {
        this.animalArr = animalArr;
    }
    
    public int getLvl() {
        return lvl;
    }
    
    public void setLvl(int lvl) {
        this.lvl = lvl;
    }



}
