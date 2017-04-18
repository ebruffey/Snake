import java.util.Random;
import java.awt.Color;
import java.awt.event.KeyEvent;


public class AppleClass {
private Snake snake = new Snake;
private int applex;
private int appley;
private final int rand;
public static int randInt(int min, int max) {
	Random rand = new Random();
	int randomNum = rand.nextInt((max - min) + 1) + min;
	return randomNum;

	}
Random randomGenerator = new Random();
EZImage apple = EZ.addImage("apple.jpg", randomGenerator.nextInt(applex),
		randomGenerator.nextInt(appley));

}