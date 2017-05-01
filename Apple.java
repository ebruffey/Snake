import java.awt.Color;
import java.util.Random;

public class Apple {
	// variables for our x and y
	private int appleX, appleY;
	// EZrectangle variable to hold our apples rectangle as a variable
	private EZRectangle appleRec;

	// the apple constructor
	public Apple()  {
		// we create random numbers for the initial set up of our apple
		// this is probably going to be changed in the future
		Random ranGen = new Random();
		// our bounds are 10 less than the full width/height of the screen
		// in order to not spawn off of the screen
		appleX = ranGen.nextInt(680) + 10;
		appleY = ranGen.nextInt(680) + 10;
		// adds a rectangle for the apple at the random x and y locations
		appleRec = EZ.addRectangle(appleX, appleY, 10, 10, Color.GREEN, true);
	}
	
	// method to move our apple after the collision
		public void moveApple()  {
			// random generator for our new random integer
			Random ranGen = new Random();
			// grabbing new x and y variables 
			appleX = ranGen.nextInt(680) + 10;
			appleY = ranGen.nextInt(680) + 10;
			// we remove the rectangle  
			EZ.removeEZElement(appleRec);
			// then we add a new rectangle at the random integers defined above
			appleRec = EZ.addRectangle(appleX, appleY, 10, 10, Color.GREEN, true);
		}
		
	// method to grab the apples x coordinate
	public int getAppleX()  {
		return appleX;
	}
	// method to grab the apply y coordinate
	public int getAppleY()  {
		return appleY;
		}
	
	}
