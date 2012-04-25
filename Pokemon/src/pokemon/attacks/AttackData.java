package pokemon.attacks;

import pokemon.Type;

public enum AttackData {
	SCRATCH("Arañazo",40,100,Type.NORMAL,35),
	GROWL("Gruñido",0,0,Type.NORMAL,40,new AttackEffect(StatsEffect.ATTACK_DOWN,true)),
	TACKLE("Placaje",35,95,Type.NORMAL,35), 
	LEER("Latigo",0,0,Type.NORMAL,30,new AttackEffect(StatsEffect.DEFENSE_DOWN,true)),
	QUICK_ATTACK("At. Rapido",40,0,Type.NORMAL,20,AttackSpeed.FAST);
	private boolean selfAttack;
	private String name;
	private int power;
	private int accuracy;
	private Type type;
	private int iniPP;
	private AttackEffect attackEffect;
	private AttackSpeed attackSpeed;
	
	private AttackData(String name,int power, int accuracy, Type type, int iniPP)
	{
		this(name, power, accuracy, type, iniPP, null, AttackSpeed.NORMAL, false);
	}
	private AttackData(String name,int power, int accuracy, Type type, int iniPP, AttackSpeed attackSpeed)
	{
		this(name, power, accuracy, type, iniPP, null, attackSpeed, false);
	}
	private AttackData(String name,int power, int accuracy, Type type, int iniPP, boolean selfAttack)
	{
		this(name, power, accuracy, type, iniPP, null, AttackSpeed.NORMAL, selfAttack);
	}
	private AttackData(String name,int power, int accuracy, Type type, int iniPP, AttackEffect attackEffect)
	{
		this(name, power, accuracy, type, iniPP, attackEffect, AttackSpeed.NORMAL, false);
	}
	private AttackData(String name,int power, int accuracy, Type type, int iniPP, AttackSpeed attackSpeed, boolean selfAttack)
	{
		this(name, power, accuracy, type, iniPP, null, AttackSpeed.NORMAL, selfAttack);
	}
	private AttackData(String name, int power, int accuracy, Type type, int iniPP, AttackEffect attackEffect, AttackSpeed attackSpeed)
	{
		this(name, power, accuracy, type, iniPP, attackEffect, attackSpeed, false);
	}
	private AttackData(String name, int power, int accuracy, Type type, int iniPP, AttackEffect attackEffect, boolean selfAttack)
	{
		this(name, power, accuracy, type, iniPP, attackEffect, AttackSpeed.NORMAL, selfAttack);
	}
	private AttackData(String name, int power, int accuracy, Type type, int iniPP, AttackEffect attackEffect, AttackSpeed attackSpeed ,boolean selfAttack)
	{
		this.name = name;
		this.power = power;
		this.accuracy = accuracy;
		this.type = type;
		this.iniPP = iniPP;
		this.attackEffect = attackEffect;
		this.attackSpeed = attackSpeed;
		this.selfAttack = selfAttack;
	}
	public String getName() {
		return name;
	}
	public int getPower() {
		return power;
	}
	public int getAccuracy() {
		return accuracy;
	}
	public Type getType() {
		return type;
	}
	public int getIniPP() {
		return iniPP;
	}
	public AttackEffect getAttackEffect() {
		return attackEffect;
	}
	public boolean isSelfAttack(){
		return selfAttack;
	}
	public AttackSpeed getAttackSpeed() {
		return attackSpeed;
	}
}
