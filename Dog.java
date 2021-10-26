public class Dog extends Animal implements Abilities {
  public Dog(String name) {
    super(name);
  }

  public String species() {
    return "Dog";
  }


  public String toString() {
    return String.format("%s %s.", super.toString(), "Dog");
  }

  public String canJump() {
    return "Yes";
  }

  public String timeOfActivity() {
    return "Day";
  }
}