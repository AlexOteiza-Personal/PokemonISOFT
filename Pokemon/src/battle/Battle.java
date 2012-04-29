package battle;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

import player.PlayerPokemonList;
import pokemon.*;
import pokemon.attacks.*;

public class Battle {
	public static final int POKEMON_APPEAR = 1;
	public static final int PLAYER_SEND_POKEMON = 2;
	
	public static final int SELECT_ACTION = 10;
	private static final int ESCAPE_FAIL = 20;
	private static final int ESCAPE_SUCESS = 21;

	
	private boolean playerPokemonConfused=false;
	private boolean enemyPokemonConfused=false;
	private int escapeTries = 0;
	
	private BufferedImage playerImage;
	private PlayerPokemonList playerPokemonList;
	
	BattlePokemon playerPokemon;
	BattlePokemon enemyPokemon;
	
	private Turn turn;
	
	private Random randomizer;
	
	
	public Battle(Pokemon enemy) throws Exception {
		playerPokemonList = PlayerPokemonList.getPlayerpokemonlist();
		playerPokemon = new BattlePokemon(playerPokemonList.getPokemon(0),true);
		enemyPokemon = new BattlePokemon(enemy,false);
		turn = new Turn(playerPokemon, null, enemyPokemon, null);
		randomizer = new Random();
		//test();
	}
	public void test() throws NumberFormatException, IOException{
		
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PokemonAttacks attacks = playerPokemon.getPokemon().getAttacks();
		System.out.println("¡Un "+enemyPokemon.getPokemon().getName()+" salvaje aparecio!");
		boolean fainted = false;
		while(!fainted)
		{
			System.out.println("Elige accion:\n1:"+attacks.getAttack(0).getName()+"\n2:"+
			attacks.getAttack(1).getName()+"\n3:"+attacks.getAttack(2).getName()+"\n4:"+attacks.getAttack(3).getName());
			int selection = Integer.parseInt(in.readLine());
			if(selection>=4)
				selection = 3;
			Attack nextAttack = attacks.getAttack(selection+1);
			Attack cpuNextAttack = enemyPokemon.getPokemon().getAttacks().getAttack(1);
			
			turn = new Turn(playerPokemon, nextAttack,enemyPokemon, cpuNextAttack);
			setTurn(nextAttack, cpuNextAttack);
			
			BattlePokemon attacker = turn.getAttacker();
			BattlePokemon deffender = turn.getDeffender();

			if(attacker.isPlayer())
				System.out.println(attacker.getPokemon().getName()+ " uso "+ turn.getFirstAttack().getName());
			else
				System.out.println("ENEM. "+attacker.getPokemon().getName()+ " uso "+ turn.getFirstAttack().getName());
			
			AttackResult atkresult = attack(turn.getFirstAttack(),attacker,deffender);
			

			System.out.println("Ataque hizo: "+atkresult.getDamage()+" de dano");
			if(atkresult.isCritical())
				System.out.println("¡Golpe critico!");
			System.out.println("Pressina enter...");in.readLine();
			
			if(attacker.getPokemon().getCurrentHp()<=0)
			{
				fainted = true;
				System.out.println(attacker+ " se demayo");
				return;
			}
			else if(deffender.getPokemon().getCurrentHp()<=0)
			{
				fainted = true;
				System.out.println(deffender+ " se demayo");
				return;
			}
			
			AttackResult atkresult2 = attack(turn.getSecondAttack(),deffender,attacker);
			if(deffender.isPlayer())
				System.out.println(deffender.getPokemon().getName()+ " uso "+ turn.getSecondAttack().getName());
			else
				System.out.println("ENEM. "+deffender.getPokemon().getName()+ " uso "+ turn.getSecondAttack().getName());
			System.out.println("Ataque hizo: "+atkresult2.getDamage()+" de dano");
			if(atkresult2.isCritical())
				System.out.println("¡Golpe critico!");
			System.out.println("Pressina enter...");in.readLine();

			if(attacker.getPokemon().getCurrentHp()<=0)
			{
				fainted = true;
				System.out.println(attacker+ " se demayo");
			}
			else if(deffender.getPokemon().getCurrentHp()<=0)
			{
				fainted = true;
				System.out.println(deffender+ " se demayo");
			}
		}
	}

	private AttackResult attack(Attack atk,BattlePokemon bAttacker,BattlePokemon bDeffender)
	{
		Pokemon attacker = bAttacker.getPokemon();
		Pokemon deffender = bDeffender.getPokemon();
		
		BattleStats atStats = bAttacker.getTmpStats();
		BattleStats dfStats = bDeffender.getTmpStats();
		
		AttackResult result=new AttackResult();
		atk.decreasePP();
		boolean selfAttack = atk.isSelfAttack();
		if(!selfAttack){
			boolean doAttack = false;
			int posibility = getPosibility(atk, atStats, dfStats);
			int randomnum = randomizer.nextInt(100);
			if(randomnum<=posibility)
				doAttack = true;
			else
				doAttack = false;
			if(doAttack){
				int damage = getDamage(atk, bAttacker, bDeffender, result);
				deffender.dealDamage(damage);
				result.setDamage(damage);
			}
			return result;
		}
		else
			return null;
	}
	
