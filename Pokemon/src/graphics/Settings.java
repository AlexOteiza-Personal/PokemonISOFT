package graphics;

public class Settings {
	private static boolean soundOn = true;
	public static void setSound(boolean on){
		 soundOn = on;
	}
	public static boolean getSound(){
		return soundOn;
	}
}
