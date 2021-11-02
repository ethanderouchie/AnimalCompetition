public class DragonboneSword extends Swords implements ISellable {

  public String type() {
    return "Dragonbone Sword";
  }
  
  public int durability() {
    return 225;
  }

  public int price() {
    return 370;
  }

  public int damage() {
    return 85;
  }

  public int piercing() {
    return 17;
  }
}