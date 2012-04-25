package battle;

import pokemon.Pokemon;
import pokemon.PokemonStatus;
import pokemon.attacks.Attack;
import pokemon.attacks.AttackSpeed;

public class Turn {
	private BattlePokemon first;
	private Attack firstAttack;
	private BattlePokemon second;
	private Attack secondAttack;

	public Turn(BattlePokemon first, Attack firstAttack, BattlePokemon second, Attack secondAttack) {
		this.first = first;
		this.firstAttack = firstAttack;
		this.second = second;
		this.secondAttack = secondAttack;
	}
	public BattlePokemon getAttacker(){
		return first;
	}
	public BattlePokemon getDeffender(){
		return second;
	}
	public Attack getFirstAttack() {
		return firstAttack;
	}
	public Attack getSecondAttack() {
		return secondAttack;
	}
	public void setTurn(BattlePokemon first, Attack firstAttack, BattlePokemon second, Attack secondAttack)
	{
		this.first = first;
		this.firstAttack = firstAttack;
		this.second = second;
		this.secondAttack = secondAttack;
	}
}
