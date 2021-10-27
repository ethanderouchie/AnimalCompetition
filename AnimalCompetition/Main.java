import java.util.*;

class Main {
  public static void main(String[] args) {   
    System.out.println("Choose Your Fighter!");
    Scanner scanner = new Scanner (System.in); 
    String fighter1 = ""; 

    var listofanimals = new Animal[] {
      new Cat("Garfield"),
      new Dog("Fido"),
      new Raccoon("Panda"),
    };
    

    var animals = new ArrayList<>(Arrays.asList(listofanimals));
    



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
  
    }

  } //close main method

  

  
} //close class Main