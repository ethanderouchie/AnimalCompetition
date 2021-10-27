import java.util.*;

class Main {
  public static void main(String[] args) {   
    System.out.println("Choose Your Fighter!");
    Scanner scanner = new Scanner (System.in);
    String fighter1 = ""; 
    int animalCounter = 0;

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
        System.out.println("I can defend.");
      } else {
        System.out.println("I can't defend.");
      }
      combatants[animalCounter] = animal.species();
      animalCounter++;

    }

    fighter1 = getPlayerChoice(combatants, AL_AnimalsSize);


    

  } //close main method

  public static String getPlayerChoice(String combatants[], int AL_AnimalsSize) {
    Scanner scanner = new Scanner (System.in);
    String chosenFighter = "";
    
    boolean isAFighter = false;
    while (isAFighter != true) {
      chosenFighter = scanner.nextLine();
      chosenFighter = chosenFighter.toLowerCase();
      for (int i = 0; i <= AL_AnimalsSize - 1; i++) {
        if (chosenFighter.equals(combatants[i])) {
          isAFighter = true;
        }
      }
    }
    return chosenFighter;
  }

  

  
} //close class Main