import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.io.FileReader;

public class Main {

	private static boolean startScreen;
	// allows for us to break out of the game loop
	protected static boolean alive = true;
	static EZText startText;
	// width and height of the board
	private static int WIDTH = 800;
	private static int HEIGHT = 800;

	// size of the tile which is 10 pixels
	private static int tileSize = 10;
	// our starting x and y coordinates
	private static int xCoor = 40, yCoor = 40;

	// array list for our snake of type ezrectangle
	private static ArrayList<EZRectangle> snake = new ArrayList<EZRectangle>();
	// keeps track of how many pieces we have for our snake
	private static int joints = 3;
	// variable to hold the head of the snake
	private static EZRectangle head;
	
	// booleans to determine the direction we are moving
	private static boolean movingRight = true, movingLeft = false, movingUp = false, movingDown = false;
	// creating our apple object
	private static Apple apple;


	public static void main(String[] args) throws java.io.IOException {

		// game board initialization
		EZ.initialize(WIDTH, HEIGHT);
		EZ.setBackgroundColor(Color.BLUE);
		// grabbing the current time and storing it in the variable time
		long time = System.currentTimeMillis();

		// draws our grid lines
		for (int i = 0; i < WIDTH / 10 + 10; i++) {
			EZ.addLine(i * 10, 0, i * 10, HEIGHT + 10, Color.BLACK, 2);
			EZ.addLine(0, i * 10, WIDTH + 10, i * 10, Color.BLACK, 2);
		}
		// initializing the array list in order to add to our snake
		// for loop to create our snake
		// we have a variable joints in order to add to ur snake
		for (int i = 0; i < joints; i++) {
			// the head is at the 0 position in the array list and it is set to color red
			if (i == 0) {
				snake.add(EZ.addRectangle(xCoor, yCoor, tileSize, tileSize, Color.RED, true));
				// create our head variable in order to easily manipulate it later
				head = snake.get(0);
			}
			// adding the rest of the snake to the array list 
			snake.add(EZ.addRectangle(xCoor + 10, yCoor, tileSize, tileSize, Color.BLACK, true));
			
		}

		// creates our apple somewhere at a random location on the screen
		apple = new Apple();
	
		// main loop while we are alive!
		while (alive = true) {

			// sets our speed of the snake. we take the current time minus the
			// time we declared earlier.
			// subtract and determine if its greater than or equal to some
			// number
			if (System.currentTimeMillis() - time >= 60) {

				// we iterate through the snake, from the last occupied index in
				// the array list
				for (int i = joints; i > 0; i--) {
					// if i does not == 0, so basically any part of the snake
					// except the head
					if (!(i == 0)) {
						// then we get the index of the snake where we are in
						// our for loop
						// then we translate it to the next index in the array
						// list by getting i - 1
						// and by also getting the x and y centers
						snake.get(i).translateTo(snake.get(i - 1).getXCenter(), snake.get(i - 1).getYCenter());
					}
					// since our for loop doesnt iterate through 0 we still need
					// to track the head
					// so if i -1 == 0

					if (i - 1 == 0) {
						// if our boolean movingRight is true
						// same method for all directions
						if (movingRight == true) {
							// then we can translate the head by 10 pixels along the x axis
							head.translateBy(10f, 0f);
						}

						else if (movingLeft == true) {
							head.translateBy(-10f, 0f);
						}

						else if (movingUp == true) {
							head.translateBy(0f, -10f);
						}

						else if (movingDown == true) {
							head.translateBy(0f, 10f);
						}
						// time = System.currentTimeMillis();
					}

				}
				// reset our time variable to the current time in order to keep our snake moving at a steady rate
				time = System.currentTimeMillis();
			}

			// if we press one of the movement keys and we are going in the
			// direction opposite of the one we chose
			if (EZInteraction.wasKeyPressed('d') && (!movingLeft == true)) {
				// if (movingLeft = false) {
				// we set our booleans to their appropriate true or false
				// depending on which direction we are moving
				movingRight = true;
				movingUp = false;
				movingDown = false;
				movingLeft = false;
				// }
			}

			if (EZInteraction.wasKeyPressed('a') && (!movingRight == true)) {
				// if (movingRight = false) {
				movingLeft = true;
				movingUp = false;
				movingDown = false;
				movingRight = false;
				// }
			}

			if (EZInteraction.wasKeyPressed('w') && (!movingDown == true)) {
				// if (movingDown = false) {
				movingUp = true;
				movingDown = false;
				movingRight = false;
				movingLeft = false;
				// }
			}

			if (EZInteraction.wasKeyPressed('s') && (!movingUp == true)) {
				// if (movingUp = false) {
				movingDown = true;
				movingUp = false;
				movingLeft = false;
				movingRight = false;
				// }
			}
			// to determine if we collide with the wall
			// we grab the x and y center and determine if they equal the edges of the height and width
			if (head.getXCenter() == WIDTH || head.getYCenter() == HEIGHT || head.getXCenter() == 0
					|| head.getYCenter() == 0) {
				// if it does we remove all elements
				EZ.removeAllEZElements();
			}
			// to determine the collision with the apple
			// we decide if the heads x and y is within the boundary of the apples x and y
			if (head.isPointInElement(apple.getAppleX() - tileSize / 2, apple.getAppleY() - tileSize / 2)
					|| head.isPointInElement(apple.getAppleX() + tileSize / 2, apple.getAppleY() - tileSize / 2)
					|| head.isPointInElement(apple.getAppleX() - tileSize / 2, apple.getAppleY() + tileSize / 2)
					|| head.isPointInElement(apple.getAppleX() + tileSize / 2, apple.getAppleY() - tileSize / 2)) {
				// we increment joints in order to transfer the rectangle to the end of the arraylist
				joints++;
				// then we add another rectangle
				// still not sure how to add it directly to the end of the tail
				// adding it this way adds it to the original x coor and y coor then transfers it to where th tail is
				snake.add(EZ.addRectangle(xCoor, yCoor, tileSize, tileSize, Color.BLACK, true));
				// apple.t
			//	apple.ranLoc();
			}
			

			EZ.refreshScreen();
		}

	}

}
