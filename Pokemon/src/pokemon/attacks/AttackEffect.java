package pokemon.attacks;

public class AttackEffect {
	private StatsEffect statsEffect;
	private StatusEffect statusEffect;
	private boolean selfEffect;
	
	protected AttackEffect(StatusEffect statusEffect, boolean enemyEffect){
		this(null,statusEffect,enemyEffect);
	}
	protected AttackEffect(StatsEffect effect,boolean enemyEffect) {
		this(effect,null,enemyEffect);
	}
	protected AttackEffect(StatsEffect effect,StatusEffect statusEffect, boolean selfEffect) {
		this.statsEffect = effect;
		this.statusEffect = statusEffect;
		this.selfEffect = selfEffect;
	}
	
	public StatsEffect getStatsEffect() {
		return statsEffect;
	}
	public StatusEffect getStatusEffect() {
		return statusEffect;
	}
	public boolean isSelfEffect() {
		return selfEffect;
	}
}
