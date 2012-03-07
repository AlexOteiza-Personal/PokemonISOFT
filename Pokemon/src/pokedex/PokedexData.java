package pokedex;

import pokemon.*;
import pokemon.imagedata.ImageData;

public class PokedexData {
	private PokemonData pokemonData;
	private String description;
	private boolean seen;
	private boolean captured;

	public PokedexData(PokemonData pokemonData, String pDescripcion) {
		this.pokemonData = pokemonData;
		this.description = pDescripcion;
		this.seen = false;
		this.captured = false;
	}

	public void setSeen(boolean seen) {
		this.seen = seen;
	}

	public void setCaptured(boolean captured) {
		this.captured = captured;
	}

	public String getName() {
		return pokemonData.getName();
	}

	public String getStringId() {
		return pokemonData.getIdString();
	}

	public int getId() {
		return pokemonData.getId();
	}
	
	public pokemon.Type getType1() {
		return pokemonData.getType1();
	}

	public pokemon.Type getType2() {
		return pokemonData.getType2();
	}

	public ImageData getImageData() {
		return pokemonData.getImageData();
	}

	public String getDescription() {
		return description;
	}

	public boolean isSeen() {
		return seen;
	}

	public boolean isCaptured() {
		return captured;
	}
}

/*
 * public enum PokedexData{ Bulbasaur("Bulbasaur",Type.GRASS ,Type.POISON,
 * "For some time after its birh, it grows by gaining nourishment from the seed o its back"
 * ), Ekans ("Ekans",Type.POISON,null,
 * "It sneaks through grass without making a soun and strikes unsuspecting prey from behind"
 * ), Diglett ("Diglett",Type.GROUND,null,
 * "A Pokemon that lives underground. Because of its dark habitat, it is repelled by bright sunlight"
 * ), Rattata ("Rattata",Type.NORMAL,null,
 * "Cautious in the extreme, its hardy vitality lets it live in any kind of environement"
 * ), Weedle ("Weedle",Type.BUG,Type.POISON,
 * "It eats its wight in leaves every day. It fends off attackers with the needle on its head"
 * ), Abra ("Abra",Type.PSYCHIC,null,
 * "Using its psychic power is such a strain on its brain that it needs to sleep for 18 hours a day"
 * ), Dodrio ("Dodrio",Type.NORMAL,Type.FLYING,
 * "Wen dodudo envolves into this odd breed, one of its heads splits into two. It runs at nearly 40 mph"
 * ), Pidgey ("Pidgey",Type.NORMAL,Type.FLYING,
 * "It is docile and prefers to avoid conflict. If disturbed however, it can ferociously strike back"
 * ), Arcanine ("Arcanine",Type.FIRE,null,
 * "Its proud an regal apperance has captured the hearts of people since long ago"
 * ), Mew ("Mew",Type.PSYCHIC,null,
 * "Because it can use all kinds of moves, many scientists belive Mew to be te ancestor of Pokemon"
 * );
 * 
 * 
 * 
 * private String name; private pokemon.Type type1; private pokemon.Type type2;
 * private String description;
 * 
 * private PokedexData(String name,pokemon.Type type1, pokemon.Type type2,String
 * description){ this.name=name; this.type1=type1; this.type2=type2;
 * this.description=description; }
 * 
 * }
 */