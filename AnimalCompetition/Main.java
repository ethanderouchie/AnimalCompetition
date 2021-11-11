import java.util.*;

class Main {
  public static void main(String[] args) {   
    Scanner scanner = new Scanner (System.in);
    Random random = new Random();
    //how many animals can be played in the game
    int numberOfAnimals = 2;
    // What animal each player has selected (dog, lion, bear, etc)
    int fighter1 = -1;
    int fighter2 = -1;
    int trueOrFalse = -1;
    //The sword that each animal has equipped (wood, iron, steel)
    int sword1 = -1;
    int sword2 = -1;
    //The armour that each animal has on (hide, steel, daedric)
    int armour1 = -1;
    int armour2 = -1;
     //These act as a safeguard so that if the purchase is unable to take place for whatever reason, it does not affect the game
    int buyAnimal = -1;
    int buyArmour = -1;
    int buySword = -1;
    //Counts how many items are in a shop
    int counter = 1;
    //Which animal is currently attacking
    int currentAttacker = -1;
    //How much health each animal has 
    int healthPointsP1 = -1;
    int healthPointsP2 = -1;
    //How much money each player has 
    int player1money = 250;
    int player2money = 250;
    //Checks if the player is playing with 
    int humanOrAI = -1;
    boolean isFacingHuman = false;
    //counts how many animals, weapons, and armour there are in the game
    int animalCounter = 0;
    int weaponCounter = 0;
    int armourCounter = 0;
    //lets players move into different shops
    int moveAroundTown = 0;
    //lets players move inside of the shops
    int moveInShops = 0;
    //The lowest animal cost, so the program knows when a player cannot possibly afford another animal
    int lowestAnimalCost = 999999999;
    //how much the winning player gets for winning the fight
    int winnings = 0;
    //the durability of the armour
    int f1armourDurability = 0;
    int f2armourDurability = 0;
    //how likely the animal is going to dodge the attack
    int dodgeChance = 0;
    int damage = 0;
    //how much health the animal starts out with, without accounting for damage taken during combat
    int baseHealthP1 = 0;
    int baseHealthP2 = 0;
    //checks if the gamemode is competition or sandbox
    boolean isCompetition = true;
    //checks if it is raining in the game
    boolean isRaining = false;
    //checks if it is night in the game
    boolean isNight = true;
    //checks if the user wants to quit the game
    boolean quitGame = false;

    //checks if any sword has broken
    boolean swordBroke[] = new boolean [2]; 
    swordBroke[0] = false;
    swordBroke[1] = false;
    //checks if any armour has broken
    boolean armourBroke[] = new boolean [2]; 
    armourBroke[0] = false;
    armourBroke[1] = false; 
    //lists how much the armour equipped protects the animal
    int armourProtection[] = new int [2]; 
    armourProtection[0] = 0;
    armourProtection[1] = 0;
    //lists how much damage the sword does
    int swordDamage[] = new int [2]; 
    swordDamage[0] = 0;
    swordDamage[1] = 0;
    //lists the durability of the sword
    int swordDurability[] = new int [2];
    swordDurability[0] = 0;
    swordDurability[1] = 0;
    //lists the min and max damage swords get from hitting armour
    int minArmour[] = new int [2];
    minArmour[0] = 0;
    minArmour[1] = 0;

    int maxArmour[] = new int [2];
    maxArmour[0] = 5;
    maxArmour[1] = 5;
    
    System.out.println("Would you like to play competiton mode against another human or play sandbox mode?");

    //asks user what mode the want to play, and if needed, explains the different gamemodes
    while (true) {
      System.out.println("1. Competition Mode.");
      System.out.println("2. Sandbox Mode.");
      System.out.println("3. Explain Competition Mode.");
      System.out.println("4. Explain Sandbox Mode.");
      trueOrFalse = scanner.nextInt();
      if (trueOrFalse == 1) {
        isCompetition = true;
        break;
      } else if (trueOrFalse == 2) {
        isCompetition = false;
        break;
      } else if (trueOrFalse == 3) {
        System.out.println("Competition mode is a 1 on 1 competiton where you and another human player take turns spending coins on buying animals and giving them armour and weapons. Then, your animals fight to the death until one of them dies. This continues until one player runs out of money to buy any more animals.");
      } else if (trueOrFalse == 4) {
        System.out.println("Sandbox mode works similarly to competition mode, except there is no money and you can play with another person, with an AI, or buy yourself.");
      }
    }
  


    //ask the user if the want to face another human, an AI or if they want to play by themselves
    if (isCompetition != true) {
      System.out.println("Are you facing a human, the AI?, or yourself?");
      while (true) {
        System.out.println("1. Human"); 
        System.out.println("2. AI"); 
        System.out.println("3. Solo");
        humanOrAI = scanner.nextInt();
        if (humanOrAI == 1) {
          break;
        } else if (humanOrAI == 2) {
          break;
        } else if (humanOrAI == 3) {
          break;
        }
      } 
    }

    

    //adds animal objects to an array
    var listofanimals = new Animal[] {
      new Bear(),
      new Cat(),
      new Dog(),
      new Lion(),
      new Raccoon(),
      new Snake(),
      new Turtle()
    };

    //adds sword objects to an array
    var listofswords = new Swords[] {
      new WoodSword(),
      new IronSword(),
      new SteelSword(),
      new EbonySword(),
      new DragonboneSword()
    };


    //adds armour objects to an array 
    var listofarmour = new Armour[] {
      new HideArmour(),
      new IronArmour(),
      new SteelArmour(),
      new EbonyArmour(),
      new DaedricArmour()
    };

    
    //adds the arrays to an ArrayList and gets the size of the arrayList
    var animals = new ArrayList<>(Arrays.asList(listofanimals));
    var swords = new ArrayList<>(Arrays.asList(listofswords));
    var armours = new ArrayList<>(Arrays.asList(listofarmour));

    int AL_AnimalsSize = animals.size();
    int AL_SwordsSize = swords.size();
    int AL_ArmoursSize = armours.size();

    //creates an array of comabtants that is the size of the arraylist of animals
    String combatants[] = new String[AL_AnimalsSize];

    //adds the species of the animals to the combatants array
    for (var animal: animals) {
      combatants[animalCounter] = animal.species();
      if (animal.price() < lowestAnimalCost) {
        lowestAnimalCost = animal.price();
      }
      animalCounter++;
    }
    
    //creates an array of weapons that is the size of the arraylist of weapons
    String weapons[] = new String[AL_SwordsSize];

    //adds the weapons to the weapons array
    for (var sword: swords) {
      weapons[weaponCounter] = sword.type();
      weaponCounter++;
    }

    //creates an array of protection that is the size of the arraylist of armour
    String protection[] = new String[AL_ArmoursSize];

    //adds the armour to the protection array
    for (var armour: armours) {
      protection[armourCounter] = armour.type();
      armourCounter++;
    }

    //gives proper words depending on if user is playing by themselves or not
    if (humanOrAI != 3) {
      System.out.println("It is now player 1's turn to buy items.");
    } else {
      System.out.println("Customize animal 1.");
    }
    // this while loop lasts until one of the runs out of money to the point where they can't buy another animal
    while (player1money >= lowestAnimalCost && player2money >= lowestAnimalCost) {
      for (int i = 1; i <= 2; i++) { //allows for each player to get a turn buying equipment each round
        //if quitGame is true, it breaks out of the for loop
        if (quitGame != false) {
          break;
        }
        while (moveAroundTown != 4) { //4 exits the town and lets player2 decide what to buy
          moveAroundTown = townMovement(); //this allows for the player to move around town 
          while (moveAroundTown == 1) {  //enters the breeder
            moveInShops = 0; 
            buyAnimal = 0;
            moveInShops = breederMovement(); //moves within the breeders
            while (moveInShops == 1) { //if player wants to view animals
              for (var animal: animals) { //prints all the animals and their stats
                var fighter = (IFightable)animal;
                System.out.print(String.format(counter + ". %s, %s damage, %s defense, %s health", animal.species(), fighter.attackPoints(), fighter.defensePoints(), fighter.health()));
                if (isCompetition != false) { //if the gamemode is competition, it tells the player the price
                  System.out.println(String.format(", %s coins.", animal.price()));
                } else {
                  System.out.println(".");
                }
                counter++;
              }
              System.out.println(counter + ". Leave animal selection.");
              //adds the animal to the fighter1 or fighter2 slot
              buyAnimal = getPlayerChoice(combatants, AL_AnimalsSize);
              System.out.println(buyAnimal);
              counter = 1;
              if (buyAnimal == 8) {
                break;
              }
              if (i == 1) {
                if (isCompetition != false) { //tells the player the animal they chose and charges them for it. Also updates health.
                  if (player1money - listofanimals[buyAnimal].price() >= 0) {
                    System.out.println("You chose the " + combatants[buyAnimal]);
                    player1money -= listofanimals[buyAnimal].price();
                    baseHealthP1 = listofanimals[buyAnimal].health();
                    healthPointsP1 = baseHealthP1;
                    fighter1 = buyAnimal;
                    break;
                  
                  } else {
                    System.out.println("You don't have enough money to buy this item!");
                    buyAnimal = -1;
                    break;
                  }
                }
                //if player is not playing competition mode
                baseHealthP1 = listofanimals[buyAnimal].health();
                healthPointsP1 = baseHealthP1;
                fighter1 = buyAnimal;
                break;

              } else if (i == 2) {
                if (isCompetition != false) {
                  if (player2money - listofanimals[buyAnimal].price() >= 0) {
                    System.out.println("You chose the " + combatants[buyAnimal]);
                    player2money -= listofanimals[buyAnimal].price();
                    baseHealthP2 = listofanimals[buyAnimal].health();
                    healthPointsP2 = baseHealthP2;
                    fighter2 = buyAnimal;
                    break;
                  } else {
                    System.out.println("You don't have enough money to buy this item!");
                    buyAnimal = -1;
                    break;
                  }
                }
                baseHealthP2 = listofanimals[buyAnimal].health();
                System.out.println("Base health: " + baseHealthP2);
                healthPointsP2 = baseHealthP2;
                fighter2 = buyAnimal;
                break;
              }
            } 
            while (moveInShops == 2) { //Lets you go back out to the town
              moveAroundTown = 0;
              break;
            } 
          }

          while (moveAroundTown == 2) {  //enters doctor
            System.out.println(fighter1);
            if (i == 1 && fighter1 == -1) {
              System.out.println("You do not have an animal to heal! GET OUT!");
              break;
            } else if (i == 2 && fighter2 == -1) {
              System.out.println("You do not have an animal to heal! GET OUT!!");
              break;
            } else if (i == 1 && healthPointsP1 == baseHealthP1) {
              System.out.println("Your animal is at full health! GET OUT!");
              break;
            } else if (i == 2 && healthPointsP2 == baseHealthP2) {
              System.out.println("Your animal is at full health! GET OUT!");
              break;
            }
            moveInShops = doctorMovement();

            while (moveInShops == 1) {
              if (i == 1) {
                if (isCompetition != false) {
                  System.out.println("It costs me 1 gold to heal 1 health.");
                }
                System.out.println("You currently have " + healthPointsP1 + " whereas you could possibly have up to " + baseHealthP1 + ". How much health would you like to heal?");
                int healedHealth = scanner.nextInt();
                if (healedHealth > (baseHealthP1 - healthPointsP1)) {
                  healedHealth = baseHealthP1 - healthPointsP1;
                } else if (healedHealth < 0) {
                  System.out.println("Don't harm your animals! GET OUT!");
                  moveInShops = 2;
                  break;
                }

                if (isCompetition != false) {
                  if (player2money - healedHealth < 0) {
                    System.out.println("You don't have enough money to afford this service! GET OUT!");
                    moveInShops = 2;
                    break;
                  } else {
                    player2money -= healedHealth;
                  }
                }
                healthPointsP1 += healedHealth;
                System.out.println("You've healed your animal " + healedHealth + " health points. Now, GET OUT!");
                moveAroundTown = 0;
                break;
              } else if (i == 2) {
                if (isCompetition != false) {
                  System.out.println("It costs me 1 gold to heal 1 health.");
                }
                System.out.println("You currently have " + healthPointsP2 + " health whereas you could possibly have up to " + baseHealthP2 + " health. How much health would you like to heal?");
                int healedHealth = scanner.nextInt();
                if (healedHealth > (baseHealthP2 - healthPointsP2)) {
                  healedHealth = baseHealthP2 - healthPointsP2;
                } else if (healedHealth < 0) {
                  System.out.println("Don't harm your animals! GET OUT!");
                  moveInShops = 2;
                  break;
                }
                

                if (isCompetition != false) {
                  if (player2money - healedHealth < 0) {
                    System.out.println("You don't have enough money to afford this service! GET OUT!");
                    moveInShops = 2;
                    break;
                  } else {
                    player2money -= healedHealth;
                  }
                }
                healthPointsP2 += healedHealth;
                System.out.println("You've healed your animal " + healedHealth + " health points. Now, GET OUT!");
                moveAroundTown = 0;
                break;
              }
            } while (moveInShops == 2) {
              moveAroundTown = 0;
              break;               
            }

          }
          while (moveAroundTown == 3) { //enter blacksmith
            moveInShops = 0;
            buyArmour = 0;
            buySword = 0;
            moveInShops = forgeMovement();
            while (moveInShops == 1) { 
              for (var sword: swords) {
                System.out.print(String.format(counter + ". %s, %s damage, %s durability", sword.type(), sword.damage(), sword.durability()));
                if (isCompetition != false) {
                  System.out.println(String.format(", %s coins", sword.price()));
                } else {
                  System.out.println(".");
                }
                counter++;
              }
              System.out.println(counter + ". Leave sword selection.");
              buySword = getPlayerSword(weapons, AL_SwordsSize);
              counter = 1;
              if (buySword == 6) {
                break;
              }
              if (i == 1) {
                if (isCompetition != false) {
                  if (player1money - listofswords[buySword].price() >= 0) {
                  System.out.println("You chose the " + weapons[buySword]);
                  player1money -= listofswords[buySword].price();
                  sword1 = buySword;
                  break;
                  } else {
                    System.out.println("You don't have enough money to buy this item!");
                    buySword = -1;
                    break;
                  }
                }
                sword1 = buySword;
                break;
              } else if (i == 2) {
                if (isCompetition != false) {
                  if (player2money - listofswords[buySword].price() >= 0) {
                    System.out.println("You chose the " + weapons[buySword]);
                    player2money -= listofswords[buySword].price();
                    sword2 = buySword;
                    break;
                  } else {
                    System.out.println("You don't have enough money to buy this item!");
                    buySword = -1;
                  }
                }
                sword2 = buySword;
                break;
              }
              
            } while (moveInShops == 2) { 
              for (var armour: armours) {
                System.out.print(String.format(counter + ". %s, %s protection, %s durability", armour.type(), armour.protection(), armour.durability()));
                if (isCompetition != false) {
                  System.out.println(String.format(", %s coins", armour.price()));
                } else {
                  System.out.println(".");
                }
                counter++;
              }
              counter = 1;
              buyArmour = getPlayerArmour(protection, AL_ArmoursSize);
              if (buyArmour == 6) {
                break;
              }
              
              if (i == 1) {
                if (isCompetition != false) {
                  if (player1money - listofarmour[buyArmour].price() >= 0) {
                    System.out.println("You chose the " + protection[buyArmour]);
                    player1money -= listofarmour[buyArmour].price();
                    armour1 = buyArmour;
                    break;
                  } else {
                    System.out.println("You don't have enough money to buy this item!");
                    buyArmour = -1;
                    break;
                  }
                }
                armour1 = buyArmour;
                break;

              } else if (i == 2) {
                if (player2money - listofarmour[buyArmour].price() >= 0) {
                  System.out.println("You chose the " + protection[buyArmour]);
                  player2money -= listofarmour[buyArmour].price();
                  armour2 = buyArmour;
                  break;
                } else {
                  System.out.println("You don't have enough money to buy this item!");
                  buyArmour = -1;
                }
                armour2 = buyArmour;
                break;
              }
            } while (moveInShops == 3) { //lets you leave to the town
              moveAroundTown = 0;
              break; 
            }
          }

          if (moveAroundTown == 5) { //quits the game if user enters a five
            quitGame = true;
            break;
          }
        }
        moveAroundTown = 0;
        i = canPlayerLeave(fighter1, fighter2, humanOrAI, i, quitGame); //checks if the player is able to leave the town
        
      }

      System.out.println("It is now time to fight!");

      if (quitGame != false) { //fully exits the game if quitGame is true
        break;
      }

      if (humanOrAI == 2) { //if facing an ai, this gets them all of their equipment
        fighter2 = getAIChoice(combatants, AL_AnimalsSize);
        sword2 = getAISword(weapons, AL_SwordsSize);
        armour2 = getAIArmour(protection, AL_ArmoursSize);
      }

      //how much the sword impacts the armours durability
      int minP1Sword = 0;
      int maxP1Sword = 5;
      int minP2Sword = 0;      
      int maxP2Sword = 5;


      //gives players their base attackPoints, defensePoints, and how likely they are to dodge an attack
      
      var fighterName1 = (IFightable)listofanimals[fighter1];
      int attackValueP1 = fighterName1.attackPoints();
      int defenseValueP1 = fighterName1.defensePoints();
      int dodgePercentP1 = fighterName1.dodgePercent();

      var fighterName2 = (IFightable)listofanimals[fighter2];
      int attackValueP2 = fighterName2.attackPoints();
      int defenseValueP2 = fighterName2.defensePoints();
      int dodgePercentP2 = fighterName2.dodgePercent();
      if (humanOrAI == 2) {
        baseHealthP2 = fighterName2.health();
        healthPointsP2 = baseHealthP2;
      }

      //gives swords their durability
      if (sword1 != -1) {
       var f1sword = listofswords[sword1];
       swordDamage[0] = f1sword.damage();
       attackValueP1 += swordDamage[0];
       swordDurability[0] = f1sword.durability();
       if (f1sword.piercing() > 2) {
         minArmour[0] = f1sword.piercing() - 3;
         maxP1Sword = f1sword.piercing() + 3;
       }
      }


      if (sword2 != -1) {
        var f2sword = listofswords[sword2];
        swordDamage[1] = f2sword.damage();
        attackValueP2 += swordDamage[1];
        swordDurability[1] = f2sword.durability();
        if (f2sword.piercing() > 2) {
          minArmour[1] = f2sword.piercing() - 3;
          maxP2Sword = f2sword.piercing() + 3;
        }
      }
      
      //if player does not have a sword, it is automatically already broken

      if (sword1 == -1) {
        swordBroke[0] = true;
      } 

      if (sword2 == -1) {
        swordBroke[1] = true;
      }



      //if a player is faster than another player and is smaller, it gives them a boost to their dodging
      if (fighterName1.speed() < fighterName2.speed() && fighterName1.size() >  fighterName2.size()) { 
        dodgePercentP2 += fighterName2.speed() - fighterName1.speed() + 2;
      } else if (fighterName1.speed() > fighterName2.speed() && fighterName1.size() < fighterName2.size() ){ 
      dodgePercentP1 += fighterName1.speed() - fighterName2.speed();
      //if a player is faster than another player but is bigger than the other player, gives them a smaller boost to their dodging ability
      } else if (fighterName1.speed() < fighterName2.speed()) { 
      dodgePercentP2 += fighterName2.speed() - fighterName1.speed() - 2;
      } else if (fighterName1.speed() > fighterName2.speed()) { 
      dodgePercentP1 += fighterName1.speed() - fighterName2.speed() - 2;
      }

      //if fighter is a predator, they get five more attack. if fighter is prey, they dodge 5% more often.

      if (fighterName1.isPredator()) {
        attackValueP1 += 5;
      } else {
        dodgePercentP1 += 5;
      }

      if (fighterName2.isPredator()) {
        attackValueP2 += 5;
      } else {
        dodgePercentP2 += 5;
      }
      //gives bonus to animals that hunt alone and a deficit to animals who hunt in packs
      if (fighterName1.isSoloHunter()) {
        attackValueP1 += 2;
      } else {
        attackValueP1 -= 2;
      }

      if (fighterName1.isSoloHunter()) {
        attackValueP2 += 2;
      } else {
        attackValueP2 -= 2;
      }
      //give bonus/penalty depending on how strong an animal is
      switch (fighterName1.strength()) {
        case 1:
          attackValueP1 -= 4;
          break;
        case 2:
          attackValueP1 -= 3;
          break;
        case 3:
          attackValueP1 -= 2;
          break;
        case 4:
          attackValueP1--;
          break;
        case 5:
          attackValueP1 = attackValueP1;
          break;
        case 6:
          attackValueP1++;
          break;
        case 7:
          attackValueP1 += 2;
          break;
        case 8:
          attackValueP1 += 3;
          break;
        case 9:
          attackValueP1 += 4;
          break;
        default:
          attackValueP1 = attackValueP1;
          break;
      }

      switch (fighterName2.strength()) {
        case 1:
          attackValueP2 -= 4;
          break;
        case 2:
          attackValueP2 -= 3;
          break;
        case 3:
          attackValueP2 -= 2;
          break;
        case 4:
          attackValueP2--;
          break;
        case 5:
          attackValueP2 = attackValueP2;
          break;
        case 6:
          attackValueP2++;
          break;
        case 7:
          attackValueP2 += 2;
          break;
        case 8:
          attackValueP1 += 3;
          break;
        case 9:
          attackValueP2 += 4;
          break;
        default:
          attackValueP2 = attackValueP2;
          break;
      }

      
      //determines if it is raining
      trueOrFalse = random.nextInt(2);
      if (trueOrFalse == 0) {
        isRaining = false;
        System.out.println("It is not raining.");
      } else if (trueOrFalse == 1) {
        isRaining = true;
        System.out.println("It is raining.");
      }

      if (isRaining != false) {
        attackValueP1 -= 5;
        defenseValueP1 -= 10;
        dodgePercentP1 -= 20;
        attackValueP2 -= 5;
        defenseValueP2 -= 10;
        dodgePercentP2 -= 20;
      }

      trueOrFalse = random.nextInt(2);

      //determines if it is night
      if (trueOrFalse == 0) {
        isNight = false;
        System.out.println("It is daytime.");
      } else if (trueOrFalse == 1) {
        isNight = true;
        System.out.println("It is nighttime.");
      }
      //gives bonus if time of day matches time of activity
      if (isNight != false) {
        if (fighterName1.isNocturnal()) {
          attackValueP1 += 5;
          defenseValueP1 += 5;
          dodgePercentP1 += 5;
        
        } else {
          attackValueP1 -= 5;
          defenseValueP1 -= 7;
          dodgePercentP1 -= 15;
        }
        if (fighterName2.isNocturnal()) {
          attackValueP2 += 5;
          defenseValueP2 += 5;
          dodgePercentP2 += 5;
          
        } else {
          attackValueP2 -= 5;
          defenseValueP2 -= 7;
          dodgePercentP2 -= 15;
        }
      } else {
        if (fighterName1.isNocturnal()) {
          attackValueP1 -= 5;
          defenseValueP1 -= 7;
          dodgePercentP1 -= 15;
          
        } else {
          attackValueP1 += 5;
          defenseValueP1 += 5;
          dodgePercentP1 += 5;
        }
        if (fighterName2.isNocturnal()) {
          attackValueP2 -= 5;
          defenseValueP2 -= 7;
          dodgePercentP2 -= 15;
          
        } else {
          attackValueP2 += 5;
          defenseValueP2 += 5;
          dodgePercentP2 += 5;
        }
      }

      //if dodge percentage is above 50%, it reduces it down to 50%
      if (dodgePercentP1 > 50) {
        dodgePercentP1 = 50;
      }

      if (dodgePercentP2 > 50) {
        dodgePercentP2 = 50;
      }
      //gives armour its durability, and takes away 7% dodging if the armour is heavy
      if (armour1 != -1) {
        var f1armour = listofarmour[armour1];
        armourProtection[0] = f1armour.protection();
        defenseValueP1 += armourProtection[0];
        f1armourDurability = f1armour.durability();
        if (f1armour.hardness() > 2) {
          minArmour[0] = f1armour.hardness() - 3;
          maxArmour[0] = f1armour.hardness() + 3;
        }
        if (f1armour.isHeavy()) {
          dodgePercentP1 -= 7;
        }
      }

      if (armour2 != -1) {
        var f2armour = listofarmour[armour2];
        armourProtection[1] = f2armour.protection();
        defenseValueP2 += armourProtection[1];
        f2armourDurability = f2armour.durability();
        if (f2armour.hardness() > 2) {
          minArmour[1] = f2armour.hardness() - 3;
          maxArmour[1] = f2armour.hardness() + 3;
        }
        if (f2armour.isHeavy()) {
          dodgePercentP2 -= 7;
        }
      }
      //determines who attacks first based on stealth
      if (fighterName1.stealth() > fighterName2.stealth()) {
        currentAttacker = 1;
      } else if (fighterName2.stealth() > fighterName1.stealth()) {
        currentAttacker = 0;
      } else {
        currentAttacker = random.nextInt(2);
      }
    
    //until one animal dies
    while (healthPointsP1 > 0 && healthPointsP2 > 0) {
      while (currentAttacker % 2 != 0) { //determines who's turn it is 
        //checks to see if animal passed the dodging check
        dodgeChance = random.nextInt(100); 
        if (dodgeChance < dodgePercentP2) {
          //check passed and player dodges
          System.out.println("Player 1's " + combatants[fighter1] + " attacked Player 2's " + combatants[fighter2] + ", but " + combatants[fighter2] + " dodged out of the way.");
        } else {
          //check failed, does attack based on how much health the animal has lost so far
          if (healthPointsP1 > baseHealthP1 * 0.9) {
            damage = attackValueP1 - (defenseValueP2 / 2);
          } else if (healthPointsP1 > baseHealthP1 * 0.7) {
            damage = attackValueP1 - (defenseValueP2 / 2) + 5;
          } else if (healthPointsP1 > baseHealthP1 * 0.5 ) {
            damage = attackValueP1 - (defenseValueP2 / 2) - 2;
          } else if (healthPointsP1 > baseHealthP1 * 0.2 ) {
            damage = attackValueP1 - (defenseValueP2 / 2) - 7;
          } else {
            damage = attackValueP2 - (defenseValueP1 / 2) - 10;
          }
          healthPointsP2 -= damage;
          System.out.println("Player 1's " + combatants[fighter1] + " attacks Player 2's " + combatants[fighter2] + " dealing " + damage + " damage.");
          damage = 0;
        }
        //checks to see if the sword broke, and if not, decreases the durability
        if (swordBroke[0] != true) {
          if (sword1 != -1) {
            swordDurability[0] -= random.nextInt(maxArmour[1] - minArmour[1]) + minArmour[1];
            if (swordDurability[0] < 1) {
              attackValueP1 -= swordDamage[0];
              System.out.println("Player 1's sword has broken.");
              swordBroke[0] = true;
            }
          }
        } 
        //checks to see if the armour broke, and if not, decreases the durability
        if (armourBroke[0] != true) {
          if (armour1 != -1) {
            f1armourDurability -= random.nextInt(maxP2Sword - minP2Sword) + minP2Sword;
            if (f1armourDurability < 1) {
              defenseValueP1 -= armourProtection[0];
              System.out.println("Player 1's armour has broken.");
              armourBroke[0] = true;
            }
          }
        }
        currentAttacker--; //changes the current attacker
      }
      while (currentAttacker % 2 == 0) {
        if (healthPointsP2 > 0) {
          dodgeChance = random.nextInt(100);
          if (dodgeChance < dodgePercentP1) {
            System.out.println("Player 2's " + combatants[fighter2] + " attacked Player 1's " + combatants[fighter1] + ", but " + combatants[fighter1] + " dodged out of the way.");
          } else {
            if (healthPointsP2 >= baseHealthP2 * 0.9) {
              damage = attackValueP2 - (defenseValueP1 / 2);
            } else if (healthPointsP2 >= baseHealthP2 * 0.7) {
              damage = attackValueP2 - (defenseValueP1 / 2) + 5;
            } else if (healthPointsP2 >= baseHealthP2 * 0.5 ) {
              damage = attackValueP2 - (defenseValueP1 / 2) - 2;
            } else if (healthPointsP2 >= baseHealthP2 * 0.2) {
              damage = attackValueP2 - (defenseValueP1 / 2) - 7;
            } else {
              damage = attackValueP2 - (defenseValueP1 / 2) - 10;
            }
            healthPointsP1 -= damage;
            System.out.println("Player 2's " + combatants[fighter2] + " attacks Player 1's " + combatants[fighter1] + " dealing " + damage + " damage.");
          }
          if (swordBroke[1] != true) {
            if (sword2 != -1) {
              swordDurability[1] -= random.nextInt(maxArmour[0] - minArmour[0]) + minArmour[0];
              if (swordDurability[1] < 1) {
                attackValueP2 -= swordDamage[1];
                System.out.println("Player 2's sword has broken.");
                swordBroke[1] = true;
              }
            }
          }
          if (armourBroke[1] != true) {
            if (armour2 != -1) {
              f2armourDurability -= random.nextInt(maxP1Sword - minP1Sword) + minP1Sword;
              if (f2armourDurability < 1) {
                defenseValueP2 -= armourProtection[1];
                System.out.println("Player 2's armour has broken.");
                armourBroke[1] = true;
              }
            }
          }
        }
        currentAttacker++;
      }
    }
      //resets the effects that the enviorment had on the animlals

      if (isRaining != false) {
        attackValueP1 += 5;
        defenseValueP1 += 10;
        dodgePercentP1 += 20;
        attackValueP2 += 5;
        defenseValueP2 += 10;
        dodgePercentP2 += 20;
      }


      if (isNight != false) {
        if (fighterName1.isNocturnal()) {
          attackValueP1 -= 5;
          defenseValueP1 -= 5;
          dodgePercentP1 -= 5;
        
        } else {
          attackValueP1 += 5;
          defenseValueP1 += 7;
          dodgePercentP1 += 15;
        }
        if (fighterName2.isNocturnal()) {
          attackValueP2 -= 5;
          defenseValueP2 -= 5;
          dodgePercentP2 -= 5;
        } else {
          attackValueP2 += 5;
          defenseValueP2 += 7;
          dodgePercentP2 += 15;
        }
      } else {
        if (fighterName1.isNocturnal()) {
          attackValueP1 += 5;
          defenseValueP1 += 7;
          dodgePercentP1 += 15;
          
        } else {
          attackValueP1 -= 5;
          defenseValueP1 -= 5;
          dodgePercentP1 -= 5;
      
        } if (fighterName2.isNocturnal()) {
         attackValueP2 += 5;
          defenseValueP2 += 7;
          dodgePercentP2 += 15;
        
        } else {
          attackValueP2 -= 5;
          defenseValueP2 -= 5;
          dodgePercentP2 -= 5;
        }
      }
    
      

      //prints who won the fight
      if (healthPointsP1 < 1) {
        System.out.println("Player 2 wins this battle!");
        winnings = random.nextInt(50 - 10) + 10;
        player2money += winnings;
        System.out.println("You won " + winnings + " coins for beating your opponent.");
        fighter1 = -1;

      } else if (healthPointsP2 < 1) {
        System.out.println("Player 1 wins this battle!");
        winnings = random.nextInt(50 - 10) + 10;
        player1money += winnings;
        System.out.println("You won " + winnings + " coins for beating your opponent.");
        fighter2 = -1;
      }
    }
    //if no more money can be spent, or the game quits
    if (fighter1 != -1) {
      System.out.println("Player 1 wins!");
    } else if (fighter2 != -1) {
      System.out.println("Player 2 wins!");
    } else {
      System.out.println("Nobody won!");
    }
  } //close main method

