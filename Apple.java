import java.awt.Color;
import java.util.Random;

public class Apple {

	private int appleX, appleY;
	private int random;
	
	// we need a way to determine whether or not our apple has been spawned within the 
	// area of the snake. If it is we need to pick a new random number
	//still unsure of how to accomplish
	
	// unfinished method for determining whether our spawned apple is within our snake
	public void locDetermine()  {
		// we create a random generator
		Random ranGen = new Random();
		// set the bounds of our random number to the number of all the tiles of the screen minus
		// the size of our snake
		//random = ranGen.nextInt(Main.getAllTiles() - Snake.getJoints());
		// variables to determine whether we can place a fruit
		int spotFound = 0;
		int index = 0;
		// Im sure we need some sort of loop to iterate through all of the tiles
		// and return true if our number is not within the illegal tiles.
		while (spotFound < random)  {
			
			index++;
		//	if (Main.getTile(index % 35, index / 35))
		}
	}
	
	public void ranLoc()  {
		
		Random ranGen = new Random();
		
		appleX = ranGen.nextInt(680);
		appleY = ranGen.nextInt(680);
	}
	
	// the apple constructor
	public Apple()  {
		// we create random numbers for the initial set up of our apple
		// this is probably going to be changed in the future
		Random ranGen = new Random();
		// our bounds are 10 less than the full width/height of the screen
		// in order to not spawn off of the screen
		appleX = ranGen.nextInt(680);
		appleY = ranGen.nextInt(680);
		// adds a rectangle for the apple at the random x and y locations
		EZ.addRectangle(appleX, appleY, 10, 10, Color.GREEN, true);
	
	
	
	
	}
	public int getAppleX()  {
		return appleX;
	}
	
	public int getAppleY()  {
		return appleY;
		}
	}
