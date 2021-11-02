public class WoodSword extends Swords implements ISellable {
  

  public String type() {
    return "Wooden Sword";
  }
  
  public int durability() {
    return 15;
  }

  public int price() {
    return 20;
  }

  public int damage() {
    return 10;
  }



  
}