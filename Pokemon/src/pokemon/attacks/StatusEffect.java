package pokemon.attacks;

import pokemon.PokemonStatus;

public class StatusEffect {

	private int posibility;
	private PokemonStatus statusEffect;
	public StatusEffect(PokemonStatus statusEffect) {
		this(100,statusEffect);
	}
	public StatusEffect(int posibility, PokemonStatus statusEffect) {
		this.posibility = posibility;
		this.statusEffect = statusEffect;
	}
	public int getPosibility() {
		return posibility;
	}
	public PokemonStatus getStatusEffect() {
		return statusEffect;
	}
	
}
