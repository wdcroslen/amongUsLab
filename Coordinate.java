import java.util.Random;

class Coordinate {
  int x;
  int y;

  //Constructors
  Coordinate(){
    
  }

  Coordinate(int x, int y){
    this.x = x;
    this.y = y;
  }
  //Setters
  public void setX(int x){
    this.x = x;
  }
  public void setY(int y){
      this.y=y;
  }

  //Getters
  public int getX(){
    return this.x;
  }
  public int getY(){
    return this.y;
  }

  Coordinate generateCoordinate(){
    Random r = new Random();
    int x = r.nextInt(10);
    int y = r.nextInt(10);
    Coordinate c = new Coordinate(x,y);
    return c;
  }
}

