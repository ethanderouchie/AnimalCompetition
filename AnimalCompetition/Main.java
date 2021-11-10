import java.util.*;

class Main {
  public static void main(String[] args) {   
    Scanner scanner = new Scanner (System.in);
    Random random = new Random();
    //player1's animal and player2/AI's animal.
    int numberOfAnimals = 2;
    int fighter1 = -1;
    int fighter2 = -1;
    int trueOrFalse = -1;
    //player1's sword and player2/AI's sword.
    int sword1 = -1;
    int sword2 = -1;
    int armour1 = -1;
    int armour2 = -1;
    int buyAnimal = -1;
    int buyArmour = -1;
    int buySword = -1;
    int counter = 1;
    int currentAttacker = -1;
    //Starting money
    int player1money = 100;
    int player2money = 100;
    //lets program know if player1 wants to face a human or an ai
    int humanOrAI;
    boolean isFacingHuman = false;
    //counts animals and weapons
    int animalCounter = 0;
    int weaponCounter = 0;
    int armourCounter = 0;
    //navigate the town and the shops using numbers
    int moveAroundTown = 0;
    int moveInShops = 0;
    int lowestAnimalCost = 999999999;
    int winnings = 0;
    int f1armourDurability = 0;
    int f2armourDurability = 0;
    int dodgeChance = 0;
    int damage = 0;
    int baseHealthP1 = 0;
    int baseHealthP2 = 0;
    boolean isCompetition = true;
    boolean isRaining = false;
    boolean isNight = true;

    boolean swordBroke[] = new boolean [2]; 
    swordBroke[0] = false;
    swordBroke[1] = false;

    boolean armourBroke[] = new boolean [2]; 
    armourBroke[0] = false;
    armourBroke[1] = false;

    int armourProtection[] = new int [2]; 
    armourProtection[0] = 0;
    armourProtection[1] = 0;

    int swordDamage[] = new int [2]; 
    swordDamage[0] = 0;
    swordDamage[1] = 0;

    int swordDurability[] = new int [2];
    swordDurability[0] = 0;
    swordDurability[1] = 0;

    int minArmour[] = new int [2];
    minArmour[0] = 0;
    minArmour[1] = 0;

    int maxArmour[] = new int [2];
    maxArmour[0] = 5;
    maxArmour[1] = 5;
    
    System.out.println("Would you like to play competiton mode against another human or play sandbox mode?");


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
        } else if (humanOrAI == 3)
          break;
      } 
    }

    

    //adds animal objects to an array
    var listofanimals = new Animal[] {
      new Raccoon(),
      new Cat(),
      new Dog()
    };

    //adds sword objects to an array
    var listofswords = new Swords[] {
      new WoodSword(),
      new IronSword(),
      new SteelSword(),
      new EbonySword(),
      new DragonboneSword()
    };

    var listofarmour = new Armour[] {
      new HideArmour(),
      new IronArmour(),
      new SteelArmour(),
      new EbonyArmour(),
      new DaedricArmour()
    };

    
    //adds the arrays to an ArrayList and gets the ArrayList size
    var animals = new ArrayList<>(Arrays.asList(listofanimals));
    var swords = new ArrayList<>(Arrays.asList(listofswords));

    var armours = new ArrayList<>(Arrays.asList(listofarmour));

    int AL_AnimalsSize = animals.size();
    int AL_SwordsSize = swords.size();
    int AL_ArmoursSize = armours.size();

    //gets an array  of what species the animals are
    String combatants[] = new String[AL_AnimalsSize];

    for (var animal: animals) {
      combatants[animalCounter] = animal.species();
      if (animal.price() < lowestAnimalCost) {
        lowestAnimalCost = animal.price();
      }
      animalCounter++;
    }
    
    //gets an array of what type the weapons are
    String weapons[] = new String[AL_SwordsSize];

    for (var sword: swords) {
      weapons[weaponCounter] = sword.type();
      weaponCounter++;
    }

    String protection[] = new String[AL_ArmoursSize];

    for (var armour: armours) {
      protection[armourCounter] = armour.type();
      armourCounter++;
    }



    System.out.println("It is now player 1's turn to buy items.");
    while (player1money >= lowestAnimalCost && player2money >= lowestAnimalCost) {
      for (int i = 1; i <= 2; i++) { //allows for each player to get a turn buying equipment each round
        while (moveAroundTown != 4) { //4 exits the town and lets player2 decide what to buy
          moveAroundTown = townMovement();
          while (moveAroundTown == 1) { 
            moveInShops = 0;
            buyAnimal = 0;
            moveInShops = breederMovement();
            while (moveInShops == 1) { 
              for (var animal: animals) { //prints all the animals and their stats
                var fighter = (IFightable)animal;
                System.out.print(String.format(counter + ". %s, %s damage, %s defense, %s health", animal.species(), fighter.attackPoints(), fighter.defensePoints(), fighter.health()));
                if (isCompetition != false) {
                  System.out.println(String.format(", %s coins.", animal.price()));
                } else {
                  System.out.println();
                }
                counter++;
              }
              System.out.println(counter + ". Leave animal selection.");
              //adds the animal to the fighter1 or fighter2 slot
              buyAnimal = getPlayerChoice(combatants, AL_AnimalsSize);
              counter = 1;
              if (buyAnimal == 4) {
                break;
              }
              if (i == 1) {
                if (isCompetition != false) {
                  if (player1money - listofanimals[buyAnimal].price() > 0) {
                    System.out.println("You chose the " + combatants[buyAnimal]);
                    player1money -= listofanimals[buyAnimal].price();
                    baseHealthP1 = listofanimals[buyAnimal].health();
                    fighter1 = buyAnimal;
                    break;
                  
                  } else {
                    System.out.println("You don't have enough money to buy this item!");
                    buyAnimal = -1;
                    break;
                  }
                }
                fighter1 = buyAnimal;
                break;

              } else if (i == 2) {
                if (isCompetition != false) {
                  if (player2money - listofanimals[buyAnimal].price() > 0) {
                    System.out.println("You chose the " + combatants[buyAnimal]);
                    player2money -= listofanimals[buyAnimal].price();
                    baseHealthP2 = listofanimals[buyAnimal].health();
                    fighter2 = buyAnimal;
                    break;
                  } else {
                    System.out.println("You don't have enough money to buy this item!");
                    buyAnimal = -1;
                    break;
                  }
                }
                fighter2 = buyAnimal;
                break;
              }
            } 
            while (moveInShops == 2) { //Lets you go back out to the town
              moveAroundTown = 0;
              break;
            } 
          }


          while (moveAroundTown == 2) { //this will eventually allow you to heal your animals, right now kicks you out to the town
            moveInShops = 0;
            moveAroundTown = 0;
          }
          //allows for all the operations of a blacksmith
          while (moveAroundTown == 3) { //enter blacksmith
            moveInShops = 0;
            buyArmour = 0;
            buySword = 0;
            moveInShops = forgeMovement();
            while (moveInShops == 1) { //buy swords
              for (var sword: swords) {
                System.out.println(String.format(counter + ". %s, %s damage, %s durability, %s coins", sword.type(), sword.damage(), sword.durability(), sword.price()));
                counter++;
              }
              System.out.println(counter + ". Leave sword selection.");
              counter = 1;
              buySword = getPlayerSword(weapons, AL_SwordsSize);
              if (buySword == 6) {
                break;
              }
              if (i == 1) {
                if (player1money - listofswords[buySword].price() > 0) {
                  System.out.println("You chose the " + weapons[buySword]);
                  player1money -= listofswords[buySword].price();
                  sword1 = buySword;
                  break;
                } else {
                  System.out.println("You don't have enough money to buy this item!");
                  buySword = -1;
                }

              } else if (i == 2) {
                if (player2money - listofswords[buySword].price() > 0) {
                  System.out.println("You chose the " + weapons[buySword]);
                  player2money -= listofswords[buySword].price();
                  sword2 = buySword;
                  break;
                } else {
                  System.out.println("You don't have enough money to buy this item!");
                  buySword = -1;
                }
              }
              
            } while (moveInShops == 2) { 
              for (var armour: armours) {
                System.out.println(String.format(counter + ". %s, %s protection, %s durability, %s coins.", armour.type(), armour.protection(), armour.durability(), armour.price()));
                counter++;
              }
              buyArmour = getPlayerArmour(protection, AL_ArmoursSize);
              if (buyArmour == 6) {
                break;
              }
              
              if (i == 1) {
                if (player1money - listofarmour[buyArmour].price() > 0) {
                  System.out.println("You chose the " + protection[buyArmour]);
                  player1money -= listofarmour[buyArmour].price();
                  armour1 = buyArmour;
                  break;
                } else {
                  System.out.println("You don't have enough money to buy this item!");
                  buyArmour = -1;
                }
              } else if (i == 2) {
                if (player2money - listofarmour[buyArmour].price() > 0) {
                  System.out.println("You chose the " + protection[buyArmour]);
                  player2money -= listofarmour[buyArmour].price();
                  armour2 = buyArmour;
                  break;
                } else {
                  System.out.println("You don't have enough money to buy this item!");
                  buyArmour = -1;
                }
              }
            } while (moveInShops == 3) { //lets you leave to the town
              moveAroundTown = 0;
              break; 
            }
          }
        }
        moveAroundTown = 0;
        i = canPlayerLeave(fighter1, fighter2, i);
        
      }

      System.out.println("AHHH");
    
          
      int minP1Sword = 0;
      int maxP1Sword = 5;
      int minP2Sword = 0;      
      int maxP2Sword = 5;

      //gives player 1's animal their stats and sword and gives player 2's animal their stats and sword
      
      
      var fighterName1 = (IFightable)listofanimals[fighter1];
      int attackValueP1 = fighterName1.attackPoints();
      int defenseValueP1 = fighterName1.defensePoints();
      int healthPointsP1 = fighterName1.health();
      int dodgePercentP1 = fighterName1.dodgePercent();

      var fighterName2 = (IFightable)listofanimals[fighter2];
      int attackValueP2 = fighterName2.attackPoints();
      int defenseValueP2 = fighterName2.defensePoints();
      int healthPointsP2 = fighterName2.health();
      int dodgePercentP2 = fighterName2.dodgePercent();


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

      if (sword1 == -1) {
        swordBroke[0] = true;
      } 

      if (sword2 == -1) {
        swordBroke[1] = true;
      }




      if (fighterName1.speed() < fighterName2.speed() && fighterName1.size() <  fighterName2.size()) { //if fighter2 is faster and smaller than fighter1
        dodgePercentP2 += fighterName2.speed() - fighterName1.speed() + 2;
      } else if (fighterName1.speed() > fighterName2.speed() && fighterName1.size() > fighterName2.size() ){ //if fighter1 is faster and smaller than fighter2
      dodgePercentP1 += fighterName1.speed() - fighterName2.speed();
      } else if (fighterName1.speed() < fighterName2.speed()) { //if fighter2 is faster than fighter1
      dodgePercentP2 += fighterName2.speed() - fighterName1.speed() - 2;
      } else if (fighterName1.speed() > fighterName2.speed()) { //if fighter1 is faster than fighter2
      dodgePercentP1 += fighterName1.speed() - fighterName2.speed() - 2;
      }

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


      if (trueOrFalse == 0) {
        isNight = false;
        System.out.println("It is daytime.");
      } else if (trueOrFalse == 1) {
        isNight = true;
        System.out.println("It is nighttime.");
      }

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

      
      if (dodgePercentP1 > 50) {
        dodgePercentP1 = 50;
      }

      if (dodgePercentP2 > 50) {
        dodgePercentP2 = 50;
      }

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

      if (fighterName1.stealth() > fighterName2.stealth()) {
        currentAttacker = 1;
      } else if (fighterName2.stealth() > fighterName1.stealth()) {
        currentAttacker = 0;
      } else {
        currentAttacker = random.nextInt(2);
      }

    
    while (healthPointsP1 > 0 && healthPointsP2 > 0) {
      while (currentAttacker % 2 != 0) {
        dodgeChance = random.nextInt(100);
        if (dodgeChance < dodgePercentP1) {
          System.out.println("Player 1's " + combatants[fighter1] + " attacked Player 2's " + combatants[fighter2] + ", but " + combatants[fighter2] + " dodged out of the way.");
        } else {

          if (healthPointsP1 > baseHealthP1 * 0.9) {
            damage = attackValueP1 - (defenseValueP2 / 2);
          } else if (healthPointsP1 > baseHealthP1 * 0.7) {
            damage = attackValueP1 - (defenseValueP2 / 2) + 5;
          } else if (healthPointsP1 > baseHealthP1 * 0.5 ) {
            damage = attackValueP1 - (defenseValueP2 / 2) - 2;
          } else if (healthPointsP1 > baseHealthP1 * 0.2 ) {
            damage = attackValueP1 - (defenseValueP2 / 2) - 7;
          }
          healthPointsP2 -= damage;
          System.out.println("Player 1's " + combatants[fighter1] + " attacks Player 2's " + combatants[fighter2] + " dealing " + damage + " damage.");
        }

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
        currentAttacker--;
      }
      while (currentAttacker % 2 == 0) {
        if (healthPointsP2 > 0) {
          dodgeChance = random.nextInt(100);
          if (dodgeChance < dodgePercentP2) {
            System.out.println("Player 2's " + combatants[fighter2] + " attacked Player 1's " + combatants[fighter1] + " ,but " + combatants[fighter1] + " dodged out of the way.");
          } else {
            if (healthPointsP1 > baseHealthP1 * 0.9) {
              damage = attackValueP1 - (defenseValueP1 / 2);
              System.out.println("A");
            } else if (healthPointsP1 > baseHealthP2 * 0.7) {
              damage = attackValueP1 - (defenseValueP1 / 2) + 5;
              System.out.println("B");
            } else if (healthPointsP1 > baseHealthP2 * 0.5 ) {
              damage = attackValueP1 - (defenseValueP1 / 2) - 2;
              System.out.println("C");
            } else if (healthPointsP1 > baseHealthP2 * 0.2) {
              damage = attackValueP1 - (defenseValueP1 / 2) - 7;
              System.out.println("D");
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
  
  
    if (fighter1 != -1) {
      System.out.println("Player 1 wins!");
    } else if (fighter2 != -1) {
      System.out.println("Player 2 wins!");
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
      chooseFighter = scanner.nextInt();
      switch (chooseFighter) { 
        case 1:
        chosenFighter = "Raccoon";
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
        default:
          return 4;
      }
    }
    for (int i = 0; i <= AL_AnimalsSize - 1; i++) {
      if (chosenFighter.equals(combatants[i])) {
        return i;
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

  public static int townMovement() {
    Scanner scanner = new Scanner (System.in);
    System.out.println("Where would you like to go?");
    System.out.println("1. Arivanya's Animals, an animal breeder.");
    System.out.println("2. Bothela's Animal Hospital, an animal healer.");
    System.out.println("3. Balimund's Forge, a weapon and armour seller.");
    System.out.println("4. Leave town, and head to the fight.");
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

  public static int canPlayerLeave(int fighter1, int fighter2, int i) {
    if (fighter1 == -1) {
      System.out.println("You must choose a fighter! Visit Arivanya's Animals to buy an animal.");
      i--;
    } else if (fighter2 == -1 && i == 2) {
      System.out.println("You must choose a fighter! Visit Arivanya's Animals to buy an animal.");
      i--;
    }
    else if (i == 1) {
      System.out.println("It is now player 2's turn to buy items.");
    } else if (i == 2) {
      System.out.println("It is now time to fight!");
    }
    return i;
  }
  
}


 //close class Main



