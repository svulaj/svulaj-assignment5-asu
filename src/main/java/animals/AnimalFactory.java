package main.java.animals;

public class AnimalFactory {
    //Used to be able to give unique names for all of the animals
    int numOfCowsForNames;
    int numOfPigsForNames;
    int numOfGoatsForNames;
    
    public Animal makeNewAnimal(int choice, String name) {
        if(choice == 1) {
            return new Cow(name);
        }else if(choice == 2) {
            return new Pig(name);
        }else if(choice == 3) {
            return new Goat(name);
        }else {
            return null;
        }
    }
    
    public String nameGenCow() {
        String newNameString = "Cow ".concat(Integer.toString(numOfCowsForNames));
        numOfCowsForNames++;
        return newNameString;
    }
    public String nameGenPig() {
        String newNameString = "Pig ".concat(Integer.toString(numOfPigsForNames));
        numOfPigsForNames++;
        return newNameString;
    }
    public String nameGenGoat() {
        String newNameString = "Goat ".concat(Integer.toString(numOfGoatsForNames));
        numOfGoatsForNames++;
        return newNameString;
    }

    
}
