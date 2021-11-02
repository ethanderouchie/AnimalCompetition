public class HideArmour extends Armour implements ISellable {

  public String type() {
    return "Hide Armour";
  }

  public boolean isHeavy() {
    return false;
  }

  public int durability() {
    return 25;  
  }

  public int protection() {
    return 10;
  }

  public int hardness() {
    return 0;
  }

  public int price() {
    return 50;
  }
}