import java.awt.Color;
import java.awt.event.KeyEvent;

public class Main {
	
	static boolean startScreen;
	static boolean alive;
	static EZText startText;
	static int sWidth = 700;
	static int sHeight = 700;
	//array for the tiles on the screen
	static EZRectangle [] boardTiles = new EZRectangle[1225];
	static int tileX = 10;
	static int tileY = 10;
	static int cX = 350;
	static int cY = 350;
	
	static Snake snake;
	static Snake snakeHead;
	
	
	public static void main(String[] args) {

		// game board initialization
		EZ.initialize(sWidth, sHeight);
		EZ.setBackgroundColor(Color.BLUE);
		EZ.addRectangle(cX, cY, sWidth, sHeight, Color.WHITE, false);
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
		
		snake = new Snake(cX, cY);
			
	while (alive = true)  {
		
		snake.Move();
		
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