  public static int getPlayerChoice (String combatants[], int AL_AnimalsSize) {
    Scanner scanner = new Scanner (System.in); 
    String chosenFighter = "";
    int chooseFighter = -1;
    System.out.println("What animal woud you like to be? Enter the animal's number to select them to be your fighter.");
    boolean isAFighter = false; 
    //finds the corrosponding animal, checks to see if it is valid, and returns that number
    while (isAFighter != true) {
      chooseFighter = scanner.nextInt(); //asks player to choose a fighter and matches it with the fighters on the list
      switch (chooseFighter) { 
        case 1:
          chosenFighter = "Bear";
          isAFighter = true;
          break;
        case 2:
          chosenFighter = "Cat";
          isAFighter = true;
          break;
        case 3:
          chosenFighter = "Dog";
          isAFighter = true;
          break;
        case 4:
          chosenFighter = "Lion";
          isAFighter = true;
          break;
        case 5:
          chosenFighter = "Raccoon";
          isAFighter = true;
          break;
        case 6:
          chosenFighter = "Snake";
          isAFighter = true;
          break;
        case 7:
          chosenFighter = "Turtle";
          isAFighter = true;
          break;
        default:
          return 8; //if the number doesn't match, does not give an animal
      }
    }
    for (int i = 0; i <= AL_AnimalsSize - 1; i++) {
      if (chosenFighter.equals(combatants[i])) {
        return i; //returns the animal selection
      }
    }
    //if something goes wrong, it returns -1
    return -1;
  }

