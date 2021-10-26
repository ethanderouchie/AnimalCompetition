import java.util.*;

class Main {
  public static void main(String[] args) {   
    System.out.println("Choose Your Fighter!");
    Scanner scanner = new Scanner (System.in); 
    String fighter1 = ""; 
    
    var animals = new Animal[] { //adds all the animals to an array of animals
      new Cat("Tom"),
      new Dog("Fido"),
      new Raccoon("Panda"),
      new Puppy("Theo")
    };


    var fighters = new ArrayList<Animal>(); //creates an arraylist of AnimalData

    for (var animal: animals) { //adds the animals to the list of fighters
      fighters.add(animal);
    }

  
    for (var fighter: fighters) {
      if (fighter instanceof IFightable) {
        System.out.println("I'm a , and my name is. ");
        if (fighter.canAttack() = true) {
          System.out.println("i can attack");
        } else {
          System.out.println("i cant attack");
        }

        if (fighter.canDefend() = true) {
          System.out.println("I can defend.");
        } else {
          System.out.println("i cant defend");
        }
      } else {
        System.out.println("I'm a and my name is. I am not a fighter.");
      }
      
    }
      
    

    



    
  } //close main method

  

  
} //close class Main