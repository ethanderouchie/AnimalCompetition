class Raccoon extends Animal implements IFightable {
  
  public Raccoon(String name) {
    super(name);
  }

  public String species() {
    return "raccoon";
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
    return 10;
  }

  public int defensePoints() {
    return 20;
  }

  public String toString() {
    return String.format("%s", super.toString());
  }
}