package pokemon.attacks;

import pokemon.Type;

public enum AttackData {
	SCRATCH("Arañazo",40,100,Type.NORMAL,35),
	GROWL("Gruñido",0,0,Type.NORMAL,40),
	TACKLE("Placaje",35,95,Type.NORMAL,35),
	LEER("Latigo",0,0,Type.NORMAL,30);
	
	private String name;
	private int power;
	private int accuracy;
	private Type type;
	private int iniPP;
	private StatusEffect enemyStatusEffect;
	
	private AttackData(String name,int power, int accuracy, Type type, int iniPP)
	{
		this(name,power,accuracy,type,iniPP,null);
	}
	private AttackData(String name, int power, int accuracy, Type type, int iniPP, StatusEffect enemyStatusEffect)
	{
		this.name = name;
		this.power = power;
		this.accuracy = accuracy;
		this.type = type;
		this.iniPP = iniPP;
		this.enemyStatusEffect = enemyStatusEffect;
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
	public StatusEffect getEnemyStatusEffect() {
		return enemyStatusEffect;
	}
}
