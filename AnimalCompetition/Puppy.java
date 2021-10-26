public class Puppy extends Animal {
  public Puppy(String name) {
    super(name);
  }

  public String species() {
    return "Puppy";
  }

  public String toString() {
    return String.format("%s %s.", super.toString());
  }
}