public class Cat extends Animal implements IFightable {

  public Cat(String name) {
    super(name);
  }

  public String species() {
    return "cat";
  }

  public boolean canAttack() {
    return true;
  }

  public boolean canDefend() {
    return true;
  }


  public String toString() {
    return String.format("%s %s.", super.toString(), "Cat");
  }

}