public class Bear extends Animal implements IFightable, ISellable {

  public String species() {
    return "Bear";
  }

  public boolean canAttack() {
    return true;
  }

  public boolean canDefend() {
    return true;
  }

  public int health() {
    return 300;
  }

  public int attackPoints() {
    return 90;
  }

  public int defensePoints() {
    return 50;
  }

  public int price() {
    return 170;
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
    return 56;
  }

  public int size() {
    return 280;
  }

  public int dodgePercent() {
    return 10;
  }

  public int stealth() {
    return 5;
  }
  
  public int strength() {
    return 9;
  }
}