  //randomly picks a fighter
  public static int getAIChoice (String combatants[], int AL_AnimalsSize) {
    Random random = new Random();
    int chooseFighter;
    chooseFighter = random.nextInt(AL_AnimalsSize); 
    return chooseFighter;
  }

  public static int getAISword (String weapons[], int AL_SwordsSize) {
    Random random = new Random();
    int chooseSword;
    chooseSword = random.nextInt(AL_SwordsSize);
    if (chooseSword == 0) {
      return -1;
    } else {
      return chooseSword;
    }
  }

  public static int getAIArmour (String protection[], int AL_ArmoursSize) {
    Random random = new Random();
    int chooseArmour;
    chooseArmour = random.nextInt(AL_ArmoursSize);
    if (chooseArmour == 0) {
      return -1;
    } else {
      return chooseArmour;
    }

  }

  public static int getPlayerSword (String weapons[], int AL_SwordsSize) {
    Scanner scanner = new Scanner (System.in);
    String chosenSword = "";
    int chooseSword = -1;
    System.out.println("What sword would you like? Enter the matching number to select it.");
    boolean isAWeapon = false;
    while (isAWeapon != true) {
      chooseSword = scanner.nextInt();
      switch (chooseSword) {
        case 1:
          chosenSword = "Wooden Sword";
          isAWeapon = true;
          break;
        case 2:
          chosenSword = "Iron Sword";
          isAWeapon = true;
          break;
        case 3:
          chosenSword = "Steel Sword";
          isAWeapon = true;
          break;
        case 4:
          chosenSword = "Ebony Sword";
          isAWeapon = true;
          break;
        case 5:
          chosenSword = "Dragonbone Sword";
          isAWeapon = true;
          break;
        default:
          return 6;
      }
    }
    for (int i = 0; i <= AL_SwordsSize - 1; i++) {
      if (chosenSword.equals(weapons[i])) {
        return i;
      }
    }
    return -1;
  }

