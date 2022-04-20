package main.java.predator;

public class PredatorFactory {
    private int numOfFoxes = 0;
    private int numOfMoles = 0;

    /**
     * Description: Constructor.
     * @param name Name of predator.
     */
    public Predator makeNewPredator(int choice, String name) {
        if (choice == 1) {
            return new Fox(name);
        } else if (choice == 2) {
            return new Mole(name);
        } else {
            return null;
        }
    }

    /**
     * Description: gets number of foxes.
     * @return Number of foxes.
     */
    public int getNumOfFoxes() {
        return numOfFoxes;
    }

    /**
     * Description: sets number of foxes.
     */
    public void setNumOfFoxes(int numOfFoxes) {
        this.numOfFoxes = numOfFoxes;
    }
    
    /**
     * Description: gets number of moles.
     * @return Number of moles.
     */
    public int getNumOfMoles() {
        return numOfMoles;
    }

    /**
     * Description: sets number of moles.
     */
    public void setNumOfMoles(int numOfMoles) {
        this.numOfMoles = numOfMoles;
    }

    /**
     * Description: Generates random name for fox.
     * @return name for fox
     */
    public String nameGenFox() {
        String newNameString = "Fox ".concat(Integer.toString(numOfFoxes));
        numOfFoxes++;
        return newNameString;
    }

    /**
     * Description: Generates random name for mole.
     * @return name for mole
     */
    public String nameGenMole() {
        String newNameString = "Mole ".concat(Integer.toString(numOfMoles));
        numOfMoles++;
        return newNameString;
    }

}
