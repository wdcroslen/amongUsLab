import java.util.*;
import java.util.concurrent.TimeUnit;

class Game {
	public static void main(String[] args) throws InterruptedException{
		Game amongUs = new Game();
		amongUs.beginGame();
	}

	//Values that are global to the Game Class
	boolean isGameOver = false;
	boolean firstRound = true;
	char[] colors = {'B','K','P','G','O','Y','W','C','N','R'};
	
	Player[] players = new Player[10];
	char userColor;
	char imposterColor;
	char[][] board = new char[10][10];
	
	//Variable holding the color chosen through the menu
	int choice = 0;
	
	//Variable holding the number of living crewmates left in the map
	int numOfRemainingPlayers = 10;
	
	//Variable that holds the character value of a color in colors
	char sus;
	
	//Variable that will hold the coordinate of the deadCrewmate to display
	int deadCrewmate = 0;
	

	/* The method displayBoard traverses through the board and displays the map */
	public void displayBoard(){
		System.out.println("  0 1 2 3 4 5 6 7 8 9");
		for(int i =0;i<this.board.length; i++){
			System.out.print(i + " ");
			for(int j = 0;j<this.board.length; j++){
				
				if (board[i][j] != '-'){
					for(int k = 0;k<this.players.length; k++){
						if (players[k].getColor() == board[i][j]){
							if (players[k].getIsDead()){
								System.out.print("- ");
							}
							else{
								System.out.print(board[i][j] + " ");
							}
						}
					}
				}
				else{
					System.out.print(board[i][j] + " ");
				}
			}
			System.out.println();
		}
	}

	/* The method changes the coordinates of every single player located on the map */
	public void changeCoordinates(){
		//instantiate a coordinate class
		Coordinate changedCoordinate;
		for (int i =0; i < this.players.length;i++){
			changedCoordinate = new Coordinate();
			this.players[i].setCoordinate(changedCoordinate.generateCoordinate());
		}
	}

	/* The method begins the game by asking the user to select which color they would like to play as. */
	public void beginGame() throws InterruptedException{
		Scanner scnr = new Scanner(System.in);
		Scanner ejectPlayer = new Scanner(System.in);
		String temp;
		
		System.out.println("Hello User Welcome to Among Us!");
		System.out.print("\nEnter a color you would like to play as:\n1. Blue\n2. Pink\n"
				+"3. Purple\n4. Green\n5. Orange\n6. Yellow\n7. White\n8. Cyan\n9. Brown\n10. Red\n> ");

		//Verify that the users input is in the range of 1-10
		choice = scnr.nextInt();
		if (choice < 1 || choice > 10){
			System.out.println("Please choose an option between 1-10.");
			System.exit(1);
		}


		this.userColor = colors[choice-1];
		
		//COUNTS DOWN TO BEGIN GAME
		printWithDelays("54321", TimeUnit.MILLISECONDS,1000);
		
		//Fill Players
		this.fillCrewmates();
		
		//The game repeats until either: the imposter is successfully identified and ejected or the player size is 2
		while(!isGameOver) {
			if(this.numOfRemainingPlayers == 2) {
				System.out.println("DEFEAT\n"+this.imposterColor+" won.");
				isGameOver = true;
			}
			else {
				System.out.println("\n------- POLLUS MAP -------\n");
			
				this.killCrewmate();
				this.createMap();
				this.fillBoard();
				this.displayBoard();
			
				System.out.println("Your color is: " + this.userColor);
				System.out.println("Your location is in: "+ displayCoordinate(this.players[choice-1].getCoordinate()));
			
				//Display the crewmate that was just killed
				System.out.println(this.players[deadCrewmate].getColor() + " died in: "+ displayCoordinate(players[deadCrewmate].getCoordinate()));
				System.out.println("[DEBUG RESULTS] IMPOSTER COLOR: "+this.imposterColor);
				
				System.out.print("\n____ is acting sus: [Enter character value](enter to skip)\n> ");
				temp = ejectPlayer.nextLine();
				if (!temp.equals("")){
					sus = Character.toUpperCase(temp.charAt(0));
					eject(sus);
				}//TODO: Fix -- Imposter and Player can die
				
				//Call the eject method
				
			}
			firstRound = false;
		}
	}//end beginGame

