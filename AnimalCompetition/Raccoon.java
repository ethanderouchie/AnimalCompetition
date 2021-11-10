class Raccoon extends Animal implements IFightable, ISellable {
  

  public String species() {
    return "Raccoon";
  }

  public boolean canAttack() {
    return true;
  }

  public boolean canDefend() {
    return true;
  }

  public int health() {
    return 100;
  }

  public int attackPoints() {
    return 20;
  }

  public int defensePoints() {
    return 15;
  }

  public int price() {
    return 50;
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
    return 25;
  }

  public int size() {
    return 70;
  }

  public int dodgePercent() {
    return 40;
  }

}