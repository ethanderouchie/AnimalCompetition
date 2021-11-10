public interface IFightable {

  public boolean canAttack();

  public boolean canDefend();

  public int health();

  public int attackPoints();

  public int defensePoints();

  public int dodgePercent();

  public boolean isNocturnal(); //does the animal sleep at night or at day

  public boolean isPredator(); //is the animal a predator or prey

  public boolean isSoloHunter(); //does animal hunt solo or in a group

  public int speed(); //speed in km/h

  public int size(); //size in centimeters

  public int stealth();

  public int strength();
  
}