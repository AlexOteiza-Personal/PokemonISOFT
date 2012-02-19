import java.io.IOException;

import graphics.GameFrame;
import pokemon.*;
public class Principal {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Pokemon a = new Pokemon(PokemonData.Bulbasaur, 1);
		System.out.println(a);
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
