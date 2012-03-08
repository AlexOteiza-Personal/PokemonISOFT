package pokemon;

import pokemon.attacks.AttackData;
import pokemon.imagedata.ImageData;

public enum PokemonLearnAttackList {
	Bulbasaur(new PokemonLearnAttack[]{new PokemonLearnAttack(1,AttackData.TACKLE)}),
	Ekans	 (new PokemonLearnAttack[]{}),
	Diglett  (new PokemonLearnAttack[]{}),
	Rattata  (new PokemonLearnAttack[]{}),
	Weedle	 (new PokemonLearnAttack[]{}),
	Abra	 (new PokemonLearnAttack[]{}),
	Dodrio	 (new PokemonLearnAttack[]{}),
	Pidgey	 (new PokemonLearnAttack[]{}),
	Arcanine (new PokemonLearnAttack[]{}),
	Mew	     (new PokemonLearnAttack[]{});
	private PokemonLearnAttack[] attacks;
	private PokemonLearnAttackList(PokemonLearnAttack[] attacks){
		this.attacks = attacks.clone();
	}
	public AttackData[] getAttackData(PokemonLearnAttackList learnList ,int level)
	{
		AttackData[] tmpAttacks = new AttackData[4];
		int aLevel=-1;
		boolean maxReached = false;
		for (int i = 0, j = 0; i < attacks.length && !maxReached; i++) {
			aLevel = attacks[i].getLevel();
			if(aLevel <=level)
			{
				tmpAttacks[j] = attacks[i].getAttack();
				if(j<4) j++;
				else j=0;
			}
			else maxReached = true;
		}
		return tmpAttacks;
	}
}
