public abstract class Animal {

  private String _name;

  protected Animal() {
    this._name = "un-named";
  }

  protected Animal(String name) {
    this._name = name;
  }

  public String name() {
    return this._name;
  }

  public abstract String species();



  public String toString() {
    return String.format("Hi, I'm %s, a %s.", this.name(), this.species());
  }

  

}