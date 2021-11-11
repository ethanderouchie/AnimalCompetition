public interface IFightable {

  public boolean canAttack(); //asks if the animal can attack

  public boolean canDefend(); //asks if the animal can defend

  public int health(); //gets the animals health

  public int attackPoints(); //gets how much the animal attacks for

  public int defensePoints();//gets how much damage the animal deflects

  public int dodgePercent(); //gets the percentage that the animal can dodge

  public boolean isNocturnal(); //does the animal sleep at night or at day

  public boolean isPredator(); //is the animal a predator or prey

  public boolean isSoloHunter(); //does animal hunt solo or in a group

  public int speed(); //speed in km/h

  public int size(); //size in centimeters

  public int stealth(); //how stealthy an animal is from 1-9

  public int strength(); //how strong an animal is from 1-9
  
}