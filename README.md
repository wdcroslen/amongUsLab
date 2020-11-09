Comprehensive Lab for [CS 1101: Introduction to Computer Science Lab in Java] for Dr. Akbar's class at The University of Texas at El Paso (UTEP)
Semester: Fall 2020
-----------------------------------------------------------------------------

Objective: Students will practice using variables, methods, 2D-arrays, loops, and objects.

What is Among Us?

In the game of Among Us, crewmates are given tasks to complete around the map that are in forms of minigames. Imposters are given a fake list of tasks to blend in with Crewmates, although they are unable to complete any task. Imposters can sabotage tasks of users and kill crewmates. 
Crewmates win by completing tasks or successfully eliminating and identifying all imposters.
Imposters win by killing all crewmates or when a sabotage countdown reaches to 0.

Assignment Description

In this assignment, it will be done much simpler. The user will always play as a crewmate. Their job is to eliminate any player that they think is acting sus. 
When the game begins, the system will display a map that shows the coordinate of every player in the map. The following characters represent colors of the players:

[B] – Blue ------ [K] – Pink ------ [P] – Purple ------ [G] – Green ------ [O] – Orange

[Y] - Yellow ------ [W] – White ------ [C] – Cyan       [N] – Brown ------ [R] - Red

[/] – Represents Dead Crewmate in Map

When the game begins, the randomly chosen imposter will kill a crewmate. The program will display the letter of the color who died and their death coordinate. The user is supposed to analyze the map and either eject a color that is acting suspicious or simply skip if they are unsure. 
If the user successfully votes out the imposter, the game ends. Otherwise, the game continues until the user is left face to face with the imposter. If the imposter and user are the only ones left in the map, the game ends and the user loses the game.

-----------------------------------------------------------------------------

When the game begins, the program will ask the user the following:
	Enter a color you would like to play as:
1.	Blue
2.	Pink
3.	Purple
4.	Green
5.	Orange
6.	Yellow
7.	White
8.	Cyan
9.	Brown
10. Red

[user enters any number from the range of 1 – 10 to choose their preferred color]

Once the user chooses their preferred color, the system will display a map that shows the coordinate of every player on the map. The following figure shows an example of what the map should look like.

The user can either enter the letter of the color to vote them out or enter the letter [S] to skip the vote. If they vote out a color/skip, the program will either say: 0 imposters left (and win the game) OR 1 imposter remains (game continues if more than 2 players are left on the map).
The program will always randomize the coordinate of each color on the map, including the users. This will continue until the user successfully votes out the imposter or once the imposter and the user are the only ones left on the map.

HOW CAN I SOLVE THIS?

-----------------------------------------------------------------------------

You will need to create three different classes. The classes will have different attributes and methods included in them. [You may use this as a guide to help you].
Player

Attributes

> isImposter: A variable that will store true if chosen as the imposter, false otherwise (if crewmate).

> color: A variable that will store the letter of the color of the Player.

> coordinate: A variable that will store the coordinate of the Player.

Methods

> Player: The constructor of the Player class.

> getIsImposter: A getter method that will return true if the Player is an imposter, false otherwise.

> getColor: A getter method that will return the color of the Player.

> getCoordinate: A method that will return the Coordinate of the player.

--------------------------------------------------------------------------

COORDINATE

Attributes

> x: An integer that will store the x/row coordinate of the Player

> y: An integer that will store the y/col coordinate of the Player

Methods

> Coordinate: The constructor of the Coordinate class.

> getX: A getter method that will return the x/row coordinate of the Player

> getY: A getter method that will return the y/col coordinate of the Player

> generateCoordinate: A method that will randomly assign new x and y coordinates to the Player

--------------------------------------------------------------------------

GAME

[This class will contain your main method (you will test your game here)].

Attributes

> players: A variable that will store the Player objects in an array. There should be 10 Players in total.

> isGameOver: A variable that will store true if the game is over, false otherwise.

> map: A variable that will store the current state of the 2D-array map.

> chosenColor: A variable that will store the color the user chose at the start of the game.

Methods

> displayMap: This method will display the map that will contain the coordinate of each Player on the map.

> changeCoordinate: A method that will trigger the coordinate of each Player to change on the map.

> beginGame: A method that will display the main menu of the game. [NOTE: Where the user chooses their color].


> fillPlayer: A method that will fill the Player list and choose one imposter [NOTE: The user will never be chosen as an imposter].

> redrawMap: A method that will generate new coordinates of the Player on the map and update the map.
[NOTE: This will happen after the user either votes someone out or skips. Do not include dead crewmates].

> killCrewmate: This method will choose a new crewmate to kill.
[NOTE: Do not include users chosen color. User can not die].
