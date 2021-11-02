public class DaedricArmour extends Armour implements ISellable {

  public String type() {
    return "Daedric Armour";
  }

  public boolean isHeavy() {
    return true;
  }

  public int durability() {
    return 270;  
  }

  public int protection() {
    return 100;
  }

  public int hardness() {
    return 25;
  }

  public int price() {
    return 500;
  }
}