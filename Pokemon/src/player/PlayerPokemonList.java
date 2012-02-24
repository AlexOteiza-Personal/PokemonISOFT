package player;

import java.lang.reflect.Array;
import java.util.ArrayList;

import pokemon.Pokemon;
import pokemon.PokemonData;

public class PlayerPokemonList {
    private Pokemon[] pokemonList = new Pokemon[6];
    private static final PlayerPokemonList mPlayerPokemonList = new PlayerPokemonList(new Pokemon(PokemonData.Abra,1));

    private PlayerPokemonList(Pokemon pokemon){
	this.pokemonList[0] = pokemon;
    }
    private PlayerPokemonList(Pokemon[] pokemonList){
	if(pokemonList==null)
	    return;
	for (int i = 0; i < this.pokemonList.length; i++)
	{
	    this.pokemonList[i] = pokemonList[i];
	}
    }
    
    public static PlayerPokemonList getPlayerpokemonlist()
    {
        return mPlayerPokemonList;
    }

    public Pokemon getPokemon(int num)
    {
	if(num<0 || num>=pokemonList.length)
	    return null;
        return pokemonList[num];
    }
    
}
