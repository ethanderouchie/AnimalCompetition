public abstract class Swords implements ISellable {

  public abstract String type();
  
  public abstract int durability();

  public abstract int damage();

  public abstract int piercing(); //influences how much extra durability damage armour takes when hit with a sword

}