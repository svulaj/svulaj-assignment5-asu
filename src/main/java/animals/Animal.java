package main.java.animals;

public abstract class Animal {
    private final int maxAge = 14;
    private String name;// Name of the animal
    private int stomach;// How much food they have accumulated
    private int size;// The size of the animal(will be used for growth)
    private int age;// The age of the animal
    private String type;
    private int strength;
    private int price;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getStomach() {
        return stomach;
    }
    public void setStomach(int stomach) {
        this.stomach = stomach;
    }
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void grow() {
        this.size++;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public int getStrength() {
        return strength;
    }
    public void setStrength(int strength) {
        this.strength = strength;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public int getMaxAge() {
        return maxAge;
    }
    public abstract int graze();
    
    
    
}
