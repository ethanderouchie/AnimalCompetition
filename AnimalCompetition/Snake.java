public class Snake extends Animal implements IFightable, ISellable {

  public String species() {
    return "Snake";
  }

  public boolean canAttack() {
    return true;
  }

  public boolean canDefend() {
    return true;
  }

  public int health() {
    return 90;
  }

  public int attackPoints() {
    return 55;
  }

  public int defensePoints() {
    return 20;
  }

  public int price() {
    return 100;
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
    return 29;
  }

  public int size() {
    return 300;
  }

  public int dodgePercent() {
    return 30;
  }

  public int stealth() {
    return 7;
  }
  
  public int strength() {
    return 4;
  }
}