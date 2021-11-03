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
    return 35;
  }

  public int attackPoints() {
    return 5;
  }

  public int defensePoints() {
    return 5;
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

  public double size() {
    return 0.70;
  }

}