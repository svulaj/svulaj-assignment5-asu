package main.java.farms;



public class CropFarm extends Farm{
    
    private final int price = 250;
    private final int MAX_CROPS = 30;//Maximum number of animals allowed on an animal farm
   
    

    public CropFarm(String name) {
        this.setName(name);
        //this.setPrice(100);
    }
    

    
    public int getCost() {
        // TODO Auto-generated method stub
        return 0;
    }
}
