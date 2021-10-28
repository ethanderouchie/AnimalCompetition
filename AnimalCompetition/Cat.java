public class Cat extends Animal implements IFightable {

  public Cat(String name) {
    super(name);
  }

  public String species() {
    return "cat";
  }

  public boolean canAttack() {
    return true;
  }

  public boolean canDefend() {
    return true;
  }

  public int health() {
    return 50;
  }

  public int attackPoints() {
    return 15;
  }

  public int defensePoints() {
    return 10;
  }


  public String toString() {
    return String.format("%s", super.toString());
  }

}