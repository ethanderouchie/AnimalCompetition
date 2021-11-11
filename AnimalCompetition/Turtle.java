public class Turtle extends Animal implements IFightable, ISellable {

  public String species() {
    return "Turtle";
  }

  public boolean canAttack() {
    return true;
  }

  public boolean canDefend() {
    return true;
  }

  public int health() {
    return 110;
  }

  public int attackPoints() {
    return 25;
  }

  public int defensePoints() {
    return 75;
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
    return true;
  }

  public int speed() {
    return 6;
  }

  public int size() {
    return 36;
  }

  public int dodgePercent() {
    return 15;
  }

  public int stealth() {
    return 3;
  }
  
  public int strength() {
    return 3;
  }
}