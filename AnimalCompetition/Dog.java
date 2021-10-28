public class Dog extends Animal implements IFightable{
  public Dog(String name) {
    super(name);
  }

  public String species() {
    return "dog";
  }

  public boolean canAttack() {
    return true;
  }

  public boolean canDefend() {
    return true;
  }

  public int health() {
    return 70;
  }

  public int attackPoints() {
    return 18;
  }

  public int defensePoints() {
    return 8;
  }

  public String toString() {
    return String.format("%s", super.toString());
  }
}