public class EbonySword extends Swords implements ISellable {
  
  public String type() {
    return "Ebony Sword";
  }
  
  public int durability() {
    return 100;
  }

  public int price() {
    return 170;
  }

  public int damage() {
    return 45;
  }

  public int piercing() {
    return 10;
  }
}