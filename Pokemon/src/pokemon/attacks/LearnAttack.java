package pokemon.attacks;


public class LearnAttack {

	private int level;
	private AttackData attack;
	
	public LearnAttack(int level, AttackData attack)
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
