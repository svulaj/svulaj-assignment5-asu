package main.java;

public class Farm {
private String name;
private int animals;
    
    public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public int getAnimals() {
    return animals;
}

public void setAnimals(int animals) {
    this.animals = animals;
}

    public Farm(String intendedName) {
        this.name = intendedName;
    }
}
