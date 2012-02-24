package pokedex;

import pokemon.*;


public class Pokedex {
	private static Pokedex mPokedex = new Pokedex();
	private PokedexData pokemonList[]=
	{
			new PokedexData("Bulbasaur",Type.GRASS ,Type.POISON,"For some time after its birh, it grows by gaining nourishment from the seed o its back"),
			new PokedexData("Ekans",Type.POISON,null,"It sneaks through grass without making a soun and strikes unsuspecting prey from behind"),
			new PokedexData("Diglett",Type.GROUND,null,"A Pokemon that lives underground. Because of its dark habitat, it is repelled by bright sunlight"),
			new PokedexData("Rattata",Type.NORMAL,null,"Cautious in the extreme, its hardy vitality lets it live in any kind of environement"),
			new PokedexData("Weedle",Type.BUG,Type.POISON,"It eats its wight in leaves every day. It fends off attackers with the needle on its head"),
			new PokedexData("Abra",Type.PSYCHIC,null,"Using its psychic power is such a strain on its brain that it needs to sleep for 18 hours a day"),
			new PokedexData("Dodrio",Type.NORMAL,Type.FLYING,"Wen dodudo envolves into this odd breed, one of its heads splits into two. It runs at nearly 40 mph"),
			new PokedexData("Pidgey",Type.NORMAL,Type.FLYING,"It is docile and prefers to avoid conflict. If disturbed however, it can ferociously strike back"),
			new PokedexData("Arcanine",Type.FIRE,null,"Its proud an regal apperance has captured the hearts of people since long ago"),
			new PokedexData("Mew",Type.PSYCHIC,null,"Because it can use all kinds of moves, many scientists belive Mew to be te ancestor of Pokemon"),
	
	};
	private Pokedex() {}
	public static Pokedex getPokedex() {
		return mPokedex;
	}
	

	
	
	
}
