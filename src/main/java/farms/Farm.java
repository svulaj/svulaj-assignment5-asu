package main.java.farms;

import java.util.LinkedList;

import main.java.animals.Animal;
import main.java.farmers.Farmer;

public abstract class Farm {
private String name;
private int money;  // how much money a farm has to hire new farmers, buy more crops, buy new animals
private LinkedList<Farmer> farmers = new LinkedList<Farmer>();




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
public LinkedList<Farmer> getFarmers() {
    return farmers;
}
public void setFarmers(LinkedList<Farmer> farmers) {
    this.farmers = farmers;
}


}
