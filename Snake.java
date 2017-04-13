import java.awt.Color;

public class Snake {

	int x = 0;
	int y = 0;
	int speed = 0;
	private EZRectangle snakePicture;

	public Snake() {
		x += 250;
		y += 250;
		snakePicture = EZ.addRectangle(x, y, 50, 50, Color.pink, true);

	}

	public void Move() {
		speed = 1;
		while (true) {
			if (EZInteraction.isKeyDown('w')) {
				snakePicture.translateBy(0, -speed);
			} else if (EZInteraction.isKeyDown('a')) {
				snakePicture.translateBy(-speed, 0);
			} else if (EZInteraction.isKeyDown('s')) {
				snakePicture.translateBy(0, speed);
			} else {
				snakePicture.translateBy(speed, 0);
			}
		}
	}

	public int getWorldXCenter() {
		return snakePicture.getWorldXCenter();
	}

	public int getWorldYCenter() {
		return snakePicture.getWorldYCenter();
	}

}
