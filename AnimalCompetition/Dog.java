public class Dog extends Animal implements IFightable, ISellable {

  public String species() {
    return "Dog";
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
    return 10;
  }

  public int defensePoints() {
    return 3;
  }

  public int price() {
    return 80;
  }

  public boolean isNocturnal() {
    return false;
  }

  public boolean isPredator() {
    return true;
  }

  public boolean isSoloHunter() {
    return false;
  }

  public int speed() {
    return 37;
  }

  public int size() {
    return 107;
  }

  public int dodgePercent() {
    return 25;
  }
  
}