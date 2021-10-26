import java.util.*;

class Main {
  public static void main(String[] args) {   
    Scanner scanner = new Scanner (System.in); 
    String fighter1 = ""; 
    System.out.println("CHOOSE YOUR FIGHTER!");
    
    var animals = new Animal[] { //adds all the animals to an array of animals
      new Cat("Tom"),
      new Dog("Fido"),
      new Raccoon("Panda")
    };

    var fighters = new ArrayList<Abilities>(); //creates an arraylist of fighters

    for (var animal: animals) { //adds the animals to the list of fighters
      if (animal instanceof Abilities) {
        fighters.add((Abilities)animal);
      }
    }

    for (var fighter: fighters) { //prints species, name, and abilities
      System.out.println(String.format("Jumping: %s, Active: %s.", fighter.canJump(), fighter.timeOfActivity()));
    } 

    fighter1 = scanner.nextLine();


    
  } //close main method

  

  
} //close class Main