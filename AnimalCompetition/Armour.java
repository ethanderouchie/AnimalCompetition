public abstract class Armour implements ISellable {

  public abstract String type(); //type of armour (hide, iron, steel)
  
  public abstract boolean isHeavy(); //if the armour is heavy or not

  public abstract int durability(); //how durable the armour is

  public abstract int protection(); //how much the armour protects the animal

  public abstract int hardness(); //how much damage the armour inflicts on a sword
}