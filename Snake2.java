import java.awt.Color;

public class Snake2 {
	
	private int xCoor, yCoor, width, height;
	
	public Snake2(int xCoor, int yCoor, int tileSize){
		this.xCoor = xCoor;
		this.yCoor = yCoor;
		width = tileSize;
		height = tileSize;
	}
	
	public void tick() {
		

	}
	
	public void draw() {
	
		EZ.addRectangle(xCoor * width, yCoor * height, width, height, Color.red, true);
		EZ.addRectangle(xCoor * width + 2, yCoor * height + 2, width - 4, height - 4, Color.red, true);
	}

}
