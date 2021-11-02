public class SteelSword extends Swords implements ISellable {

  public String type() {
    return "Steel Sword";
  }

  public int durability() {
    return 45;
  }

  public int price() {
    return 80;
  }

  public int damage() {
    return 28;
  }

  public int piercing() {
    return 5;
  }
}