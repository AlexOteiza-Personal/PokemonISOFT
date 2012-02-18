import graphics.Skeleton;
import pokemon.*;
public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Pokemon a = new Pokemon(PokemonData.Bulbasaur, 1);
		System.out.println(a);
		new Skeleton();
	}

}
