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
    return 3;
  }

  public int defensePoints() {
    return 5;
  }

  public int price() {
    return 50;
  }

  public String toString() {
    return String.format("%s", super.toString());
  }


}