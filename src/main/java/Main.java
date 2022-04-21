package main.java;

import main.java.animals.Animal;
import main.java.animals.AnimalFactory;
import main.java.animals.AnimalLevel2;
import main.java.crops.CropFactory;
import main.java.farmers.Farmer;
import main.java.farmers.FarmerFactory;
import main.java.farmers.FarmerLevel2;
import main.java.farms.Farm;
import main.java.farms.FarmFactory;
import main.java.farms.FarmLevel2;
import main.java.predator.PredatorFactory;

public class Main {

    /**
     * Description: Main method for Famer Simulation.
     * 
     * @param args command in take.
     * @throws InterruptedException covers this exception.
     */
    public static void main(String[] args) throws InterruptedException {
        boolean day = true;
        final int endOfGame = 30;
        //int daysPassed = 0;
        int maxCrops = 10;
        boolean isUpgraded = false;
        boolean gameIsRunning = true;
        
        // Factories built ahead of time for future use
        FarmFactory farmFactory = new FarmFactory();
        FarmerFactory farmerFactory = new FarmerFactory();
        //-------------------------------------------------------------------------------
        // BEGINNING SETUP
        Farmer player = farmerFactory.makeNewFarmer(1, "Level 1");
        Farm baseFarm = farmFactory.makeNewFarm(1, farmFactory.nameGenCropFarm());
        System.out.println("You will start with $500");
        player.setMoney(500);
        player.setFarm(baseFarm);
        System.out.println("farm cost = " + baseFarm.getPrice());
        player.setMoney(player.getMoney() - baseFarm.getPrice());
        System.out.println("players money after purchasing a farm: " + player.getMoney() + "\n");
        System.out.println("--->crop farm size: " + player.getFarm().getCropsArr().size() + "\n");
        // player.buyCrop();
        System.out.println("player has $" + player.getMoney() + " left!");
        //===========================================================================
        // BEGINNING OF THE GAME
        int daysPassed = 0;
        do {
            if (day == true) {
                System.out.println(
                        "\n===========================================");
                System.out.println("==========Days passed:" + daysPassed + "==========");
                System.out.println("==========================");
                //------------------------------------------------------
                // UPGRADE SECTION --- Morning section
                System.out.println("\n----------------------------");
                System.out.println("------------------------------");
                System.out.println("EARLY MORNING: UPGRADING TIME");
                System.out.println("------------------------------");
                System.out.println("----------------------------");
                // can we purchase new crops?
                if (player.getFarm().getCropsArr().size() < 10 && player.getMoney() > 30) {
                    System.out.println("\nAt the market you begin to try to purchase crops:");
                    player.buyCrop();
                    System.out.println("----------------------------------------");
                    // System.out.println("purchase crops check");
                } else {
                    System.out.println("not enough money or room to buy more crops");
                }
                // purchase animals condition
                if (player.getMoney() > 30 && player.getFarm().getAnimalArr().size() < 11
                        && player.getFarm().getLvl() == 2) {
                    System.out.println("At the market you begin to try to purchase animals: \n");
                    player.buyAnimals();
                } else {
                    if (player.getLvl() == 1) {
                        System.out.println("No level 2 farm yet. Cannot purchase any animals");
                    }
                }
                // System.out.println("player has $" + player.getMoney() + " left!");
                //--------------------------------------------------
                // SELLING SECTION ---- Day time section
                System.out.println("\n----------------------------");
                System.out.println("------------------------------");
                System.out.println("DAY TIME: PROFIT TAKING TIME");
                System.out.println("------------------------------");
                System.out.println("----------------------------\n");
                //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                // if player has enough money the farmer will upgrade
                if (player.getMoney() > 1000 && isUpgraded == false) {
                    System.out.println(
                            "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    System.out.println("You have made a deal with a shady character for $1000.");
                    //DP: Decorator.
                    player = new FarmerLevel2(player);
                    isUpgraded = true;
                    int cost = player.getMoney() - 1000;
                    System.out.println("after purchase players money is: " + cost);
                    player.setMoney(cost);
                    System.out.println(
                            "*****Now lvl 2: AQCUIRED THE ABILITY TO BUY ANIMALS!!******");
                    System.out.println(
                            "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                }
                if (player.getMoney() > 1000 && player.getLvl() == 2) {
                    System.out.println("Level 2 farm acquired");
                    //DP: Decorator.
                    player.setFarm(baseFarm = new FarmLevel2(baseFarm));
                    player.setMoney(player.getMoney() - 1000);
                    if (player.getLvl() == 2) {
                        //DP: Decorator.
                        upgradeAnimals(player);
                        System.out.println("animals have been upgraded");
                    } else {
                        System.out.println("not level 2: cannot upgrade your animals");
                    }
                } else {
                    System.out.println("not enough money to upgrade farm");
                }
                //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  
                System.out
                        .println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("--->Farmer goes to the market to sell what stuff he can:");
                player.sellCrops();
                if (player.getFarm().getAnimalArr().size() != 0) {
                    player.sellanimalProduct();
                }
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                //----------------------------------------------------------- 
                // set to go to night time
                day = false;
            }
            if (day == false) {
                System.out.println("\n---------------------------------");
                System.out.println("NIGHT TIME: THE PREDATORS COME OUT");
                System.out.println("-----------------------------------\n");
                System.out.println(".........................................");
                System.out.println("Animal attack commence: ");
                player.predatorAttack();
                System.out.println(".......................................");
                System.out.println("animals left after attack:");
                player.findDeadAnimals();
                System.out.println("..............................");

                daysPassed++;
                player.ageAnimals();
                player.ageCrops();
                // set to go to daytime
                day = true;
                player.cropListToString();
                if (player.getMoney() == 6000) {
                    daysPassed = endOfGame;
                }
                System.out.println("--------> END OF DAY");
            }

        } while (daysPassed != endOfGame);

        System.out.println("FIN.");
    }

    //===========================================
    //UTILITIES

    /**
     * Description: Levels up the farm to level 2. This allows crops to grow twice
     * as fast.
     */
    public static void upgradeAnimals(Farmer farmer) {
        for (Animal d : farmer.getFarm().getAnimalArr()) {
            // System.out.println("d age: " + d.getAge() + " d affinity: " +
            // d.getAffinity());
            if (d.getAge() >= 7 && d.getAffinity() != 2) {
                d = new AnimalLevel2(d);
                System.out.println("d affinity is now: " + d.getAffinity());
            }
        }
    }

}