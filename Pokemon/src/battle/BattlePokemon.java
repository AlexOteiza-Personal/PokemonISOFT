package battle;

import pokemon.Pokemon;

public class BattlePokemon {
	private BattleStats tmpStats;
	private Pokemon pokemon;
	private boolean isPlayer;
	public BattlePokemon(Pokemon pokemon, boolean isPlayer) {
		this.pokemon = pokemon;
		this.tmpStats = new BattleStats(pokemon.getStats());
		this.isPlayer = isPlayer;
	}
	public BattleStats getTmpStats() {
		return tmpStats;
	}
	public Pokemon getPokemon() {
		return pokemon;
	}
	public boolean isPlayer() {
		return isPlayer;
	}
	@Override
	public String toString() {
		if(!isPlayer)
			return "ENEM. "+ pokemon.getName();
		else
			return pokemon.getName();
	}
	
}
