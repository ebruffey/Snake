import java.awt.Color;

public class Snake {
		
		public EZRectangle snakeHead;
		public int snakeX, snakeY;
		public EZRectangle [] snake = new EZRectangle [5];
	
		static final int SCREEN_HEIGHT = 700;
		static final int SCREEN_WIDTH = 700;
		
		
		public Snake(int x, int y)  {
				
			for (int i = 0; i < 5; i++)  {
				
				snake [i] = EZ.addRectangle(SCREEN_HEIGHT/2, SCREEN_WIDTH/2, 20, 20, Color.BLACK, true);
				 x += 20;
				 snakeX = x;
				 snakeY = y;
			}
			snakeHead = snake[0];
			
		}
		
		
		public int getHeadXCenter()  {
			return snakeHead.getXCenter();
		}
		
		public int getHeadYCenter()  {
			return snakeHead.getYCenter();
		}
		
	
		
		public void Move()  {
			
		for (int i = 4; i > 0; i--)  {
			
			snake[i].getXCenter();
			snake[i].getYCenter();
			
			snake[i] = snake[(i - 1)];
			snake[i] = snake[(i - 1)];
		
		}
			if (EZInteraction.isKeyDown('a')) {
				// slides image 5 pixels to the left. Same for the next 3 if
				// statements.
				snakeHead.translateBy(-2f, 0f);
			}

			if (EZInteraction.isKeyDown('d')) {
				snakeHead.translateBy(2f, 0f);
			}

			if (EZInteraction.isKeyDown('w')) {
				snakeHead.translateBy(0f, -2f);
			}

			if (EZInteraction.isKeyDown('s')) {
				snakeHead.translateBy(0f, 2f);
			}
		
	}
		
}
