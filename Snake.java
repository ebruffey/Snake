import java.awt.Color;


public class Snake {
		
	//	public EZRectangle snakeHead;
	//	public int snakeX, snakeY;
	//	public EZRectangle [] snake = new EZRectangle [5];
	
	// arrays for the x and y positions of each tile of the board
		public int [] sX = new int [Main.getAllTiles()];
		public int [] sY = new int [Main.getAllTiles()];
		//array for the rectangles of the snake which is the size of the total tiles on the board
		public EZRectangle [] snakeParts = new EZRectangle [Main.getAllTiles()];
	//	private ArrayList <Integer> joints = new ArrayList <Integer>(); 
		
		// keeps track of how many EZrectangle blocks of the snake we have
		public static int joints = 3;
		//starting x and y of our snake
		private int startX = 350;
		private int startY = 350;
		// booleans to determine which direction we are moving in
		static boolean movingLeft = false;
		static boolean movingRight = false;
		static boolean movingUp = false;
		static boolean movingDown = false;
	// creates our snake as an object 	
		public Snake()  {
			// for loop which of of size of joints
			for (int i = 0; i < joints; i++)  {
				// the 0 position of our snake is the head and its red
				if (i == 0)  {
					snakeParts[i] = EZ.addRectangle(startX, startY, Main.getTileSize(), Main.getTileSize(), Color.RED, true);
					// all other cells created
				} else  {
					snakeParts[i] = EZ.addRectangle(startX, startY, Main.getTileSize(), Main.getTileSize(), Color.BLACK, true);
				}
				//storing the x and y coordinates of the snake cells
				sX[i] = snakeParts[i].getXCenter();
				sY[i] = snakeParts[i].getYCenter();
				// Iterates so we don't load our snake parts on top of each other
				startX -= 20;
			//	sX[i] = snakeParts[i].getXCenter();
			//	sY[i] = snakeParts[i].getYCenter();
			}
			// methods to move our snake and determine its initial movement
			//still needs work... much thought....
			setMovingRight(true);
			Move();
		}
				
	/*		for (int i = 0; i < joints; i++)  {
				
				snake [i] = EZ.addRectangle(x, y, 20, 20, Color.BLACK, true);
				 x += 20;
				 snakeX = x;
				 snakeY = y;
				 
				sX[i] = snake[i].getXCenter();
				sY[i] = snake[i].getYCenter();
			}
			snakeHead = snake[0];
			
		}
		*/
	/*	public void setSnakeX(int i)  {
			sX[0] = i;
		}
		
		public void setSnakeY(int i)  {
			sY[0] = i;
		}
		
		public int getSnakeX(int index)  {
			return sX[index];
		}
		
		public int getSnakeY(int index)  {
			return sY[index];
		}
		*/
		//checks if we are moving right
		// same for all directions of travel
		public boolean isMovingRight()  {
			return movingRight;
		}
		// set our movement right which accepts a boolean true or false
		public void setMovingRight(boolean movingRight)  {
			
		}
		
		public boolean isMovingLeft()  {
			return movingLeft;
		}
		
		public void setMovingLeft(boolean movingLeft)  {
			
		}
		
		public boolean isMovingUp()  {
			return movingUp;
		}
		
		public void setMovingUp(boolean movingUp)  {
			
		}
		
		public boolean isMovingDown()  {
			return movingDown;
		}
		
		public void setMovingDown(boolean movingDown)  {
			
		}
		
	/*	public void setJoints(int j)  {
			joints
		}
		*/
		
		// method for grabbing the amount of joints or blocks we have in our snake
		public int getJoints()  {
			return joints;
		}
		// move method... still not working...
	
		public void Move()  {
			
		//	sX[i] = snakeParts[i].getXCenter();
			
		// we iterate from the end of the snake to the head, but we don't iterate through the head of the snake
		for (int i = joints; i > 0; i--)  {
			
			
		//	snake[i].getXCenter();
		//	snake[i].getYCenter();
			
		//	snake[i] = snake[(i - 1)];
		//	snake[i] = snake[(i - 1)];
			
		// we are setting the previous blocks x and y positions to the next positions in the arrays
			sX[i] = sX[(i - 1)];
			sY[i] = sY[(i - 1)];
		}
		// if our boolean moving left is true
			if (movingLeft) {
			// we move the head of the snakes head to the next tile on the board	
				sX[0] -= Main.getTileSize();
			}

			if (movingRight) {
				
				sX[0] += Main.getTileSize();
			}

			if (movingDown) {
				sY[0] += Main.getTileSize();
			}

			if (movingUp) {
				sY[0] -= Main.getTileSize();
			}
		
	}
		
}
