public class Cat extends Animal implements IFightable, ISellable {

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
    return 4;
  }

  public int defensePoints() {
    return 7;
  }

  public int price() {
    return 70;
  }

  public boolean isNocturnal() {
    return false;
  }

  public boolean isPredator() {
    return true;
  }

  public boolean isSoloHunter() {
    return true;
  }

  public int speed() {
    return 48;
  }

  public double size() {
    return 0.41;
  }

}