import java.util.*;
class Game {
  public static void main(String[] args) {
    Game amongUs = new Game();
    amongUs.beginGame();
  }
  boolean isGameOver;
  Player[] players = new Player[10];
  char userColor;
  char imposterColor;
  char[][] board = new char[10][10];

  public void displayBoard(){
    for(int i =0;i<this.board.length; i++){
      System.out.print(i + " ");
      for(int j = 0;j<this.board.length; j++){
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }
  }

  public void changeCoordinates(){
    for (int i =0; i < this.players.length;i++){
      Coordinate nc = new Coordinate();
      this.players[i].coordinate = nc.generateCoordinate();
    }
  }

  public void beginGame(){
    char[] colors = {'B','K','P','G','O','Y','W','C','N','R'};
    Scanner scnr = new Scanner(System.in);
    System.out.println("Hello User Welcome to Among Us!");
    System.out.println("Enter a color you would like to play as:\n1.Blue\n2.Pink\n3.Purple\n4.Green\n5.Orange\n6.Yellow\n7.White\n8.Cyan\n9.Brown\n10.Red");
    int choice = scnr.nextInt();
    if (choice <1 || choice > 10){
      System.out.println("WRONG");
      System.exit(1);
    }
    this.userColor = colors[choice-1];
    System.out.println("Your color is: " + this.userColor);
    System.out.println("Here is the map.");
    this.fillCrewmates();
    this.createMap();
    this.fillBoard();
    this.displayBoard();
    System.out.println(this.imposterColor);
  }

  
  public void fillCrewmates(){
    char[] colors = {'B','K','P','G','O','Y','W','C','N','R'};
    Random r = new Random();
    int imposter = r.nextInt(9);
    if (colors[imposter] == this.userColor){
      fillCrewmates();
      System.exit(0);
    }
    for (int i =0; i < this.players.length;i++){
      Player p = new Player();
      p.color = colors[i];
      p.isImposter = false;
      this.players[i] = p;
    }
    this.players[imposter].isImposter = true;
    this.imposterColor = this.players[imposter].color;
    System.out.println("IMPOSTER COLOR: " + this.imposterColor);
  }

  public void fillBoard(){
    for (int i=0; i < this.players.length;i++){
      Coordinate nc = new Coordinate();
      this.players[i].coordinate = nc.generateCoordinate();
      /*NOTE we should probably give students the code to make sure there are no overlapping coordinates*/
      int x = this.players[i].coordinate.getX();
      int y = this.players[i].coordinate.getY();
      this.board[y][x] = this.players[i].color;
    }
  }

  public void createMap(){
    for(int i=0;i<this.board.length; i++){
      for(int j=0;j<this.board.length; j++){
        board[i][j] = '_';
      }
    }
  }
}


//   CrewM
//  ttributes
// > crewmates: A variable that will store the Crewmate objects in an array. There should be 10 Crewmates in total.
// > isGameOver: A variable that will store true if the game is over, false otherwise.
// Methods
// > createMap: This method will create the map that will contain the location of each color/crewmate on the map.
// > changeLocation: A method that will trigger the location of each color/crewmate to change on the map.
// > beginGame: A method that will display the main menu of the game. [Where the user chooses their color].
// > fillCrewmates: A method that will fill the crewmates list and choose one imposter among all 10 colors [excluding the user].
