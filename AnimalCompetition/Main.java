import java.util.*;

class Main {
  public static void main(String[] args) {   
    Scanner scanner = new Scanner (System.in);
    Random random = new Random();
    //player1's animal and player2/AI's animal.
    int fighter1 = -1;
    int fighter2 = -1;
    //player1's sword and player2/AI's sword.
    int sword1 = -1;
    int sword2 = -1;
    //Starting money
    int player1money = 100;
    int player2money = 100;
    //lets program know if player1 wants to face a human or an ai
    int humanOrAI;
    boolean isFacingHuman = false;
    //counts animals and weapons
    int animalCounter = 0;
    int weaponCounter = 0;
    //navigate the town and the shops using numbers
    int moveAroundTown = 0;
    int moveInShops = 0;
    int f1swordDamage = 0;
    int f1swordDurability = 0;
    int f2swordDamage = 0;
    int f2swordDurability = 0;

    //finds if the user wants to face human or ai
    System.out.println("Are you facing a human or the AI?");
    while (true) {
      System.out.println("Type 1 for human, Type 2 for AI.");
      humanOrAI = scanner.nextInt();
      if (humanOrAI == 2) {
        break;
      }
      else if (humanOrAI == 1) {
        isFacingHuman = true;
        break;
      }
    } 
    
    //adds animal objects to an array
    var listofanimals = new Animal[] {
      new Cat(""),
      new Dog(""),
      new Raccoon("")
    };

    //adds sword objects to an array
    var listofswords = new Swords[] {
      new WoodSword(),
      new IronSword(),
      new SteelSword(),
      new EbonySword(),
      new DragonboneSword()
    };

    
    //adds the arrays to an ArrayList and gets the ArrayList size
    var animals = new ArrayList<>(Arrays.asList(listofanimals));
    var swords = new ArrayList<>(Arrays.asList(listofswords));

    int AL_AnimalsSize = animals.size();
    int AL_SwordsSize = swords.size();

    //gets an array  of what species the animals are
    String combatants[] = new String[AL_AnimalsSize];

    for (var animal: animals) {
      combatants[animalCounter] = animal.species();
      animalCounter++;
    }
    
    //gets an array of what type the weapons are
    String weapons[] = new String[AL_SwordsSize];

    for (var sword: swords) {
      weapons[weaponCounter] = sword.type();
      weaponCounter++;
    }



    
    for (int i = 1; i <= 2; i++) { //allows for each player to get a turn buying equipment each round
      while (moveAroundTown != 4) { //4 exits the town and lets player2 decide what to buy
        System.out.println("Where would you like to go?");
        System.out.println("1. Arivanya's Animals, an animal breeder.");
        System.out.println("2. Bothela's Animal Hospital, an animal healer.");
        System.out.println("3. Balimund's Forge, a weapon and armour seller.");
        System.out.println("4. Leave town, and head to the fight.");
        moveAroundTown = scanner.nextInt();
        
        //allows for all the operations of an animal store
        while (moveAroundTown == 1) { 
          System.out.println("Welcome to Arivanya's Animals. We have all sorts of animals for purchase. So what animal would you like to buy?");
          System.out.println("1. Animals");
          System.out.println("2. Leave Arivanya's");
          moveInShops = scanner.nextInt(); 
          if (moveInShops == 1) { 
            for (var animal: animals) { //prints all the animals and their stats
              System.out.print(String.format("I'm a %s. ", animal.species()));
              var fighter = (IFightable)animal;
              if (fighter.canAttack()) {
                System.out.print(String.format("I do %s damage. ", fighter.attackPoints()));
              } else {
                System.out.print("I can't attack. "); 
              }

              if (fighter.canDefend()) {
                System.out.print(String.format("I have %s defense. ", fighter.defensePoints()));
              } else {
                System.out.print("I can't defend. "); 
              }
                System.out.println(String.format("I have a health of %s.", fighter.health()));
              }

            //adds the animal to the fighter1 or fighter2 slot
            if (i == 1) {
              fighter1 = getPlayerChoice(combatants, AL_AnimalsSize);
            } else if (i == 2) {
              fighter2 = getPlayerChoice(combatants, AL_AnimalsSize);
            }
          } 
          else if (moveInShops == 2) { //Lets you go back out to the town
            moveAroundTown = 0;
          } 
        }


        while (moveAroundTown == 2) { //this will eventually allow you to heal your animals, right now kicks you out to the town
          moveAroundTown = 0;
        }
        //allows for all the operations of a blacksmith
        while (moveAroundTown == 3) { //enter blacksmith
          System.out.println("Welcome to Balimund's Forge! We have the finest weapons and armour. So what would you like to purchase?");
          System.out.println("1. Swords");
          System.out.println("2. Armour");
          System.out.println("3. Leave Balimund's");
          moveInShops = scanner.nextInt(); //pick what you want to do
          if (moveInShops == 1) { //buy swords
            for (var sword: swords) {
            System.out.println(String.format("%s, %s damage, %s durability, %s coins", sword.type(), sword.damage(), sword.durability(), sword.price()));
            }
            if (i == 1) {
              sword1 = getPlayerSword(weapons, AL_SwordsSize);
              System.out.println("You chose the " + weapons[sword1]);
            } else if (i == 2) {
              sword2 = getPlayerSword(weapons, AL_SwordsSize);
            }
            
          } else if (moveInShops == 2) { //armour is not available yet
            moveInShops = 0;
          } else if (moveInShops == 3) { //lets you leave to the town
            moveAroundTown = 0; 
          }
        }
      }
      moveAroundTown = 0;
      //instructs players so they know what to do
      if (i == 1) {
        System.out.println("It is now player 2's turn to buy items.");
      } else if (i == 2) {
        System.out.println("It is now time to fight!");
      }
    }      

    //gives player 1's animal their stats and sword and gives player 2's animal their stats and sword
    
    var fighterName1 = (IFightable)listofanimals[fighter1];
    int attackValueP1 = fighterName1.attackPoints();
    int defenseValueP1 = fighterName1.defensePoints();
    int healthPointsP1 = fighterName1.health();

    var fighterName2 = (IFightable)listofanimals[fighter2];
    int attackValueP2 = fighterName2.attackPoints();
    int defenseValueP2 = fighterName2.defensePoints();
    int healthPointsP2 = fighterName2.health();

    if (sword1 != -1) {
      var f1sword = listofswords[sword1];
      f1swordDamage = f1sword.damage();
      attackValueP1 += f1swordDamage;
      f1swordDurability = f1sword.durability();
    }

    if (sword2 != -1) {
      var f2sword = listofswords[sword2];
      f2swordDamage = f2sword.damage();
      attackValueP2 += f2swordDamage;
      f2swordDurability = f2sword.durability();
      System.out.println(f2swordDamage);
    }


    

    int minP2Armour = 0;
    int maxP2Armour = 5;
    int minP1Armour = 0;
    int maxP1Armour = 5;

    boolean p1SwordBroke = false;
    boolean p2SwordBroke = false;
    if (sword1 == -1) {
      p1SwordBroke = true;
    }

    if (sword2 == -1) {
      p2SwordBroke = true;
    }



    

    //fights the animals
    while (healthPointsP1 > 0 && healthPointsP2 > 0) {
      healthPointsP2 = healthPointsP2 - (attackValueP1 - (defenseValueP2 / 2));
      System.out.println("Player 1's " + combatants[fighter1] + " attacks Player 2's " + combatants[fighter2]);
      if (p1SwordBroke != true) {
        if (sword1 != -1) {
          f1swordDurability -= random.nextInt(maxP2Armour - minP2Armour) + minP1Armour;
          if (f1swordDurability < 1) {
            attackValueP1 -= f1swordDamage;
            System.out.println("Player 1's sword has broken.");
            p1SwordBroke = true;
          }
        }
      }
      if (healthPointsP2 > 0) {
        System.out.println("Player 2's " + combatants[fighter2] + " attacks Player 1's "+ combatants[fighter1]);
        healthPointsP1 = healthPointsP1 - (attackValueP2 - (defenseValueP1 / 2));
        if (p2SwordBroke != true) {
          if (sword2 != -1) {
            f2swordDurability -= random.nextInt(maxP1Armour - minP1Armour) + minP1Armour;
            if (f2swordDurability < 1) {
              attackValueP2 -= f2swordDamage;
              System.out.println("Player 2's sword has broken.");
              p2SwordBroke = true;
            }
          }
        }

      }
    }

    //prints who won the fight
    if (healthPointsP1 < 1) {
      System.out.println("Player 2 wins!");

    } else if (healthPointsP2 < 1) {
      System.out.println("Player 1 wins!");
    }

  } //close main method

  public static int getPlayerChoice(String combatants[], int AL_AnimalsSize) {
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
        chosenFighter = "cat";
        isAFighter = true;
        break;
        case 2:
          chosenFighter = "dog";
          isAFighter = true;
          break;
        case 3:
          chosenFighter = "raccoon";
          isAFighter = true;
          break;
        default:
          chosenFighter = "";
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
          chosenSword = "";
      }
    }
    for (int i = 0; i <= AL_SwordsSize - 1; i++) {
      if (chosenSword.equals(weapons[i])) {
        return i;
      }
    }
    return -1;
  }







   

    
  




  

  
} //close class Main