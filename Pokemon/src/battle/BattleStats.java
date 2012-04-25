package battle;

import pokemon.Pokemon;
import pokemon.PokemonStats;

public class BattleStats{
	private static final int MIN_ATTACK=-6;
	private static final int MAX_ATTACK=6;
	
	private static final int MIN_DEFENSE=-6;
	private static final int MAX_DEFENSE=6;
	
	private static final int MIN_SPEED=6;
	private static final int MAX_SPEED=6;
	
	private static final int MIN_ACCURACY=-6;
	private static final int MAX_ACCURACY=6;
	
	private static final int MIN_EVASION=-6;	
	private static final int MAX_EVASION=6;
	
	private int attack;
	private int attackLevel=0;
	private int defense;
	private int defenseLevel=0;
	private int speed;
	private int speedLevel=0;
	private int accuracy;
	private int accuracyLevel=0;
	private int evasion;
	private int evasionLevel=0;
		
	protected BattleStats(PokemonStats stats) {
		this.attack = stats.getAttack();
		this.defense = stats.getDefense();
		this.speed = stats.getSpeed();
		this.accuracy = 100;
		this.evasion = 100;
	}
	
	
	///// ATTACK /////
	
	public int getAttack() {
		return attack;
	}
	public boolean increaseAttack() {
		if(this.attackLevel<MAX_ATTACK)
		{
			attackLevel++;
			attack = getStat(attack, attackLevel);
			return true;
		}
		else 
			return false;
	}
	public boolean decreaseAttack(){
		if(this.attackLevel<MIN_ATTACK)
		{
			attackLevel--;
			attack = getStat(attack, attackLevel);
			return true;
		}
		else 
			return false;
		
	}
	/////////////////////////////
	
	
	///// DEFENSE //////
	public int getDefense() {
		return defense;
	}
	public boolean increaseDefense() {
		if(this.evasionLevel<MAX_DEFENSE)
		{
			defenseLevel++;
			defense = getStat(defense, defenseLevel);
			return true;
		}
		else 
			return false;
	}
	
	public boolean decreaseDefense(){
		if(this.defenseLevel>MIN_DEFENSE)
		{
			defenseLevel--;
			defense = getStat(defense,defenseLevel);
			return true;
		}
		else 
			return false;
	}
	
	////////////////////////
	
	
	//////   SPEED  ///////
	public int getSpeed() {
		return speed;
	}

	public boolean increaseSpeed() {
		if(this.speedLevel<MAX_SPEED)
		{
			speedLevel++;
			speed = getStat(speed, speedLevel);
			return true;
		}
		else 
			return false;
	}
	
	public boolean decreaseSpeed(){
		if(this.speedLevel>MIN_SPEED)
		{
			speedLevel--;
			speed = getStat(speed, speedLevel);
			return true;
		}
		else 
			return false;
	}
	/////////////////////
	
	////// ACCURACY  ///////
	public int getAccuracy() {
		return accuracy;
	}
	
	public boolean increaseAccuracy() {
		if(this.accuracyLevel<MAX_ACCURACY)
		{
			accuracyLevel++;
			accuracy = getStat(accuracy,accuracyLevel);
			return true;
		}
		else 
			return false;
	}
	
	public boolean decreaseAccuracy(){
		if(this.accuracyLevel>MIN_ACCURACY)
		{
			accuracyLevel--;
			accuracy = getStat(accuracy,accuracyLevel);
			return true;
		}
		else 
			return false;
	}
	
	///////////////////////////
	
	//// EVASION //////
	public int getEvasion() {
		return evasion;
	}
	public boolean increaseEvasion() {
		if(this.evasionLevel<MAX_EVASION)
		{
			evasionLevel++;
			evasion = getStat(evasion,evasionLevel);
			return true;
		}
		else 
			return false;
	}
	public boolean decreaseEvasion() {
		if(this.evasionLevel>MIN_EVASION)
		{
			evasionLevel++;
			evasion = getStat(evasion,evasionLevel);
			return true;
		}
		else 
			return false;
	}
	///////////////////
	
	private int getStat(int stat,int level){
		if(level>0)
			return (int)(stat*((double)(level)/2));
		else if(level<0)
			return (int)(stat*(2/(double)(level)));
		else
			return stat;
	}
}
