# SER316 Farm Simulator
By: Shaun Vulaj


Activity 1:
## Design Patterns:
Factory: Plan on using this for the animals since they will mainly have the same functionality(for the most part at least). Health, harvest(pigs = truffles or bacon, cows = milk, chickens = eggs) same with the crops.

Decorator: I think the decorator will be good to handle the abilities that are available to the farmer when upgrades occur. For instance when a farm recieves a cheese maker ability from the farm getting the upgrade (i just made this up, a barn) where now they can have cows, they will also be able to milk and then make the cheese. So this fuctionality will need to be added to the currently existing farm.

Builder - I think this pattern will aid in the ability to add on to farms. As upgrades come in the farmers farm will need to be upgraded and i believe this pattern will aid in the addition process.


Activity 2:

NOTE: Places where DP is used will be marked with (DP: ___).

DESIGN PATTERNS USED: DECORATOR, STATE, FACTORY.


ScreenCast:

DP Explanations:

	Factory:
		Requirements met:
				- Animals have a chance to be born every 4 cycles (must have at least 2 for the chance to occur). Alternatively, as an example, you could specify in your simulation that you wish to spend a certain percentage of your total currency every X number of cycles to buy more animals.

				- Animals have a natural life cycle just like in real life. They start as a baby where they cannot produce anything for the first 3 days (but may still be killed by predators and disease), and then after that they may produce until they die.

				- Animals and crops cost currency to purchase. If your farm purchases animals or crops in bulk then they may be bought at a discount depending on the quantity.

		Req. Explanation: 
				I chose to fulfil these requirements with the factory design pattern because all of these req.'s needed a way to generate objects that could be used within the SIM. For the first one a factory would be needed to generate a animal once an animal could be born. This generally goes for all of the Sims objects that play a role in the flow of the SIM.

				Second, i used the factory for the second req because a animal wouold need to be created for the life cycle of any given animal.

				Third, All of the animals, crops, farmers, predators, and farms all needed a factory to easily create all of the characters. With this being in place buying and selling crops was made easy because a factory could be easily used to afford that  functionality.

		Dev note for DP: Factory.
				I mainly used this feature in methods and slightly in main. A lot of the factorys had the ability to make multiple different kinds of object of the same type but in my program i only ever really created one object(E.g. Animals: cow, Crop: grass, Farm: CropFarm, Farmer: AnimalFarmer). This was just to keep the game simple but still allow for the ability to scale to a more complex program if needed. 


	Decorator:
		Requirements met:
				- Farms are automatically upgraded once the farm has acquired enough currency. This could mean that the farm is expanded to grant it more land, which allows it to hold a greater numbers of farmers, animals and crops. The upgrade may also increase the passive currency income. In order for the simulation to not run into issues, it might be a nice idea to make sure the farm only upgrades once your farm has acquired 20% (choose any % you like though) more than the cost of an upgrade. So, if an upgrade costs $1000, it will automatically upgrade at $1200 so the farm still has $200.

				- Farmers can have affinities for things such as (these are some examples to give you ideas):
					– Being better at growing crops

				- Similar to farmers, animals have affinities too (these are some examples to give you ideas):
					– A cow may be larger than usual and produce more milk

		Req. Explanation:
				First, Farms get automatically upgraded to level 2 if a player is a level 2 farmer and has a $1000. Upgrading a farm was made easy with the decorator DP.

				Second, upgrading a farmer to a level 2 farmer was made easy with the decorator DP. This DP can be seen in the main when a player is not already upgraded and if the farmer currently has $1000. You can also see that if a farmer was level 2 that they would then be able to purchase a level 2 farm and if a level 2 farm was achieved that animals could then be purchased.

				Third, You can see in the sellAnimals() that if a animal was level 2 that they're product would be worth $120 more. 

		Dev note for DP: Decorator.
				Where you can see the DP the most is in main when a farm upgrade occurs. 
				Also, in main when you see a farmer get upgraded.
				Also, in main when animals get upgraded due having a level 2 farmer 	  and farm.


				The decorator was used mainly for upgrading any character/object 
				(E.g Farms, Farmers, Animals).



	State: 
		Requirements met:

				- Animal product (milk, wool, and so on) is replenished after every 2nd day. For example, if a sheep is sheared for its wool then the farmers must wait 2 cycles (day and night) to collect the wool again.

				- Animals live for 14 days unless killed by a predator or they become diseased. If killed by a predator they disappear in that same night, if they become diseased they have a chance to die in the next cycle (day and night), unless treated by a farmer. Animal affinities may help with fighting the disease.

				- Crops are grown on farms and have a chance to become diseased. When this happens they have a chance to wither and die within the next cycle (day and night), unless treated by a farmer. Crop affinities may help with fighting the disease.


		Req. Explanation:

				First, This DP was used for signaling when a animal had product that was ready to be sold or not sold, can be seen in ageAnimals().

				Second, Animals had a 'State' field indicating whether or not they are dead or alive. This state was at risk to be one or the other whenever a predetor attack took place. Can bee seen in main. If they were attacked by a predator their state would be changed to dead, can be seen in predatorAttack().

				Third, Crops had a 'State' field that was a state that governed the health state of that crop. Crops had a percentage chance of becoming diseased, can be seen in ageCrops().


		Dev note for DP: State.
				You can see mutltiple state classes made and be used throughout the program in many different methods. Most of the methods that alter states can be found in the Farmer class.



