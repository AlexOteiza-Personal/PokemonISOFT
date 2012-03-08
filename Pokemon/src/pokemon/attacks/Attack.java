package pokemon.attacks;

import pokemon.Type;

public class Attack {
	
	AttackData attackData;
	int currentPP;
	int maxPP;
	
	public Attack(AttackData attackData)
	{
		this.attackData = attackData;
		this.maxPP = attackData.getIniPP();
		this.currentPP = this.maxPP;
	}
	public void decreasePP()
	{
		if(this.currentPP > 0)
			currentPP--;
	}
	public void restorePP()
	{
		this.currentPP = this.maxPP;
	}
	public int getCurrentPP() {
		return currentPP;
	}
	public int getMaxPP() {
		return maxPP;
	}
	public String getName() {
		return attackData.getName();
	}
	public int getPower() {
		return attackData.getPower();
	}
	public int getAccuracy() {
		return attackData.getAccuracy();
	}
	public Type getType() {
		return attackData.getType();
	}
	public StatusEffect getEnemyStatusEffect() {
		return attackData.getEnemyStatusEffect();
	}
}
