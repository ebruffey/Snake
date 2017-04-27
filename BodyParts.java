import java.awt.Color;

public class BodyParts {
	
	private int xCoor, yCoor, width, height;
	
	public BodyParts(int xCoor, int yCoor, int tileSize)  {
		
		this.xCoor = xCoor;
		this.yCoor = yCoor;
		
		width = tileSize;
		height = tileSize;
	}
	
	public void tick()  {
		
	}
	
	public void draw()  {
		
		EZ.addRectangle(xCoor * width, yCoor * height - 5, width, height, Color.RED, true);
		EZ.addRectangle(xCoor * width - 10, yCoor * height - 5, width, height, Color.BLACK, true);
	}
}


