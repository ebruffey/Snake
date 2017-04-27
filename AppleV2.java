import java.awt.Color;

public class AppleV2 {

	private int xCoor, yCoor, width, height;
	
public void AppleSquare (int xCoor, int yCoor,int tileSize ) {
	this.xCoor = xCoor;
	this.yCoor = yCoor;
	width = tileSize;
	height = tileSize;
	}
public void tick() {
	
	}
public void draw (){
EZ.addRectangle(xCoor*width, yCoor*height, width, height, Color.ORANGE, true);

	}
public int getxCoor() {
	return xCoor;
	}
public void setxCoor(int xCoor) {
	this.xCoor = xCoor;
	}
public int getyCoor() {
	return yCoor;
	}
public void setyCoor(int yCoor) {
	this.yCoor = yCoor;
	}




}
