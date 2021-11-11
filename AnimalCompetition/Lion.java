public class Lion extends Animal implements IFightable, ISellable {

  public String species() {
    return "Lion";
  }

  public boolean canAttack() {
    return true;
  }

  public boolean canDefend() {
    return true;
  }

  public int health() {
    return 250;
  }

  public int attackPoints() {
    return 80;
  }

  public int defensePoints() {
    return 40;
  }

  public int price() {
    return 160;
  }

  public boolean isNocturnal() {
    return true;
  }

  public boolean isPredator() {
    return true;
  }

  public boolean isSoloHunter() {
    return true;
  }

  public int speed() {
    return 80;
  }

  public int size() {
    return 200;
  }

  public int dodgePercent() {
    return 20;
  }

  public int stealth() {
    return 9;
  }
  
  public int strength() {
    return 7;
  }
}