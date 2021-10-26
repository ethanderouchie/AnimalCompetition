public class Dog extends Animal implements IFightable{
  public Dog(String name) {
    super(name);
  }

  public String species() {
    return "Dog";
  }

  public boolean canAttack() {
    return true;
  }

  public boolean canDefend() {
    return false;
  }

  public String toString() {
    return String.format("%s %s.", super.toString(), "Domesticated");
  }
}