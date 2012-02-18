package pokemon;

public class PokemonStats {
	private int attack;
	private int defence;
	private int speed;
	/*
	private int spAttack;
	private int spDefence;
	*/
	protected PokemonStats(int attack, int defence, int speed, int spAttack, int spDefence) {
		this.attack = attack;
		this.defence = defence;
		this.speed = speed;
		/*
		this.spAttack = spAttack;
		this.spDefence = spDefence;
		*/
	}

	/*
	 * Getters
	 */
	public int getAttack() {
		return attack;
	}

	public int getDefence() {
		return defence;
	}

	public int getSpeed() {
		return speed;
	}
	/*
	@Deprecated
	public int getSpAttack() {
		return spAttack;
	}
	@Deprecated
	public int getSpDefence() {
		return spDefence;
	}*/
	

	public int[] getStats()
	{
		return new int[] {attack,defence,speed};
	}
	/*
	 * Setters
	 */
	
	public void setAttack(int attack) {
		this.attack = attack;
	}

	public void setDefence(int defence) {
		this.defence = defence;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	/*
	@Deprecated
	public void setSpAttack(int spAttack) {
		this.spAttack = spAttack;
	}
	@Deprecated
	public void setSpDefence(int spDefence) {
		this.spDefence = spDefence;
	}
	*/

}