  public static int getPlayerArmour(String armour[], int AL_ArmoursSize) {
    Scanner scanner = new Scanner (System.in);
    String chosenArmour = "";
    int chooseArmour = -1;
    System.out.println("What armour would you like? Enter the matching number to select it.");
    boolean isArmour = false;
    while (isArmour != true) {
      chooseArmour = scanner.nextInt();
      switch (chooseArmour) {
        case 1:
          chosenArmour = "Hide Armour";
          isArmour = true;
          break;
        case 2:
          chosenArmour = "Iron Armour";
          isArmour = true;
          break;
        case 3:
          chosenArmour = "Steel Armour";
          isArmour = true;
          break;
        case 4:
          chosenArmour = "Ebony Armour";
          isArmour = true;
          break;
        case 5:
          chosenArmour = "Daedric Armour";
          isArmour = true;
          break;
        default:
          return 6;
      }
    }
    for (int i = 0; i <= AL_ArmoursSize - 1; i++) {
      if (chosenArmour.equals(armour[i])) {
        return i;
      }
    }
    return -1;
  }

  //prints options and allows for the user to select them
  public static int townMovement() {
    Scanner scanner = new Scanner (System.in);
    System.out.println("Where would you like to go?");
    System.out.println("1. Arivanya's Animals, an animal breeder.");
    System.out.println("2. Bothela's Animal Hospital, an animal healer.");
    System.out.println("3. Balimund's Forge, a weapon and armour seller.");
    System.out.println("4. Leave town, and head to the fight.");
    System.out.println("5. Quit the game.");
    int moveAroundTown = scanner.nextInt();
    return moveAroundTown;
  }

