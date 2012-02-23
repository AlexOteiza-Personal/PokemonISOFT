package player;

import java.lang.reflect.Array;
import java.util.ArrayList;

import pokemon.Pokemon;
import pokemon.PokemonData;

public class PlayerPokemonList {
    private Pokemon[] pokemonList = new Pokemon[6];
    private static final PlayerPokemonList PLAYERPOKEMONLIST = 
	    new PlayerPokemonList(new Pokemon[] 
		    {
		    new Pokemon(PokemonData.Bulbasaur,3),
		    new Pokemon(PokemonData.Arcanine,3),
		    new Pokemon(PokemonData.Dodrio,3),
		    new Pokemon(PokemonData.Mew,3)
		    });
    private PlayerPokemonList(Pokemon[] pokemonList){
	for (int i = 0; i < this.pokemonList.length; i++)
	{
	    this.pokemonList[i] = pokemonList[i];
	}
    }
    public static PlayerPokemonList getPLAYERPOKEMONLIST()
    {
        return PLAYERPOKEMONLIST;
    }
    public Pokemon getPokemon(int num)
    {
	if(num<0 || num>=pokemonList.length)
	    return null;
        return pokemonList[num];
    }
    
}
