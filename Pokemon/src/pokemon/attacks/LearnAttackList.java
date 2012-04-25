package pokemon.attacks;

import images.ImageData;

public enum LearnAttackList {
	Bulbasaur(new LearnAttack[]{
			new LearnAttack(1,AttackData.TACKLE),
			new LearnAttack(3,AttackData.GROWL),
			new LearnAttack(4,AttackData.TACKLE),
			new LearnAttack(4,AttackData.GROWL)}),
	Ekans	 (new LearnAttack[]{}),
	Diglett  (new LearnAttack[]{}),
	Rattata  (new LearnAttack[]{}),
	Weedle	 (new LearnAttack[]{}),
	Abra	 (new LearnAttack[]{}),
	Dodrio	 (new LearnAttack[]{}),
	Pidgey	 (new LearnAttack[]{}),
	Arcanine (new LearnAttack[]{}),
	Mew	     (new LearnAttack[]{});
	private LearnAttack[] attacks;
	private LearnAttackList(LearnAttack[] attacks){
		this.attacks = attacks.clone();
	}
	public AttackData[] getAttackData(LearnAttackList learnList ,int level)
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
