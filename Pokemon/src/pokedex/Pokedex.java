package pokedex;

import pokemon.*;


public class Pokedex {
	private static Pokedex mPokedex = new Pokedex();
	private PokedexData pokemonList[]=
	{
			new PokedexData(PokemonData.Bulbasaur,"Este Pokémon nace con una semilla en el lomo.\n Con el tiempo, la semilla brota."),
			new PokedexData(PokemonData.Ekans ,"Es fácil encontrarlo en praderas y zonas similares.\n A este Pokémon le basta con sacar la lengua para detectar el peligro."),
			new PokedexData(PokemonData.Diglett,"Este Pokémon se entierra a gran profundidad,\n pero como levanta tierra al cavar, es fácil localizarlo."),
			new PokedexData(PokemonData.Rattata,"Tiene unos largos y afilados colmillos que no dejan de crecer. Le resultan muy útiles para destruir cosas."),
			new PokedexData(PokemonData.Weedle,"Suele habitar bosques y praderas. Tiene un afilado y venenoso aguijón de unos 5 cm encima de la cabeza."),
			new PokedexData(PokemonData.Abra,"Duerme 18 horas al día y mientras lo hace es capaz de usar una serie de poderes extrasensoriales."),
			new PokedexData(PokemonData.Dodrio,"Pertenece a una rara especie difícil de encontrar. Las tres cabezas simbolizan la alegría, la tristeza y la ira."),
			new PokedexData(PokemonData.Pidgey,"A este Pokémon no le gusta luchar. Suele permanecer escondido en zonas de hierba alta. Se alimenta de pequeños insectos."),
			new PokedexData(PokemonData.Arcanine,"Un Pokémon muy admirado desde la antigüedad por su belleza. Corre ágilmente como si tuviera alas."),
			new PokedexData(PokemonData.Mew,"Varios científicos lo consideran el antecesor de los Pokémon porque usa todo tipo de movimientos."),
	
	};
	private Pokedex() {}
	public static Pokedex getPokedex() {
		return mPokedex;
	}
	public PokedexData getPokemon(int index)
	{
	    return pokemonList[index];
	}
	
	
}
