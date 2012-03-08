package pokemon.attacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import pokemon.PokemonLearnAttack;
import pokemon.PokemonLearnAttackList;

public class AttackList {
	private Attack[] attacks = new Attack[4];
	public AttackList(PokemonLearnAttackList learnList, int level)
	{
		AttackData[] attackData = learnList.getAttackData(learnList, level);	
		for (int i = 0; i < attacks.length; i++) {
			if(attackData[i] !=null)
				attacks[i] = new Attack(attackData[i]);
			else
				attacks[i] = null;
		}
		System.out.println(Arrays.toString(attackData));
	}
}
