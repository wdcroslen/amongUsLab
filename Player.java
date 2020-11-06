
class Player {
  boolean isImposter;
  char color;
  Coordinate coordinate = new Coordinate();
  
  Player(){

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

  public boolean getIsImposter(){
    return this.isImposter;
  }

  public char getColor(){
    return this.color;
  }

  Coordinate getCoordinate(){
    return this.coordinate;
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