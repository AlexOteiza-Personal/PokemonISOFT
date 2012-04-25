package battle;

import pokemon.Effectiveness;

public class AttackResult {
	private int damage;
	private boolean hitted;
	private Effectiveness effectiveness;
	private boolean critical;
	public AttackResult() {
		this(false,0,null,false);
	}
	public AttackResult(boolean hitted)
	{
		this(hitted,0,null,false);
	}
	public AttackResult(boolean hitted,int damage)
	{
		this(hitted,damage,null,false);
	}
	public AttackResult(boolean hitted,int damage, Effectiveness effectiveness, boolean critical) {
		this.hitted = hitted;
		this.damage = damage;
		this.effectiveness = effectiveness;
		this.critical = critical;
	}
	public boolean isHitted() {
		return hitted;
	}
	public Effectiveness getEffectiveness() {
		return effectiveness;
	}
	public void setEffectiveness(Effectiveness effectiveness) {
		this.effectiveness = effectiveness;
	}
	public boolean isCritical() {
		return critical;
	}
	public void setCritical(boolean critical) {
		this.critical = critical;
	}
	public int getDamage(){
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	

}
