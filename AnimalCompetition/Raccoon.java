class Raccoon extends Animal {
  
  public Raccoon(String name) {
    super(name);
  }

  public String species() {
    return "Raccoon";
  }

  public String canJump() {
    return "Yes";
  }

  public String timeOfActivity() {
    return "Night";
  }

  public String toString() {
    return String.format("%s %s.", super.toString(), "Domesticated");
  }
}