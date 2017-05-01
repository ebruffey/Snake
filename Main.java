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

	// size of the tiles, 20 pixelswidth
	private static int tileSize = 10;
	private static int xCoor = 40, yCoor = 40;
	// total tiles on the board, comes out to 1225
	private static int totalTiles = (WIDTH * HEIGHT) / (tileSize * tileSize);
	
	//array for the tiles on the screen
	private	static EZRectangle [] boardTiles = new EZRectangle[totalTiles];
	// variables for the creation of the insanely slow for loop iteration of tile creation
	private static int tileX = 10;
	private static int tileY = 10;

	private static ArrayList <EZRectangle> snake = new ArrayList<EZRectangle>();
	private static int joints = 5;
	private static EZRectangle head;
	// variable to hold our snake object for manipulation
	
	private static boolean movingRight = true, movingLeft = false, movingUp = false, movingDown = false;
	/*
	protected static ArrayList <Snake> snake;
	protected static Snake bodyParts;
	*/
	static Apple apple;
	
//	private Timer timer;
//	private final int delay = 120;
	
	// function to grab the tile size for use in our other classes
	public static int getTileSize()  {
		return tileSize;
	}
	// to grab total # of tiles for use in our other classes
	public static int getAllTiles()  {
		return totalTiles;
	}
	
	public static EZRectangle getTile(int x, int y)  {
		return boardTiles[y * 35 + x];
	}
	
	public static boolean isMovingRight()  {
		return movingRight;
	}
	
	public static boolean isMovingLeft()  {
		return movingLeft;
	}
	
	public static boolean isMovingUp()  {
		return movingUp;
	}
	
	public static boolean isMovingDown()  {
		return movingDown;
	}
	
//	public void boolean setMovingRight(boolean movingRight)  {
	//	this.movingRight = movingRight;
//	}
	// I think we need some sort of game initialization timer or something in order to move our snake 
	// without any previous input? i could be wrong
