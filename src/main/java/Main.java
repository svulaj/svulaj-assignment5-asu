package main.java;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;

import main.java.animals.Animal;
import main.java.animals.AnimalFactory;
import main.java.animals.AnimalLevel2;
import main.java.animals.Pig;
import main.java.crops.AliveCropState;
import main.java.crops.Crop;
import main.java.crops.CropFactory;
import main.java.crops.CropState;
import main.java.crops.DeadCropState;
import main.java.crops.DiseasedCropState;
import main.java.crops.Grain;
import main.java.crops.Grass;
import main.java.crops.ReadyToSellState;
import main.java.farmers.CropFarmer;
import main.java.farmers.Farmer;
import main.java.farmers.FarmerFactory;
import main.java.farmers.FarmerLevel2;
import main.java.farms.CropFarm;
import main.java.farms.Farm;
import main.java.farms.FarmFactory;
import main.java.farms.FarmLevel2;
import main.java.predator.Predator;
import main.java.predator.PredatorFactory;

public class Main {
    
    public static boolean day = true;
    public static final int endOfGame = 30;
    public static int daysPassed = 0;
    public static final int maxCrops = 10;
    public static boolean isUpgraded = false;
    
//      TimeUnit timeUnit
    public static boolean gameIsRunning = true;
//    TimeUnit.SECONDS.sleep(1);

    // Used to be able to give unique names for all of the animals