	/* The method randomly selects a color as an imposter (excluding the user*/
	public void fillCrewmates(){
		Random r = new Random();
		int imposter = 0;

		// Generate a new imposter IF the user is selected as imposter
		do {
			//Generates a random number between 0-9
			imposter = r.nextInt(10);
		}while(colors[imposter] == this.userColor);

		//Instantiate a player object in each position of the players array
		for (int i =0; i < this.players.length;i++){
			this.players[i] = new Player(colors[i],false,false);
		}

		//Set values for the color chosen as imposter
		this.players[imposter].setIsImposter(true);
		this.imposterColor = this.players[imposter].getColor();
	}

	public void fillBoard(){
		//Coordinate class that stores random chosen coordinates
		Coordinate [] generated = new Coordinate[10];
		Coordinate nc = new Coordinate();
		
		
		for (int q = 0; q<generated.length; q++){
			generated[q] = nc;
		}
		
		
		
		//instantiate a coordinate class
		
		int x;
		int y;
		boolean br; 
		boolean different;
		for (int i=0; i < this.players.length;i++){
			different = false;
			//nc = (1,2)  == (0,1)
			//[(0,1),(1,2),(3,4)]
		
			while (!different){
				br = false;
				//boolean that tells us if we broke out of inner loop
				nc = nc.generateCoordinate();
				for (int j = 0; j<generated.length; j++){
					if (generated[j].getX()==nc.getX() && generated[j].getY() == nc.getY()){
						br = true;
						break;
					}
				}
				if (!br){ // if we didn't break 
					different = true;
				}
			}
			
			generated[i] = nc;

			this.players[i].setCoordinate(nc);
			
			/*NOTE we should probably give students the code to make sure there are no overlapping coordinates*/
			
			//Placing players on the 2D array board
			x = this.players[i].getCoordinate().getX();
			y = this.players[i].getCoordinate().getY();
			this.board[y][x] = this.players[i].getColor();
		}
	}

	/* The method filles the boar map with dashed values */
	public void createMap(){
		for(int i=0;i<this.board.length; i++){
			for(int j=0;j<this.board.length; j++){
				board[i][j] = '-';
			}
		}
	}
	
	/* The method kills a crewmate and changes the value: isDead of the crewmate 
	 * to true, and changes the color value to /: representing the death. */
	public void killCrewmate() {
		Random r = new Random();
		//Continue to generate a new crewmate to kill if the deadCrewmates' value [isDead] is true
		if( firstRound ) {
			deadCrewmate = r.nextInt(10);
		} else{
			do {
				deadCrewmate = r.nextInt(10);
			}while( players[deadCrewmate].getIsDead() );
		}
		
		//Set deadCrewmate's isDead value to TRUE
		this.players[deadCrewmate].setIsDead(true);
		this.colors[deadCrewmate] = '/';
	}
	
	/* The method displays the coordinate of the user and the dead crewmate */
	public String displayCoordinate(Coordinate c) {
		return "(" + c.getX() + ", " + c.getY() + ")";
	}
	
	/* The metnod printWithDelays delays the start time when the user begins the game*/
	public void printWithDelays(String data, TimeUnit unit, long delay) throws InterruptedException {
		unit.sleep(delay);
		System.out.println("\nREADY?");
//		unit.sleep(delay);
//	    for (char ch : data.toCharArray()) {
//	        System.out.println(ch);
//	        unit.sleep(delay);
//	    }
	}
	
	/* Eject crewmate */
	public void eject(char c) {
		boolean found = false;
		while(!found) {
			for(int i = 0; i < this.players.length; i++) {
				//If sus char found
				if(players[i].getColor() == c) {
					if( this.players[i].getIsDead() ) {
						System.out.println("Player was either already ejected or is dead");
					}
					else {
						//Make sure to assign true to isDead 
						this.players[i].setIsDead(true);
						if(this.players[i].getIsImposter()) {
							System.out.println("\n" + c + " was the imposter.\n0 imposters remain.\nVICTORY!");
							isGameOver = true;
						}
						else {
							System.out.println("\n" + c + " was not the imposter.\n1 imposter remains.");
						}
					}
					found = true;
				}
			}
		}
		this.numOfRemainingPlayers--;
	}//end eject method
	
}
