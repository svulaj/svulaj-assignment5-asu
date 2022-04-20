package main.java.animals;

public abstract class Animal {
    private static final int maxAge = 14;
    private String name;// Name of the animal
    private int stomach;// how much the animal will eat
    private int size;// The size of the animal(will be used for growth)
    private int age;// The age of the animal
    private String type;// ID for the animals type
    private int strength;// strength lvl of the animal to fend off predators
    private int price;// how much the animal can be sold for
    private boolean yield; // if true this animal has
    private int yieldCount;
    private int affinity; // Each animal has an affinity that aids its yield output

    AnimalState state; // done
    AnimalState product; // done
    AnimalState pregnant; // done
    // ===========================================================

    public AnimalState getState() {
        return state;
    }

    public AnimalState getPregnantState() {
        return pregnant;
    }

    public void setPregnantState(AnimalState pregnant) {
        this.pregnant = pregnant;
    }

    public void setState(AnimalState state) {
        this.state = state;
    }

    public AnimalState getProductState() {
        return product;
    }

    public void setProductState(AnimalState product) {
        this.product = product;
    }

    // ===========================================================
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

    public boolean isYield() {
        return yield;
    }

    public void setYield(boolean yield) {
        this.yield = yield;
    }

    public int getYieldCount() {
        return yieldCount;
    }

    public void setYieldCount(int yieldCount) {
        this.yieldCount = yieldCount;
    }

    public int getAffinity() {
        return affinity;
    }

    public void setAffinity(int affinityMultiplier) {
        this.affinity = affinityMultiplier;
    }
    // ===========================================================

}