    /**
     * Description: the main system of the bear store.
     * 
     * @param args Is what the customer could potentially input in the future.
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        // Factories built ahead of time for future use
        FarmFactory farmFactory = new FarmFactory();
        FarmerFactory farmerFactory = new FarmerFactory();
        PredatorFactory predatorFactory = new PredatorFactory();
        CropFactory cropFactory = new CropFactory();
        AnimalFactory factory = new AnimalFactory();

//        do {
            System.out.println("WELCOME TO FARM SIM 2022");
//            TimeUnit.SECONDS.sleep(2);
            System.out.println("The Mystical Spirit: \"I have placed you on a beatiful planet kind person.\" ");
//            TimeUnit.SECONDS.sleep(2);
            System.out.println("The Mystical Spirit: \"The catch is tho, you must farm for your survival!!\" ");
//            TimeUnit.SECONDS.sleep(2);
            System.out.println("The Mystical Spirit: \"You will start with a crop farm.\" ");
//            TimeUnit.SECONDS.sleep(2);
            System.out.println("The Mystical Spirit: \"I will sell you livestock or more crops to grow.\" ");
//            TimeUnit.SECONDS.sleep(2);
            System.out.println(
                    "The Mystical Spirit: \"Reach $10,000 and i will release you from this infinite hell..... Heres the menu!\"\n ");
//            TimeUnit.SECONDS.sleep(2);
            System.out.println("Menu: ");
//            TimeUnit.SECONDS.sleep(2);
            System.out.println("Crops to buy: Grain = $50, Hay = $40, and Grass = $30 ");
//            TimeUnit.SECONDS.sleep(2);
            System.out.println("Animals to buy: Cow = $15, Goat = $10, and Pig = $5 ");
//            TimeUnit.SECONDS.sleep(2);
            System.out.println("Farms to buy: Farm level 2 = $200, base farm = $100 ");
//          TimeUnit.SECONDS.sleep(2);
            System.out.println(
                    "The Mystical Spirit: \"You will start with $500, Good Luck! Oh yea... and ..... beware of the predators......\" ");
//          TimeUnit.SECONDS.sleep(2);

            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            
//-------------------------------------------------------------------------------
//BEGINNING SETUP
            Farmer player = farmerFactory.makeNewFarmer(1, "Level 1");
            Farm baseFarm = farmFactory.makeNewFarm(1, farmFactory.nameGenCropFarm());
            System.out.println("You will start with $500");
            player.setMoney(500);
            
            player.setFarm(baseFarm);
            System.out.println("farm cost = " + baseFarm.getPrice());
            player.setMoney(player.getMoney()-baseFarm.getPrice());
            System.out.println("players money after purchasing a crop farm: " + player.getMoney() + "\n");
            System.out.println("--->crop farm size: " + player.getFarm().getCropsArr().size() + "\n");
            
            //player.buyCrop();
            System.out.println("player has $" + player.getMoney() + " left!");

//============================================================================================================
//BEGINNING OF THE GAME
            do {
                if(day == true) {
                    System.out.println("\n==========================================================================================================================");
                    System.out.println("===========Days passed:" + daysPassed + "=======================");
                    System.out.println("===============================================");
                    
//---------------------------------------------------------------------------------------------------------------------
// UPGRADE SECTION --- Morning section
                    System.out.println("\n----------------------------");
                    System.out.println("------------------------------");
                    System.out.println("EARLY MORNING: UPGRADING TIME");
                    System.out.println("------------------------------");
                    System.out.println("----------------------------");
                    
                    
                          //can we purchase new crops?
                          if(player.getFarm().getCropsArr().size() < 10 && player.getMoney() > 30) {
                              System.out.println("\nAt the market you begin to try to purchase crops:");
                              player.buyCrop();
                              System.out.println("----------------------------------------");
                              //System.out.println("purchase crops check");
                          }else {
                              System.out.println("not enough money or room to buy more crops");
                          }
                          
                          //purchase animals condition
                          if(player.getMoney() > 30 && player.getFarm().getAnimalArr().size() < 11 && player.getFarm().getLvl() == 2) {
                              System.out.println("At the market you begin to try to purchase animals: \n");
                              player.buyAnimals();
                          }else {
                              if(player.getLvl() == 1) {
                                  System.out.println("you do not have a level 2 farm yet. So you cannot purchase any animals");
                              }
                          }
                          //System.out.println("player has $" + player.getMoney() + " left!");
                    
//---------------------------------------------------------------------------------------------------------------------
// SELLING SECTION ---- Day time section
                    System.out.println("\n----------------------------");
                    System.out.println("------------------------------");
                    System.out.println("DAY TIME: PROFIT TAKING TIME");
                    System.out.println("------------------------------");
                    System.out.println("----------------------------\n");
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                    //if player has enough money the farmer will upgrade
                    if(player.getMoney() > 1000 && isUpgraded == false) {
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        System.out.println("You have made a deal with a shady character for $1000.");
                        player = new FarmerLevel2(player);
                        isUpgraded = true;
                        int cost = player.getMoney()-1000;
                        System.out.println("after purchase players money is: " + cost);
                        player.setMoney(cost);
                        System.out.println("*****YOU ARE NOW A LVL 2 FARMER & HAVE AQCUIRED THE ABILITY TO BUY ANIMALS!!******");
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    }
                    
                    if(player.getMoney() > 1000 && player.getLvl() == 2) {
                        System.out.println("Level 2 farm acquired");
                        player.setFarm(baseFarm = new FarmLevel2(baseFarm));
                        player.setMoney(player.getMoney()-1000);
                        if(player.getLvl() == 2) {
                            upgradeAnimals(player);
                            System.out.println("animals have been upgraded");
                        }else {
                            System.out.println("you are not level 2 yet so you cannot upgrade your animals");
                        }
                    }else {
                        System.out.println("not enough money to upgrade farm");
                    }
                    
                    
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  
                    System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    System.out.println("--->Farmer goes to the market to sell what stuff he can:");
                    player.sellCrops();
                    if(player.getFarm().getAnimalArr().size() != 0) {
                        player.sellanimalProduct();
                    }
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//--------------------------------------------------------------------------------------------------------------------- 
                    
                    // set to go to night time
                    day = false;
                }
                
                if(day == false) {
                    System.out.println("\n---------------------------------");
                    System.out.println("NIGHT TIME: THE PREDATORS COME OUT");
                    System.out.println("-----------------------------------\n");
                    System.out.println("...............................................................................");
                    System.out.println("Animal attack commence: ");
                    player.predatorAttack();
                    System.out.println("...............................................................................");
                    System.out.println("animals left after attack:");
                    player.findDeadAnimals();
                    System.out.println("...............................................................................");
                    
                    daysPassed++;
                    player.ageAnimals();
                    player.ageCrops();
                    //set to go to daytime
                    day = true;
                    player.cropListToString();
                    if(player.getMoney() == 6000) {
                        daysPassed = endOfGame;
                    }
                    System.out.println("--------> END OF DAY");
                }
                
                
                
            }while(daysPassed != endOfGame);

            
         

           System.out.println("FIN.");
   }


//=================================================================================
//UTILITIES
    
    /**
     * Description: Levels up the farm to level 2. 
     *              This allows crops to grow twice as fast.
     * @param farmer: the farmer you wish to upgrade
     */
    public static void upgradeAnimals(Farmer farmer) {
        for(Animal d : farmer.getFarm().getAnimalArr()) {
            //System.out.println("d age: " + d.getAge() + " d affinity: " + d.getAffinity());
            if(d.getAge() >= 7 && d.getAffinity() != 2) {
                d = new AnimalLevel2(d);
                //System.out.println("d affinity is now: " + d.getAffinity());
            }
        }
    }
    
    
    
    
}












////=================================================================
////FACTORY EXAMPLE
//Farm baseFarm = farmFactory.makeNewFarm(1, farmFactory.nameGenAnimalFarm());
//Farmer baseFarmer = farmerFactory.makeNewFarmer(1, null);
////=================================================================
//
//
//
//
////=================================================================
////STATE EXAMPLE
//Grain grain1 = new Grain("grain");    
//
//AliveCropState aliveState = new AliveCropState();
//DiseasedCropState diseasedState = new DiseasedCropState();
//DeadCropState deadCropState = new DeadCropState(); 
//
//aliveState.doAction(grain1);
//System.out.println(grain1.getState().toString());
//
//diseasedState.doAction(grain1);
//System.out.println(grain1.getState().toString());
//
//deadCropState.doAction(grain1);
//System.out.println(grain1.getState().toString());
////=================================================================
//
////=================================================================
////DECORATOR EXAMPLE
//baseFarm = new FarmLevel2(baseFarm);
//System.out.println("result: " +  baseFarm.getMoney());
//
//
