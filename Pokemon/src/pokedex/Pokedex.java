package pokedex;

import java.util.Arrays;
import java.util.Iterator;

import pokemon.*;


public class Pokedex {
	private static Pokedex mPokedex = new Pokedex();
	private PokedexData pokemonList[]=
	{
			new PokedexData(PokemonData.Bulbasaur,"Este Pokémon nace con una semilla en\nel lomo. Con el tiempo, la semilla brota."),
			new PokedexData(PokemonData.Ekans ,"Es fácil encontrarlo en praderas y zonas\nsimilares. A este Pokémon le basta con\nsacar la lengua para detectar el peligro."),
			new PokedexData(PokemonData.Diglett,"Este Pokémon se entierra a grán\nprofundidad, pero como levanta tierra\nal cavar, es fácil localizarlo."),
			new PokedexData(PokemonData.Rattata,"Tiene unos largos y afilados colmillos\nque no dejan de crecer. Le resultan\nmuy útiles para destruir cosas."),
			new PokedexData(PokemonData.Weedle,"Suele habitar bosques y praderas.\nTiene un afilado y venenoso aguijón\nde unos 5 cm encima de la cabeza."),
			new PokedexData(PokemonData.Abra,"Duerme 18 horas al día y mientras\nlo hace es capaz de usar una serie\nde poderes extrasensoriales."),
			new PokedexData(PokemonData.Dodrio,"Pertenece a una rara especie difícil de\nencontrar. Las tres cabezas simbolizan\nla alegría, la tristeza y la ira."),
			new PokedexData(PokemonData.Pidgey,"A este Pokémon no le gusta luchar. Suele\npermanecer escondido en zonas de hierba\nalta. Se alimenta de pequeños insectos."),
			new PokedexData(PokemonData.Arcanine,"Un Pokémon muy admirado desde la\nantigüedad por su belleza. Corre\nágilmente como si tuviera alas."),
			new PokedexData(PokemonData.Mew,"Varios científicos lo consideran el\nantecesor de los Pokémon porque usa\ntodo tipo de movimientos."),
	
	};
	private Iterator<PokedexData> iterator = Arrays.asList(pokemonList).iterator();
	private Pokedex() {}
	public static Pokedex getPokedex() {
		return mPokedex;
	}
	public PokedexData getPokemon(int index)
	{
		if(index==-1)
			return pokemonList[pokemonList.length-1];
	    return pokemonList[index];
	}
	public int size()
	{
		return pokemonList.length;
	}
	
	
}
