package pokemon.attacks;

import pokemon.Type;

public class Attack {
	private AttackData attackData;
	private int currentPP;
	private int maxPP;
	
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
	public AttackEffect getAttackEffect() {
		return attackData.getAttackEffect();
	}
	public boolean isSelfAttack(){
		return attackData.isSelfAttack();
	}
	public AttackSpeed getAttackSpeed(){
		return attackData.getAttackSpeed();
	}
}