  public static int breederMovement() {
    Scanner scanner = new Scanner (System.in);
    System.out.println("Welcome to Arivanya's Animals. We have all sorts of animals for purchase. So what animal would you like to buy?");
    System.out.println("1. Animals");
    System.out.println("2. Leave Arivanya's");
    int moveInShops = scanner.nextInt(); 
    return moveInShops;
  }

  public static int forgeMovement() {
    Scanner scanner = new Scanner (System.in);
    System.out.println("Welcome to Balimund's Forge! We have the finest weapons and armour. So what would you like to purchase?");
    System.out.println("1. Swords");
    System.out.println("2. Armour");
    System.out.println("3. Leave Balimund's");
    int moveInShops = scanner.nextInt();
    return moveInShops;
  }

  public static int canPlayerLeave(int fighter1, int fighter2, int humanOrAI, int i, boolean quitGame) {
    if (quitGame != false) { //if the player wants to quit the game, it just returns i without doing any other checks
      return i;
    } else if (humanOrAI == 2) {
      return i + 1; //if human is facing an ai, skips player 2's turn
    } else if (fighter1 == -1) {
      System.out.println("You must choose a fighter! Visit Arivanya's Animals to buy an animal.");
      i--; //tells the player to buy an animal
    } else if (fighter2 == -1 && i == 2) {
      System.out.println("You must choose a fighter! Visit Arivanya's Animals to buy an animal.");
      i--;
    }
    //tells the player to customize animal 2. words depend on if player is playing by themsleves or not
    else if (i == 1) {
      if (humanOrAI != 3) {
        System.out.println("It is now player 2's turn to buy items.");
      } else {
        System.out.println("Please customize animal 2."); 
      }
      
    }
    return i;
  }

  public static int doctorMovement() {
    Scanner scanner = new Scanner (System.in);
    System.out.println("Welcome to Bothela's Animal Hospital! How may I heal your animal?");
    System.out.println("1. Healing");
    System.out.println("2. Leave Bothela's");
    int moveInShops = scanner.nextInt();
    return moveInShops;
    
  }
  
}


 //close class Main



