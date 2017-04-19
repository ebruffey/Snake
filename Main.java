import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.Timer;

public class Main {
	
	static boolean startScreen;
	// allows for us to break out of the game loop
	static boolean alive = true;
	static EZText startText;
	// width and height of the board
	static int sWidth = 700;
	static int sHeight = 700;

	// size of the tiles, 20 pixels
	static int tileSize = 20;
	
	// total tiles on the board, comes out to 1225
	static int totalTiles = (sWidth * sHeight) / (tileSize * tileSize);
	
	//array for the tiles on the screen
		static EZRectangle [] boardTiles = new EZRectangle[totalTiles];
	// variables for the creation of the insanely slow for loop iteration of tile creation
	static int tileX = 10;
	static int tileY = 10;

	// variable to hold our snake object for manipulation
	static Snake snake;
	
//	private Timer timer;
//	private final int delay = 120;
	
	// function to grab the tile size for use in our other classes
	public static int getTileSize()  {
		return tileSize;
	}
	// to grab total # of tiles for use in our other functions
	public static int getAllTiles()  {
		return totalTiles;
	}
	// I think we need some sort of game initialization timer or something in order to move our snake 
	// without any previous input? i could be wrong
	private void initGame()  {
		
		long time = System.currentTimeMillis();
	}
	public static void main(String[] args) {

		// game board initialization
		EZ.initialize(sWidth, sHeight);
		EZ.setBackgroundColor(Color.BLUE);
		EZ.addRectangle(350, 350, sWidth, sHeight, Color.WHITE, false);
		// an extremely inefficient for loop to add the tiles to the screen
		for (int i = 0; i < boardTiles.length; i++) {

			boardTiles[i] = EZ.addRectangle(tileX, tileY, 20, 20, Color.WHITE, false);
			// checking if the center of the tile is = to the right edge of the
			// screen
			if (tileX == 690) {
				// if it is set set the tile X center back to 10
				tileX = 10;
				// increment tileY in order to make a new line
				tileY += 20;
			}
			//incrementing the x position of the tiles
			else {
				tileX += 20;
			}
		}
		
	//	snake = new Snake();
	//	snake.setJoints(3);
		
	//	timer = new Timer(delay);
// main loop while we are alive!
	while (alive = true)  {
		
		// creates our snake
		snake = new Snake();
		// initially we are moving right 
		snake.setMovingRight(true);
		// calls the move function so the snake moves
		//call here or call in the snake class?
		// still unsure
		snake.Move();
	/*	for (int i = 0; i < 3; i++)  {
			
			if (i == 0)  {
				EZ.addRectangle(snake.getSnakeX(i), snake.getSnakeY(i), tile, tile, Color.RED, true);
			} else  {
				EZ.addRectangle(snake.getSnakeX(i), snake.getSnakeY(i), tile, tile, Color.BLACK, true);
			}
		}
		
	/*	for (int i = 0; i < snake.getJoints(); i++)  {
			snake.setSnakeX(sWidth/2);
			snake.setSnakeY(sHeight/2);
		}
		*/
	//	Snake.setMovingRight(true);
		
//		Snake.Move();
		// if we press the d key and we are not moving left then we can move right
		// basically what we want is a way to track if we are moving in a specific direction
		// and if we are we cannot move in another specified direction.
		if (EZInteraction.wasKeyPressed('d') && (!snake.isMovingLeft()))  {
			//we set our booleans in order to keep track
			snake.setMovingRight(true);
			snake.setMovingUp(false);
			snake.setMovingDown(false);
		}
		
		if (EZInteraction.wasKeyPressed('a') && (!snake.isMovingRight()))  {
			snake.setMovingLeft(true);
			snake.setMovingUp(false);
			snake.setMovingDown(false);
		}
		
		if (EZInteraction.wasKeyPressed('w') && (!snake.isMovingDown()))  {
			snake.setMovingUp(true);
			snake.setMovingRight(false);
			snake.setMovingLeft(false);
		}
		
		if (EZInteraction.wasKeyPressed('s') && (!snake.isMovingUp()))  {
			snake.setMovingDown(true);
			snake.setMovingRight(false);
			snake.setMovingLeft(false);
		}
	
		
		EZ.refreshScreen();
	}
		
		
		/*
		while (alive = true) {

		int headX =	snakeArr[0].getXCenter();
		int headY = snakeArr[0].getYCenter();
			
			for (int i = 0; i < 5; i++) {

				snakeArr[i].Move(headX, headY);
			}
		}

		/*
		 * 
		 * startText = EZ.addText(375, 375, "Ready when you are", Color.BLACK,
		 * 50);
		 * 
		 * do {
		 * 
		 * if (EZInteraction.wasKeyPressed(KeyEvent.VK_ENTER)) {
		 * 
		 * EZ.removeEZElement(startText); startScreen = false;
		 * 
		 * alive = true; }
		 * 
		 * } while (startScreen = true);
		 * 
		 * while (alive = true) {
		 * 
		 * 
		 * }
		 */
	//	EZ.refreshScreen();
	}

}
