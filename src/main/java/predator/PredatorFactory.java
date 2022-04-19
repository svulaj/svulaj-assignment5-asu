package main.java.predator;

public class PredatorFactory {
    private int numOfFoxes = 0;
    private int numOfMoles = 0;
    
    public Predator makeNewPredator(int choice, String name) {
        if(choice == 1) {
            return new Fox(name);
        }else if(choice == 2) {
            return new Mole(name);
        }else {
            return null;
        }
    }

    public int getNumOfFoxes() {
        return numOfFoxes;
    }

    public void setNumOfFoxes(int numOfFoxes) {
        this.numOfFoxes = numOfFoxes;
    }

    public int getNumOfMoles() {
        return numOfMoles;
    }

    public void setNumOfMoles(int numOfMoles) {
        this.numOfMoles = numOfMoles;
    }
    public String nameGenFox() {
        String newNameString = "Fox ".concat(Integer.toString(numOfFoxes));
        numOfFoxes++;
        return newNameString;
    }
    public String nameGenMole() {
        String newNameString = "Mole ".concat(Integer.toString(numOfMoles));
        numOfMoles++;
        return newNameString;
    }
    
    
}
