package main.java.farms;

import java.util.LinkedList;

import main.java.crops.Crop;

public class CropFarm extends Farm{
    
    private LinkedList<Crop> crops = new LinkedList<Crop>();

    public LinkedList<Crop> getCrops() {
        return crops;
    }

    public void setCrops(LinkedList<Crop> crops) {
        this.crops = crops;
    }

    public CropFarm(String name) {
        this.setName(name);
    }
}
