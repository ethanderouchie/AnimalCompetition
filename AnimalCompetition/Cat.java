public class Cat extends Animal implements Abilities {

  public Cat(String name) {
    super(name);
  }

  public String species() {
    return "Cat";
  }

  public String canJump() {
    return "Yes";
  }


  public String timeOfActivity() {
    return "Day";
  }

  public String toString() {
    return String.format("%s %s.", super.toString(), "Domesticated");
  }

}