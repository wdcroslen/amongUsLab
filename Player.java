
class Player {
  private boolean isImposter;
  private boolean isDead;
  private char color;
  private Coordinate coordinate;
  
  Player(char color, boolean isImposter, boolean isDead){
	  this.color = color;
	  this.isImposter = isImposter;
	  this.isDead = isDead;
	  coordinate = new Coordinate();
  }
  
  //These should be private but I'll leave it public for if we don't teach them encapsulation
  public void setCoordinate(Coordinate location){
    this.coordinate = location;
  }
  public void setColor(char color){
    this.color = color;
  }
  public void setIsImposter(boolean isImposter){
    this.isImposter = isImposter;
  }
  public void setIsDead(boolean isDead) {
	  this.isDead = isDead;
  }

  public boolean getIsImposter(){
    return this.isImposter;
  }

  public char getColor(){
    return this.color;
  }

  public Coordinate getCoordinate(){
    return this.coordinate;
  }
  
  public boolean getIsDead() {
	  return this.isDead;
  }

}

// Attributes
// > isImposter: A variable that will store true if chosen as the imposter, false otherwise (if crewmate).
// > color: A variable that will store the letter of the color of the crewmate/imposter.
// > location: A variable that will store the coordinate/location of the crewmate/imposter.
// Methods
// > Crewmate: The constructor of the Crewmate class.
// > getIsImposter: A getter method that will return true if the crewmate is an imposter, false otherwise.
// > getColor: A getter method that will return the color of the crewmate/imposter.
// > getLocation: A method that will return the location of a crewmate/imposter.