	public boolean doStatsEffect(Attack atk, BattleStats atStats, BattleStats dfStats){
		AttackEffect effect = atk.getAttackEffect();
		StatsEffect statsEffect = effect.getStatsEffect();
		boolean worked = false;
		boolean selfEffect = effect.isSelfEffect();
		BattleStats affected = null;
		if(selfEffect)	affected = atStats;
		else			affected = dfStats;
		
		switch(statsEffect)
		{
		case ATTACK_DOWN: 	worked = affected.decreaseAttack();break;
		case ATTACK_UP:		worked = affected.increaseAttack();break;
		case DEFENSE_DOWN: 	worked = affected.decreaseDefense();break;
		case DEFENSE_UP: 	worked = affected.increaseDefense();break;
		case SPEED_DOWN:  	worked = affected.decreaseSpeed();break;
		case SPEED_UP: 		worked = affected.increaseSpeed();break;
		case EVASION_DOWN: 	worked = affected.decreaseEvasion();break;
		case EVASION_UP: 	worked = affected.increaseEvasion();break;
		case ACCURACY_DOWN:	worked = affected.decreaseAccuracy();break;
		case ACCURACY_UP: 	worked = affected.increaseAccuracy();break;
		default:break;
		}
		return worked;
	}
	
	// OK //
	/*
	 * Returns if the status effect has worked
	 */
	public boolean doStatusEffect(Attack atk, Pokemon attacker, Pokemon deffender)
	{
		AttackEffect effect = atk.getAttackEffect();
		StatusEffect statusEffect = effect.getStatusEffect();
		boolean selfEffect = effect.isSelfEffect();
		Pokemon affected = null;
		if(selfEffect)	affected = attacker;
		else			affected = deffender;
		
		boolean doStatusEffect=false;
		if(statusEffect.getPosibility()==100)
			doStatusEffect = true;
		else
		{
			int randomnum = randomizer.nextInt(100);
			if(randomnum<=statusEffect.getPosibility())
				doStatusEffect = true;
			else
				doStatusEffect = false;
		}
		if(doStatusEffect)
		{
			switch(statusEffect.getStatusEffect())
			{
			case POISON: affected.setStatus(PokemonStatus.POISON);break;
			case BURN: affected.setStatus(PokemonStatus.BURN);break;
			//case CONFUSION: affected.setStatus(PokemonStatus.CONFUSION);break;
			case PARALYZE: affected.setStatus(PokemonStatus.PARALYZE);break;
			case FROZE:  affected.setStatus(PokemonStatus.FROZE);break;
			default:break;
			}
		}
		return doStatusEffect;
	}
	// OK //
	public int getPosibility(Attack atk, BattleStats atStats, BattleStats dfStats){
		double atAccuracy = atk.getAccuracy();
		double plAccuracy = atStats.getAccuracy();
		double enEvasion = dfStats.getEvasion();
		return (int)Math.floor(atAccuracy*(plAccuracy/enEvasion));
	}
	
