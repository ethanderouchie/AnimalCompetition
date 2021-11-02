public class Dog extends Animal implements IFightable, ISellable {
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
    return 6;
  }

  public int defensePoints() {
    return 3;
  }

  public int price() {
    return 80;
  }

  public String toString() {
    return String.format("%s", super.toString());
  }
}