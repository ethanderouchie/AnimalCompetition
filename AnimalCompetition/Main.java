import java.util.*;

class Main {
  public static void main(String[] args) {   
    System.out.println("Choose Your Fighter!");
    Scanner scanner = new Scanner (System.in); 
    String fighter1 = ""; 
    
    var animals = new Animal[] { //adds all the animals to an array of animals
      new Cat("Tom"),
      new Dog("Fido"),
      new Raccoon("Panda")
    };


    var datas = new ArrayList<Animal>(); //creates an arraylist of AnimalData
    var fighters = new ArrayList<Abilities>(); //creates an arraylist of Abilities

    for (var animal: animals) { //adds the animals to the list of fighters
      datas.add(animal);
      fighters.add((Abilities)animal);
    }

    for (var fighter: fighters) { //prints species, name, and abilities
      for (var data: datas) {
        System.out.println(String.format("I am a %s, and I am named %s. My abilities are: Jumping: %s, Active: %s.", data.species(), data.name(), fighter.canJump(), fighter.timeOfActivity()));
      }
      break;
    } 

    



    
  } //close main method

  

  
} //close class Main