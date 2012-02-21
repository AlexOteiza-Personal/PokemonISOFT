import java.io.IOException;

import graphics.GameFrame;
import pokemon.*;
public class Principal {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		try
		{
			new GameFrame();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			System.exit(2);
		}
	}

}
