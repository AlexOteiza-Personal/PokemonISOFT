package pokemon;

import pokemon.attacks.AttackData;

public class PokemonLearnAttack {

	private int level;
	private AttackData attack;
	
	public PokemonLearnAttack(int level, AttackData attack)
	{
		this.level = level;
		this.attack = attack;
	}
	
	public int getLevel() {
		return level;
	}
	public AttackData getAttack() {
		return attack;
	}
}
