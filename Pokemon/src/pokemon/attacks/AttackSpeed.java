package pokemon.attacks;

public enum AttackSpeed {
	
	VERY_SLOW(-40),
	SLOW(-20),
	NORMAL(0),
	FAST(20),
	VERY_FAST(40);
	private int speedBonus;
	private AttackSpeed(int speedBonus) {
		this.speedBonus = speedBonus;
	}
	public int getSpeedBonus() {
		return this.speedBonus;
	}
}
