

public class Frame extends Screen{
	
	public Frame()  {
		
		init();
	}
	
	public void init()  {
		Screen s = new Screen();
		s.paint();
		run();
	}

	public static void main(String[] args) {
		
		new Frame();

	}

}
