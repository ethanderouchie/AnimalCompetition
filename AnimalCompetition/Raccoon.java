class Raccoon extends Animal implements IFightable {
  
  public Raccoon(String name) {
    super(name);
  }

  public String species() {
    return "Raccoon";
  }

  public boolean canAttack() {
    return true;
  }

  public boolean canDefend() {
    return true;
  }

  public String toString() {
    return String.format("%s %s.", super.toString(), "Raccoon");
  }
}