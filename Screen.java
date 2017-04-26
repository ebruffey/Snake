import java.awt.Color;

public class Screen implements Runnable {

	public static final int WIDTH = 800, HEIGHT = 800;

	private Thread thread;
	private boolean running = false;

	public Screen() {

		EZ.initialize(WIDTH, HEIGHT);
		start();
	}

	public void tick() {
		System.out.println("Fuck");
	}
 
	public void paint() {

	}

	public void start() {
		running = true;
		thread = new Thread(this, "Game Loop");
		thread.start();
	}

	public void stop() {

	}

	public void run() {
		while (running) {
			tick();
			EZ.refreshScreen();
		}
	}
}
