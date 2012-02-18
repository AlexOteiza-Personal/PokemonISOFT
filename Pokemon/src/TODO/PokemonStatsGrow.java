package TODO;

@Deprecated
public class PokemonStatsGrow {
	private float attackGrow;
	private float defenceGrow;
	private float speedGrow;
	private float spAttackGrow;
	private float spDefenceGrow;
	@Deprecated
	public PokemonStatsGrow(int attackGrow, int defenceGrow, int speedGrow, int spAttackGrow, int spDefenceGrow) {
		this.attackGrow = attackGrow;
		this.defenceGrow = defenceGrow;
		this.speedGrow = speedGrow;
		this.spAttackGrow = spAttackGrow;
		this.spDefenceGrow = spDefenceGrow;
	}
	public float getAttackGrow() {
		return attackGrow;
	}
	public float getDefenceGrow() {
		return defenceGrow;
	}
	public float getSpeedGrow() {
		return speedGrow;
	}
	public float getSpAttackGrow() {
		return spAttackGrow;
	}
	public float getSpDefenceGrow() {
		return spDefenceGrow;
	}
}
