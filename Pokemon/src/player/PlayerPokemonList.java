package player;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import pokemon.Pokemon;
import pokemon.PokemonData;

public class PlayerPokemonList {
    private List<Pokemon> pokemonList = new ArrayList<Pokemon>();
    private static final PlayerPokemonList mPlayerPokemonList = 
	    new PlayerPokemonList(new Pokemon[]
	    	{
	    		new Pokemon(PokemonData.Bulbasaur,8),
	    		new Pokemon(PokemonData.Arcanine,2),
	    		new Pokemon(PokemonData.Bulbasaur, 2),
	    		new Pokemon(PokemonData.Diglett,2),
	    		new Pokemon(PokemonData.Ekans, 2),
	    		new Pokemon(PokemonData.Mew, 2),
	    	});
    
    private PlayerPokemonList(Pokemon pokemon){
    	if(pokemonList==null)
    		throw new IllegalArgumentException("Pokemon = null!");
    	this.pokemonList.add(pokemon);
    }
    
    private PlayerPokemonList(Pokemon[] pokemonList){
    	if(pokemonList==null)
    		throw new IllegalArgumentException("Pokemonlist == null!");
    	else if(pokemonList.length > 6)
    		throw new IllegalArgumentException("Too many pokemon. Max size=6; Current size="+pokemonList.length);
    	for (int i = 0; i < pokemonList.length; i++)
		{
    		this.pokemonList.add(pokemonList[i]);
		}
    }
    
    public static PlayerPokemonList getPlayerpokemonlist()
    {
        return mPlayerPokemonList;
    }

    public Pokemon getPokemon(int num)
    {
    	if(num<0 || num>=pokemonList.size())
    		return null;
        return pokemonList.get(num);
		
    }
    public void addPokemon(Pokemon pokemon)
    {
    	pokemonList.add(pokemon);
    }
    public void removePokemon(Pokemon pokemon)
    {
    	pokemonList.remove(pokemon);
    }
    public void removePokemon(int index)
    {
    	pokemonList.remove(index);
    }
    public int size()
    {
    	return pokemonList.size();
    }

	public void switchPokemon(int i, int j) {
		Pokemon pi = pokemonList.get(i);
		Pokemon pj = pokemonList.get(j);
		pokemonList.set(i, pj);
		pokemonList.set(j, pi);
	}
}
