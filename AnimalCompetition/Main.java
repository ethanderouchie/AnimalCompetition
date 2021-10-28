import java.util.*;

class Main {
  public static void main(String[] args) {   
    System.out.println("Choose Your Fighter!");
    Scanner scanner = new Scanner (System.in);
    int fighter1 = -1;
    int fighter2 = -1;
    int humanOrAI;
    boolean isFacingHuman = false;
    int animalCounter = 0;

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

    

    var listofanimals = new Animal[] {
      new Cat("Garfield"),
      new Dog("Fido"),
      new Raccoon("Panda"),
    };

    
    

    var animals = new ArrayList<>(Arrays.asList(listofanimals));

    int AL_AnimalsSize = animals.size();


    String combatants[] = new String[AL_AnimalsSize];
    
    for (var animal: animals) { //adds the animals to the list of fighters
      System.out.print(String.format("I'm a %s, and my name is %s. ", animal.species(), animal.name()));
      var fighter = (IFightable)animal;
      if (fighter.canAttack()) {
        System.out.print("I can attack. ");
      } else {
        System.out.print("i can't attack. ");
      }

      if (fighter.canDefend()) {
        System.out.print("I can defend.");
      } else {
        System.out.print("I can't defend.");
      }

      System.out.println(String.format("I have a health of %s.", fighter.health()));
      combatants[animalCounter] = animal.species();
      animalCounter++;

    }

    fighter1 = getPlayerChoice(combatants, AL_AnimalsSize);

    if (isFacingHuman != false) {
      fighter2 = getPlayerChoice(combatants, AL_AnimalsSize);
    } else {
      fighter2 = getAIChoice(combatants, AL_AnimalsSize);
    }

    

    

    


    
    

    

    






    

  } //close main method

  public static int getPlayerChoice(String combatants[], int AL_AnimalsSize) {
    Scanner scanner = new Scanner (System.in);
    String chosenFighter = "";
    System.out.println("What animal woud you like to be? Enter the animal's species to select them to be your fighter.");
    boolean isAFighter = false;
    while (isAFighter != true) {
      chosenFighter = scanner.nextLine();
      chosenFighter = chosenFighter.toLowerCase();
      for (int i = 0; i <= AL_AnimalsSize - 1; i++) {
        if (chosenFighter.equals(combatants[i])) {
          return i;
        }
      }
    }
    return -1;
  }

  public static int getAIChoice (String combatants[], int AL_AnimalsSize) {
    Random random = new Random();
    int chooseFighter;
    chooseFighter = random.nextInt(AL_AnimalsSize);

    return chooseFighter;

  }

  

  
} //close class Main