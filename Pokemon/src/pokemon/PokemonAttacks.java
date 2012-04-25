package pokemon;

import java.util.Arrays;

import pokemon.attacks.Attack;
import pokemon.attacks.AttackData;
import pokemon.attacks.LearnAttackList;

public class PokemonAttacks {
	public static final int MAX_ATTACKS = 4;
	private Attack[] attacks = new Attack[MAX_ATTACKS];
	public PokemonAttacks(LearnAttackList learnList, int level)
	{
		AttackData[] attackData = learnList.getAttackData(learnList, level);	
		for (int i = 0; i < attacks.length; i++) {
			if(attackData[i] !=null)
				attacks[i] = new Attack(attackData[i]);
			else
				attacks[i] = null;
		}
	}
	public Attack getAttack(int index) {
		if(index<MAX_ATTACKS)
			return attacks[index];
		else
			return attacks[MAX_ATTACKS-1];
	}
}
