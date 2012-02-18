package pokemon;

public class PokemonList {

	private static PokemonData[] pokemonData = 
	{
	    new PokemonData(1,
			"Bulbasaur",
			new PokemonType(Type.GRASS,Type.POISON),
			new PokemonStats(6,6,5,6,6),
			null),
		new PokemonData(2,
			"Ivysaur",
			new PokemonType(Type.GRASS,Type.POISON),
			new PokemonStats(6,6,5,6,6),
			null)
	};
	@SuppressWarnings("unused")
	private static PokemonList INSTANCE = new PokemonList();
	private PokemonList(){}
	
	public static PokemonData getPokemonData(int id, int level)
	{
		return pokemonData[id];
	}
}
