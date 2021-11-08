public class SteelArmour extends Armour  implements ISellable {

  public String type() {
    return "Steel Armour";
  }

  public boolean isHeavy() {
    return true;
  }

  public int durability() {
    return 100;  
  }

  public int protection() {
    return 55;
  }

  public int hardness() {
    return 12;
  }

  public int price() {
    return 125;
  }
}