/*	private static void initGame()  {
		
		long time = System.currentTimeMillis();
	}
	*/
	public static void main(String[] args) throws java.io.IOException {

		// game board initialization
		EZ.initialize(WIDTH, HEIGHT);
		EZ.setBackgroundColor(Color.BLUE);
		
		long time = System.currentTimeMillis();
	
	// draws our grid lines
		for (int i = 0; i < WIDTH / 10 + 10; i++)  {
			EZ.addLine(i * 10, 0, i * 10, HEIGHT + 10, Color.BLACK, 2);
			EZ.addLine(0, i * 10, WIDTH + 10, i * 10, Color.BLACK, 2);
		}
		// initializing the array list in order to add to our snake
		
		for (int i = 0; i < joints; i++)  {
			if (i == 0)  {
			snake.add(EZ.addRectangle(WIDTH/2 - 5, HEIGHT/2 - 5, tileSize, tileSize, Color.RED, true));
			
			head = snake.get(0);
		}
				snake.add(EZ.addRectangle(WIDTH/2 - 15, HEIGHT/2 - 5, tileSize, tileSize, Color.BLACK, true));
			WIDTH -= 10;
		}
		
		/*
		snake = new ArrayList <Snake>();
		// we create a body part if there is nothing in the array
		if (snake.size() == 0)  {
			// at these specified x and y and this specified size of 10
			bodyParts = new Snake (xCoor, yCoor, 10);
			snake.add(bodyParts);
			snake.add(bodyParts);
			snake.add(bodyParts);
		}
		// drawing our snake to the board 
		for (int i = 0; i < 3; i++)  {
			snake.get(i).draw();
		}
		*/
		// creates our apple somewhere at a random location on the screen
		apple = new Apple();
		// creates the snake
	//	snake = new Snake();
	//	apple.spawnApple();
		
	//	snake = new Snake();
	//	snake.setJoints(3);
		
	//	timer = new Timer(delay);
// main loop while we are alive!
	while (alive = true)  {
		
		// sets our speed of the snake. we take the current time minus the time we declared earlier.
		// subtract and determine if its greater than or equal to some number
		if (System.currentTimeMillis() - time >= 40)  {
	// we iterate through the snake, from the last occupied index in the array list
			for (int i = joints; i > 0; i--)  {
				// if i does not == 0, so basically any part of the snake except the head
				if (!(i == 0))  {
					// then we get the index of the snake where we are in our for loop
					// then we translate it to the next index in the array list by getting i - 1 
					// and by also getting the x and y centers
					snake.get(i).translateTo(snake.get(i-1).getXCenter(), snake.get(i-1).getYCenter());
				}
				// since our for loop doesnt iterate through 0 we still need to track the head
				// so if i -1 == 0
				if (i - 1 == 0)  {
					// also if our boolean movingRight is true
					if (movingRight = true)  {
						// then we can translate the head by 10 pixels along the x axis
						head.translateBy(10, 0);
					}
					
					else if (movingLeft = true)  {
						head.translateBy(-10, 0);
					}
					
					else if (movingUp = true)  {
						head.translateBy(0, -10);
					}
					
					else if (movingDown = true)  {
						head.translateBy(0, 10);
					}
				}
				
			}
			// we need to reset our time variable back to the current time of the system in order to reset our 
			// movement loopo
			time = System.currentTimeMillis();
		}
		
	// if we press one of the movement keys and we are going in the direction opposite of the one we chose	
	if (EZInteraction.wasKeyPressed('d') && (!movingLeft == true))  {
		// we set our booleans to their appropriate true or false depending on which direction we are moving
		movingRight = true;
		movingUp = false;
		movingDown = false;
		movingLeft = false;
	}
	
	if (EZInteraction.wasKeyPressed('a') && (!movingRight == false))  {
		movingLeft = true;
		movingUp = false;
		movingDown = false;
		movingRight = false;
	}
	
	if (EZInteraction.wasKeyPressed('w') && (!movingDown == true))  {
		movingUp = true;
		movingDown = false;
		movingRight = false;
		movingLeft = false;
	}
	
	if (EZInteraction.wasKeyPressed('s') && (!movingUp == true))  {
		movingDown = true;
		movingUp = false;
		movingLeft = false;
		movingRight = false;
	}
		
	
	
			// if we press the d key and we are not moving left then we can move
			// right
			// same goes for all directions
		/*
			if (EZInteraction.wasKeyPressed('d') && (!snake.isMovingLeft()) {
				// we set our booleans in order to keep track of which direction we
				// move next
				snake.setMovingRight(true);
				snake.setMovingUp(false);
				snake.setMovingDown(false);
			}

			if (EZInteraction.wasKeyPressed('a') && (!movingRight)) {
				snake.setMovingLeft(true);
				snake.setMovingUp(false);
				snake.setMovingDown(false);
			}

			if (EZInteraction.wasKeyPressed('w') && (!movingDown)) {
				snake.setMovingUp(true);
				snake.setMovingRight(false);
				snake.setMovingLeft(false);
			}

			if (EZInteraction.wasKeyPressed('s') && (!movingUp)) {
				snake.setMovingDown(true);
				snake.setMovingRight(false);
				snake.setMovingLeft(false);
			}
		*/
		// I am sure we need to call some sort of timer in order to move our
		// snake at a consistent speed
		// I could be wrong but this seems logical
		//initGame();
		
		// creates our snaked
		//snake = new Snake();
		// initially we are moving right 
	//	snake.setMovingRight(true);
		// calls the move function so the snake moves
		//call here or call in the snake class?
		// still unsure
	//	snake.Move();
		// again should this be in the snake class or here as it is below
//		snake.keyDetect();
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

		
		// should the movement detection be in main or in the snake class.....
		
		// if we press the d key and we are not moving left then we can move right
		// basically what we want is a way to track if we are moving in a specific direction
		// and if we are we cannot move in another specified direction.
	/*	if (EZInteraction.wasKeyPressed('d') && (!snake.isMovingLeft()))  {
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
	*/
		
		EZ.refreshScreen();
	}
		
	}

}
