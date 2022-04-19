package main.java.predator;

import org.junit.validator.PublicClassValidator;

import main.java.animals.Animal;

public class Fox extends Predator{

      public Fox(String name) {
          this.setName(name);
          this.setStrength(6);
      }
      
      public void killAnimal(Animal x) {
          x = null;
      }
}
