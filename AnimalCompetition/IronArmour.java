public class IronArmour extends Armour implements ISellable {

  public String type() {
    return "Iron Armour";
  }

  public boolean isHeavy() {
    return false;
  }

  public int durability() {
    return 50;  
  }

  public int protection() {
    return 30;
  }

  public int hardness() {
    return 5;
  }

  public int price() {
    return 85;
  }
}