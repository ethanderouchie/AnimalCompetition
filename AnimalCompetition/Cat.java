public class Cat extends Animal implements IFightable {

  public Cat(String name) {
    super(name);
  }

  public String species() {
    return "Cat";
  }

  public boolean canAttack() {
    return true;
  }

  public boolean canDefend() {
    return false;
  }


  public String toString() {
    return String.format("%s %s.", super.toString(), "Domesticated");
  }

}