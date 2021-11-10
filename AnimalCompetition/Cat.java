public class Cat extends Animal implements IFightable, ISellable {

  public String species() {
    return "Cat";
  }

  public boolean canAttack() {
    return true;
  }

  public boolean canDefend() {
    return true;
  }

  public int health() {
    return 140;
  }

  public int attackPoints() {
    return 30;
  }

  public int defensePoints() {
    return 25;
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

  public int size() {
    return 41;
  }

  public int dodgePercent() {
    return 30;
  }

  public int stealth() {
    return 6;
  }

  public int strength() {
    return 5;
  }

}