All Reqs met:
	• A new world must start with at least 1 farm.

	• Farms can be of different types, such as an animal farm, a crop farm, a 		  hybrid farm and so on. You can choose to make something up too.

	• The simulation should run on cycles. A cycle is considered to be of 2 parts - 1 day time and 1 night time.

	• Passive currency is earned with each new day (not night). This passive currency income is generated from selling crops or animal products, or both depending on your farm.

	• More currency can be made from farmer, animal or crop affinities (examples below).

	• Farms are automatically upgraded once the farm has acquired enough currency. This could mean that the farm is expanded to grant it more land, which allows it to hold a greater numbers of farmers, animals and crops. The upgrade may also increase the passive currency income. In order for the simulation to not run into issues, it might be a nice idea to make sure the farm only upgrades once your farm has acquired 20% (choose any % you like though) more than the cost of an upgrade. So, if an upgrade costs $1000, it will automatically upgrade at $1200 so the farm still has $200.


	• Farmers can have affinities for things such as (these are some examples to give you ideas):
		– Being better at growing crops

	• Animals reside on farms; it is up to you to decide the total number of animals that your farm(s) will hold. Think of typical farm animals such a cows and pigs, but you can be creative if you wish.

	• Animal product (milk, wool, and so on) is replenished after every 2nd day. For example, if a sheep is sheared for its wool then the farmers must wait 2 cycles (day and night) to collect the wool again.

	• Similar to farmers, animals have affinities too (these are some examples to give you ideas):
		 – A cow may be larger than usual and produce more milk

	• During night cycles predators come out.

	• Animals have a chance to be born every 4 cycles (must have at least 2 for the chance to occur). Alternatively, as an example, you could specify in your simulation that you wish to spend a certain percentage of your total currency every X number of cycles to buy more animals.

	• Animals live for 14 days unless killed by a predator or they become diseased. If killed by a predator they disappear in that same night, if they become diseased they have a chance to die in the next cycle (day and night), unless treated by a farmer. Animal affinities may help with fighting the disease.

	• Animals have a natural life cycle just like in real life. They start as a baby where they cannot produce anything for the first 3 days (but may still be killed by predators and disease), and then after that they may produce until they die.

	• Crops are grown on farms and have a chance to become diseased. When this happens they have a chance to wither and die within the next cycle (day and night), unless treated by a farmer. Crop affinities may help with fighting the disease.


	• Crops may be harvested 1 time every 3 cycles.

	• The farmers on your farm are quite tech savvy, so when animals or crops die (or harvested), an automatic message is sent to their supplier notifying them that they need more stock.


	• Animals and crops cost currency to purchase. If your farm purchases animals or crops in bulk then they may be bought at a discount depending on the quantity.