	/*
	 *            (2*level+10)    Attack
	 * Formula= ( ------------ x -------- x Base + 2) x STAB x Efectiveness x Critical x(rand[0.85,1])
	 *               250         Defense
	 *
	 * STAB = If attack is same type as attacker then 1.5, else 1
	 * Efectiveness:
	 *     ·  Super efective: 2
	 *     ·  Normal: 1
	 *     ·  Not very efective: 0.5
	 *     ·  Doesnt affect: 0
	 * 
	 * Critical: 2 if critical, 1 otherwise
	 * 
	 */
	// //
	private int getDamage(Attack atk, BattlePokemon bAttacker, BattlePokemon bDeffender, AttackResult result)  {
		if(atk.getPower()==0)
			return 0;
		Pokemon attacker = bAttacker.getPokemon();
		Pokemon deffender = bDeffender.getPokemon();

		BattleStats atStats = bAttacker.getTmpStats();
		BattleStats dfStats = bDeffender.getTmpStats();

		double level = attacker.getLevel();
		double atAttack = atStats.getAttack();
		double reDefense = dfStats.getDefense();
		double base = atk.getPower();
		double stab = 1;
		if(attacker.getType1()==atk.getType())
			stab = 1.5;
		else if(attacker.getType2()!= null) 
			if(attacker.getType2()==atk.getType())
				stab = 1.5;
		
		double efectiveness = 1;
		Effectiveness ef = TypeEffectiveness.getEffectiveness().getEffectiveness(atk.getType(), deffender.getPokemonType());
		result.setEffectiveness(ef);
		switch(ef)
		{
			case NOT_AFFECTED: efectiveness = 0;break;
			case NOT_EFFECTIVE: efectiveness = 0.25;break;
			case NOT_VERY_EFFECTIVE: efectiveness = 0.5;break;
			case NORMAL: efectiveness = 1;break;
			case VERY_EFFECTIVE: efectiveness = 2;break;
			case ULTRA_EFFECTIVE: efectiveness = 4;break;
			default: efectiveness = 1;break;
		}
		// Uno entre 10 posibilidad de critico
		boolean isCritical = randomizer.nextInt(10)==0;
		result.setCritical(isCritical);
		double critDamage;
		if(isCritical)
			critDamage = 2;
		else
			critDamage = 1;
		
		double randNum = (double)(85+(randomizer.nextInt(17)))/100;
		int damage = (int)Math.floor(
				(((2*level+10)/250)*
				(atAttack/reDefense)*base+2)*
				(stab*efectiveness*critDamage*randNum)
				);
		// Al menos hace 1 de dano
		if(damage<=0)
			damage=1;
		return damage;
	}
	
	private void setTurn(Attack atk1,Attack atk2) {
		int speed1 = playerPokemon.getTmpStats().getSpeed();
		int speed2 = enemyPokemon.getTmpStats().getSpeed();
		
		PokemonStatus pk1Status = playerPokemon.getPokemon().getStatus();
		PokemonStatus pk2Status = enemyPokemon.getPokemon().getStatus();
		
		AttackSpeed atk1Speed = atk1.getAttackSpeed();
		AttackSpeed atk2Speed = atk2.getAttackSpeed();
		
		if(pk1Status == PokemonStatus.PARALYZE)
			speed1 = speed1/50;
		if(pk2Status == PokemonStatus.PARALYZE)
			speed2 = speed2/50;
		
		if(atk1Speed==atk2Speed)
		{
			if(speed1>=speed2)
				turn.setTurn(playerPokemon,atk1,enemyPokemon,atk2);
			else
				turn.setTurn(enemyPokemon,atk2,playerPokemon,atk1);
		}
		else if(atk1Speed.ordinal()>atk2Speed.ordinal())
		{
			turn.setTurn(playerPokemon,atk1 ,enemyPokemon, atk2);
		}
		else if(atk1Speed.ordinal()<atk2Speed.ordinal())
		{
			turn.setTurn(enemyPokemon, atk2, playerPokemon, atk1);
		}
		else
			System.out.println("ups");
	}
	public Pokemon getPlayerPokemon() {
		return playerPokemon.getPokemon();
	}
	public Pokemon getEnePokemon() {
		return enemyPokemon.getPokemon();
	}
	public String getBattleStart(){
		return "¡Un "+enemyPokemon.getPokemon().getName()+" salvaje aparecio!";
	}
	public String getDialog(int dialog) {
		String rDialog = "";
		switch(dialog)
		{
		case POKEMON_APPEAR:rDialog="¡Un "+ enemyPokemon.getPokemon().getName() +" salvaje!";break;
		case PLAYER_SEND_POKEMON:rDialog="¡Adelante, "+playerPokemon.getPokemon().getName() + "!";break;
		case SELECT_ACTION:rDialog="¿Qué deberia hacer\n"+playerPokemon.getPokemon().getName() +"?";break;
		case ESCAPE_SUCESS:rDialog="¡Escapaste sano y salvo!";break;
		case ESCAPE_FAIL:rDialog="¡No has podido escapar!";break;
		default:rDialog="";break;
		}
		return rDialog;
	}
	/*
	 * Formula para escape:
	 *      Pl.Pokemon speed level  x  32
	 * F = ------------------------------- + 30 x Escape trys
	 *       En. Pokemon speed level
	 *
	 * if f > 255 then escapes
	 *                          F
	 * else escape percentage= --- 
	 *                         256
	 * 
	 * 
	 */
	public boolean escape() {
		escapeTries++;
		int b = enemyPokemon.getTmpStats().getSpeed()/4;
		int f = ((playerPokemon.getTmpStats().getSpeed()*32)/
				b)+(15*escapeTries);
		System.out.println(playerPokemon.getTmpStats().getSpeed());
		System.out.println(enemyPokemon.getTmpStats().getSpeed());
		System.out.println(f);
		if(f<255)
		{
			double probability = (double)f/256;
			if(randomizer.nextInt(100)<=(probability*100))
				return true;
			else
				return false;
		}
		else
		{
			return true;
		}
	}
	
}
