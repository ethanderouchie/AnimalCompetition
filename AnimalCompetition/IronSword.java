public class IronSword extends Swords implements ISellable {

  public String type() {
    return "Iron Sword";
  }
  
  public int durability() {
    return 25;
  }

  public int price() {
    return 50;
  }

  public int damage() {
    return 17;
  }

  public int piercing() {
    return 2;
  }
}