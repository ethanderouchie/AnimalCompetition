public class EbonyArmour extends Armour implements ISellable {

  public String type() {
    return "Ebony Armour";
  }
  
  public boolean isHeavy() {
    return true;
  }

  public int durability() {
    return 200;  
  }

  public int protection() {
    return 75;
  }

  public int hardness() {
    return 17;
  }

  public int price() {
    return 220;
  }
}