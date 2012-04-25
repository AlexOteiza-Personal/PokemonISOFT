package graphics.world;

public class World implements Runnable{
	int x;
	int y;
	OverWorld overworld;
	public World(OverWorld ow) {
		overworld = ow;
	}
	@Override
	public void run() {
		System.out.println("asdf");

	}
	
}
