public abstract class Armour implements ISellable {

  public abstract String type();
  
  public abstract boolean isHeavy();

  public abstract int durability();

  public abstract int protection();

  public abstract int hardness();
}