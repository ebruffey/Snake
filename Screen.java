import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
// when screen implements runnable we are giving precedence to running this section of code
// runnable allows us to use thread
public class Screen implements Runnable {
// variables for our board size
	public static final int WIDTH = 800, HEIGHT = 800;
// this sets an independent pathway within the program
// setting precedence? I used just enuf java to use thread because I think 
// it is necessary to initialize this thread as the main loop
	private Thread thread;
// this decides the state of the game, when false we are not running, true we are running
	private boolean running = false;
// new object of type bodyparts from the class body parts
	private BodyParts bP;
// an array list to hold our snake bodyparts
	private ArrayList <BodyParts> snake;
// starting x and y coordinates	
	private int xCoor = 10, yCoor = 10;
// holds the size of our snake
	private int size = 5;
// this keeps track of time, intead of using a timer we use a variable
	private int ticks = 0;
// booleans to hold our movement  
	private boolean right = true, left = false, up = false, down = false;
	
// 	builds our screen 
	public Screen()  {
		// initialize with width and height declared above
		EZ.initialize(WIDTH, HEIGHT);
		// make our new snake array list of type body parts
		snake = new ArrayList <BodyParts>();
		// this is our thread method which tells the computer to run this thread
		start();
		
	}
	// method to keep track of how much time has passed
	public void tick()  {
		// if there is nothing in our snake array then we add a new body part at xcoo ycoor and size 10
		if (snake.size() == 0)  {
			bP = new BodyParts (xCoor, yCoor, 10);
			// adds the body part to the next available space in the array list
			snake.add(bP);	
		}
		// here we increment ticks
		ticks++;
		// this determines how fast our game moves, the greater the number the slower it moves
		if (ticks == 250000)  {
			// if our boolean direction right is true the we add 1 to our xcoor
			// same goes for all movements
			if (right) xCoor++;
			
			if (left) xCoor--;
			
			if (up) yCoor--;
			
			if (down) yCoor++;
			
			// here we reset the tick in order to refresh our loop here
			ticks = 0;
			// we add a new body part to the end of the array 
			bP = new BodyParts (xCoor, yCoor, 10);
			snake.add(bP);
		}
	}
	// this method paints our snake and grid to the screen
	public void paint()  {
		// for loop for drawing our line grid
		for (int i = 0; i < WIDTH / 10 + 10; i++)  {
			EZ.addLine(i * 10, 0, i * 10, HEIGHT + 10, Color.BLACK, 2);
			EZ.addLine(0, i * 10, WIDTH + 10, i * 10, Color.BLACK, 2);
		}
		// here we draw our snake
		for (int i = 0; i < snake.size(); i++)  {
			snake.get(i).draw();
		}
	
	}
	// keeps our screen refreshing
	public void start()  {
		// sets our running to to true so our game runs
		running = true;
		// declare the new thread and call it game loop
		thread = new Thread(this, "Game Loop");
		//start our thred
		thread.start();
	}
	
	public void stop ()  {
		
	}
	// 
	public void run ()  {
		
		while (running = true)  {
			
			tick();
			EZ.refreshScreen();
		}
	}
	
	public void moveSnake()  {
		
		for (int i = snake.size(); i > 0; i--)  {
			
			snake.get(i);
		}
	}
}
