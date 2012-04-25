package pokemon;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import static pokemon.Type.*;
public class TypeEffectiveness {
	/*
	NORMAL("Normal"),
	FIRE("Fuego"),
	WATER("Agua"),
	ELECTRIC("Electrico"),
	GRASS("Planta"),
	ICE("Hielo"),
	FIGHTING("Lucha"),
	POISON("Veneno"),
	GROUND("Tierra"),
	FLYING("Volador"),
	PSYCHIC("Psiquico"),
	BUG("Bicho"),
	ROCK("Roca"),
	GHOST("Fantasma");
	*/
	private static final TypeEffectiveness mInstance = new TypeEffectiveness();
	private Map<PokemonType,Effectiveness> typeTable;
	private TypeEffectiveness() {
		
		
		typeTable = new HashMap<PokemonType, Effectiveness>();
								  //atacker //defender
		typeTable.put(new PokemonType(NORMAL,NORMAL), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(NORMAL,FIRE), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(NORMAL,WATER), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(NORMAL,ELECTRIC), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(NORMAL,GRASS), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(NORMAL,ICE), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(NORMAL,FIGHTING), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(NORMAL,POISON), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(NORMAL,GROUND), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(NORMAL,FLYING), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(NORMAL,PSYCHIC), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(NORMAL,BUG), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(NORMAL,ROCK), Effectiveness.NOT_VERY_EFFECTIVE);
		typeTable.put(new PokemonType(NORMAL,GHOST), Effectiveness.NOT_AFFECTED);
		typeTable.put(new PokemonType(NORMAL,DRAGON), Effectiveness.NORMAL);
		// OK //
		
		typeTable.put(new PokemonType(FIRE,NORMAL), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(FIRE,FIRE), Effectiveness.NOT_VERY_EFFECTIVE);
		typeTable.put(new PokemonType(FIRE,WATER), Effectiveness.NOT_VERY_EFFECTIVE);
		typeTable.put(new PokemonType(FIRE,ELECTRIC), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(FIRE,GRASS), Effectiveness.VERY_EFFECTIVE);
		typeTable.put(new PokemonType(FIRE,ICE), Effectiveness.VERY_EFFECTIVE);
		typeTable.put(new PokemonType(FIRE,FIGHTING), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(FIRE,POISON), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(FIRE,GROUND), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(FIRE,FLYING), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(FIRE,PSYCHIC), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(FIRE,BUG), Effectiveness.VERY_EFFECTIVE);
		typeTable.put(new PokemonType(FIRE,ROCK), Effectiveness.NOT_VERY_EFFECTIVE);
		typeTable.put(new PokemonType(FIRE,GHOST), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(FIRE,DRAGON), Effectiveness.NOT_VERY_EFFECTIVE);
		// OK //
		
		typeTable.put(new PokemonType(WATER,NORMAL), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(WATER,FIRE), Effectiveness.VERY_EFFECTIVE);
		typeTable.put(new PokemonType(WATER,WATER), Effectiveness.NOT_VERY_EFFECTIVE);
		typeTable.put(new PokemonType(WATER,ELECTRIC), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(WATER,GRASS), Effectiveness.NOT_VERY_EFFECTIVE);
		typeTable.put(new PokemonType(WATER,ICE), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(WATER,FIGHTING), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(WATER,POISON), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(WATER,GROUND), Effectiveness.VERY_EFFECTIVE);
		typeTable.put(new PokemonType(WATER,FLYING), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(WATER,PSYCHIC), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(WATER,BUG), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(WATER,ROCK), Effectiveness.VERY_EFFECTIVE);
		typeTable.put(new PokemonType(WATER,GHOST), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(WATER,DRAGON), Effectiveness.NOT_VERY_EFFECTIVE);
		// OK //
		
		typeTable.put(new PokemonType(ELECTRIC,NORMAL), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(ELECTRIC,FIRE), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(ELECTRIC,WATER), Effectiveness.VERY_EFFECTIVE);
		typeTable.put(new PokemonType(ELECTRIC,ELECTRIC), Effectiveness.NOT_VERY_EFFECTIVE);
		typeTable.put(new PokemonType(ELECTRIC,GRASS), Effectiveness.NOT_VERY_EFFECTIVE);
		typeTable.put(new PokemonType(ELECTRIC,ICE), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(ELECTRIC,FIGHTING), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(ELECTRIC,POISON), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(ELECTRIC,GROUND), Effectiveness.NOT_AFFECTED);
		typeTable.put(new PokemonType(ELECTRIC,FLYING), Effectiveness.VERY_EFFECTIVE);
		typeTable.put(new PokemonType(ELECTRIC,PSYCHIC), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(ELECTRIC,BUG), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(ELECTRIC,ROCK), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(ELECTRIC,GHOST), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(ELECTRIC,DRAGON), Effectiveness.NOT_VERY_EFFECTIVE);
		// OK //
		
		
		typeTable.put(new PokemonType(GRASS,NORMAL), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(GRASS,FIRE), Effectiveness.NOT_VERY_EFFECTIVE);
		typeTable.put(new PokemonType(GRASS,WATER), Effectiveness.VERY_EFFECTIVE);
		typeTable.put(new PokemonType(GRASS,ELECTRIC), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(GRASS,ICE), Effectiveness.NOT_VERY_EFFECTIVE);
		typeTable.put(new PokemonType(GRASS,ICE), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(GRASS,FIGHTING), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(GRASS,POISON), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(GRASS,GROUND), Effectiveness.VERY_EFFECTIVE);
		typeTable.put(new PokemonType(GRASS,FLYING), Effectiveness.NOT_VERY_EFFECTIVE);
		typeTable.put(new PokemonType(GRASS,PSYCHIC), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(GRASS,BUG), Effectiveness.NOT_VERY_EFFECTIVE);
		typeTable.put(new PokemonType(GRASS,ROCK), Effectiveness.VERY_EFFECTIVE);
		typeTable.put(new PokemonType(GRASS,GHOST), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(GRASS,DRAGON), Effectiveness.NOT_VERY_EFFECTIVE);
		// OK, //
		
		typeTable.put(new PokemonType(ICE,NORMAL), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(ICE,FIRE), Effectiveness.NOT_VERY_EFFECTIVE);
		typeTable.put(new PokemonType(ICE,WATER), Effectiveness.NOT_VERY_EFFECTIVE);
		typeTable.put(new PokemonType(ICE,ELECTRIC), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(ICE,GRASS), Effectiveness.VERY_EFFECTIVE);
		typeTable.put(new PokemonType(ICE,ICE), Effectiveness.NOT_VERY_EFFECTIVE);
		typeTable.put(new PokemonType(ICE,FIGHTING), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(ICE,POISON), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(ICE,GROUND), Effectiveness.VERY_EFFECTIVE);
		typeTable.put(new PokemonType(ICE,FLYING), Effectiveness.VERY_EFFECTIVE);
		typeTable.put(new PokemonType(ICE,PSYCHIC), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(ICE,BUG), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(ICE,ROCK), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(ICE,GHOST), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(ICE,DRAGON), Effectiveness.VERY_EFFECTIVE);
		// OK //
		
		
		typeTable.put(new PokemonType(FIGHTING,NORMAL), Effectiveness.VERY_EFFECTIVE);
		typeTable.put(new PokemonType(FIGHTING,FIRE), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(FIGHTING,WATER), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(FIGHTING,ELECTRIC), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(FIGHTING,GRASS), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(FIGHTING,ICE), Effectiveness.VERY_EFFECTIVE);
		typeTable.put(new PokemonType(FIGHTING,FIGHTING), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(FIGHTING,POISON), Effectiveness.NOT_VERY_EFFECTIVE);
		typeTable.put(new PokemonType(FIGHTING,GROUND), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(FIGHTING,FLYING), Effectiveness.NOT_VERY_EFFECTIVE);
		typeTable.put(new PokemonType(FIGHTING,PSYCHIC), Effectiveness.NOT_VERY_EFFECTIVE);
		typeTable.put(new PokemonType(FIGHTING,BUG), Effectiveness.NOT_VERY_EFFECTIVE);
		typeTable.put(new PokemonType(FIGHTING,ROCK), Effectiveness.VERY_EFFECTIVE);
		typeTable.put(new PokemonType(FIGHTING,GHOST), Effectiveness.NOT_AFFECTED);
		typeTable.put(new PokemonType(FIGHTING,DRAGON), Effectiveness.NORMAL);
		// OK //
		
		
		typeTable.put(new PokemonType(POISON,NORMAL), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(POISON,FIRE), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(POISON,WATER), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(POISON,ELECTRIC), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(POISON,GRASS), Effectiveness.VERY_EFFECTIVE);
		typeTable.put(new PokemonType(POISON,ICE), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(POISON,FIGHTING), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(POISON,POISON), Effectiveness.NOT_VERY_EFFECTIVE);
		typeTable.put(new PokemonType(POISON,GROUND), Effectiveness.NOT_VERY_EFFECTIVE);
		typeTable.put(new PokemonType(POISON,FLYING), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(POISON,PSYCHIC), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(POISON,BUG), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(POISON,ROCK), Effectiveness.NOT_VERY_EFFECTIVE);
		typeTable.put(new PokemonType(POISON,GHOST), Effectiveness.NOT_VERY_EFFECTIVE);
		typeTable.put(new PokemonType(POISON,DRAGON), Effectiveness.NORMAL);
		// OK //
		
		
		typeTable.put(new PokemonType(GROUND,NORMAL), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(GROUND,FIRE), Effectiveness.VERY_EFFECTIVE);
		typeTable.put(new PokemonType(GROUND,WATER), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(GROUND,ELECTRIC), Effectiveness.VERY_EFFECTIVE);
		typeTable.put(new PokemonType(GROUND,GRASS), Effectiveness.NOT_VERY_EFFECTIVE);
		typeTable.put(new PokemonType(GROUND,ICE), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(GROUND,FIGHTING), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(GROUND,POISON), Effectiveness.VERY_EFFECTIVE);
		typeTable.put(new PokemonType(GROUND,GROUND), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(GROUND,FLYING), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(GROUND,PSYCHIC), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(GROUND,BUG), Effectiveness.NOT_VERY_EFFECTIVE);
		typeTable.put(new PokemonType(GROUND,ROCK), Effectiveness.VERY_EFFECTIVE);
		typeTable.put(new PokemonType(GROUND,GHOST), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(GROUND,DRAGON), Effectiveness.NORMAL);
		// OK //
		
		
		typeTable.put(new PokemonType(FLYING,NORMAL), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(FLYING,FIRE), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(FLYING,WATER), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(FLYING,ELECTRIC), Effectiveness.NOT_VERY_EFFECTIVE);
		typeTable.put(new PokemonType(FLYING,GRASS), Effectiveness.VERY_EFFECTIVE);
		typeTable.put(new PokemonType(FLYING,ICE), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(FLYING,FIGHTING), Effectiveness.VERY_EFFECTIVE);
		typeTable.put(new PokemonType(FLYING,POISON), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(FLYING,GROUND), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(FLYING,FLYING), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(FLYING,PSYCHIC), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(FLYING,BUG), Effectiveness.VERY_EFFECTIVE);
		typeTable.put(new PokemonType(FLYING,ROCK), Effectiveness.NOT_VERY_EFFECTIVE);
		typeTable.put(new PokemonType(FLYING,GHOST), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(FLYING,DRAGON), Effectiveness.NORMAL);
		// OK //
		
		
		typeTable.put(new PokemonType(PSYCHIC,NORMAL), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(PSYCHIC,FIRE), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(PSYCHIC,WATER), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(PSYCHIC,ELECTRIC), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(PSYCHIC,GRASS), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(PSYCHIC,ICE), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(PSYCHIC,FIGHTING), Effectiveness.VERY_EFFECTIVE);
		typeTable.put(new PokemonType(PSYCHIC,POISON), Effectiveness.VERY_EFFECTIVE);
		typeTable.put(new PokemonType(PSYCHIC,GROUND), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(PSYCHIC,FLYING), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(PSYCHIC,PSYCHIC), Effectiveness.NOT_VERY_EFFECTIVE);
		typeTable.put(new PokemonType(PSYCHIC,BUG), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(PSYCHIC,ROCK), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(PSYCHIC,GHOST), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(PSYCHIC,DRAGON), Effectiveness.NORMAL);
		// OK //
		
		typeTable.put(new PokemonType(BUG,NORMAL), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(BUG,FIRE), Effectiveness.NOT_VERY_EFFECTIVE);
		typeTable.put(new PokemonType(BUG,WATER), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(BUG,ELECTRIC), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(BUG,GRASS), Effectiveness.VERY_EFFECTIVE);
		typeTable.put(new PokemonType(BUG,ICE), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(BUG,FIGHTING), Effectiveness.NOT_VERY_EFFECTIVE);
		typeTable.put(new PokemonType(BUG,POISON), Effectiveness.NOT_VERY_EFFECTIVE);
		typeTable.put(new PokemonType(BUG,GROUND), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(BUG,FLYING), Effectiveness.NOT_VERY_EFFECTIVE);
		typeTable.put(new PokemonType(BUG,PSYCHIC), Effectiveness.VERY_EFFECTIVE);
		typeTable.put(new PokemonType(BUG,BUG), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(BUG,ROCK), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(BUG,GHOST), Effectiveness.NOT_VERY_EFFECTIVE);
		typeTable.put(new PokemonType(BUG,DRAGON), Effectiveness.NORMAL);
		// OK //
		
		typeTable.put(new PokemonType(ROCK,NORMAL), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(ROCK,FIRE), Effectiveness.VERY_EFFECTIVE);
		typeTable.put(new PokemonType(ROCK,WATER), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(ROCK,ELECTRIC), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(ROCK,GRASS), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(ROCK,ICE), Effectiveness.VERY_EFFECTIVE);
		typeTable.put(new PokemonType(ROCK,FIGHTING), Effectiveness.NOT_VERY_EFFECTIVE);
		typeTable.put(new PokemonType(ROCK,POISON), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(ROCK,GROUND), Effectiveness.NOT_VERY_EFFECTIVE);
		typeTable.put(new PokemonType(ROCK,FLYING), Effectiveness.VERY_EFFECTIVE);
		typeTable.put(new PokemonType(ROCK,PSYCHIC), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(ROCK,BUG), Effectiveness.VERY_EFFECTIVE);
		typeTable.put(new PokemonType(ROCK,ROCK), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(ROCK,GHOST), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(ROCK,DRAGON), Effectiveness.NORMAL);
		// OK //
		typeTable.put(new PokemonType(GHOST,NORMAL), Effectiveness.NOT_AFFECTED);
		typeTable.put(new PokemonType(GHOST,FIRE), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(GHOST,WATER), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(GHOST,ELECTRIC), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(GHOST,GRASS), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(GHOST,ICE), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(GHOST,FIGHTING), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(GHOST,POISON), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(GHOST,GROUND), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(GHOST,FLYING), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(GHOST,PSYCHIC), Effectiveness.VERY_EFFECTIVE);
		typeTable.put(new PokemonType(GHOST,BUG), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(GHOST,ROCK), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(GHOST,GHOST), Effectiveness.VERY_EFFECTIVE);
		typeTable.put(new PokemonType(GHOST,DRAGON), Effectiveness.NORMAL);
		// OK //
		typeTable.put(new PokemonType(DRAGON,NORMAL), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(DRAGON,FIRE), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(DRAGON,WATER), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(DRAGON,ELECTRIC), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(DRAGON,GRASS), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(DRAGON,ICE), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(DRAGON,FIGHTING), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(DRAGON,POISON), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(DRAGON,GROUND), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(DRAGON,FLYING), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(DRAGON,PSYCHIC), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(DRAGON,BUG), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(DRAGON,ROCK), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(DRAGON,GHOST), Effectiveness.NORMAL);
		typeTable.put(new PokemonType(DRAGON,DRAGON), Effectiveness.VERY_EFFECTIVE);
		// OK //
	}
	public Effectiveness getEffectiveness(Type attackType, PokemonType defenseType){
		PokemonType type = new PokemonType(Type.DRAGON, Type.NORMAL);//attackType,defenseType.getType1());
		Effectiveness ef1 = typeTable.get(type);
		
		if(defenseType.getType2()!=null){
			Effectiveness finalEffectiveness;
			Effectiveness ef2 = typeTable.get(new PokemonType(attackType,defenseType.getType2()));

			/* Si en algun caso no afecta, el ataque ya no afecta */
			if(ef1 == Effectiveness.NOT_AFFECTED || ef2 == Effectiveness.NOT_AFFECTED)
				finalEffectiveness = Effectiveness.NOT_AFFECTED;
			/* Misma efectividad combinada */
			else if(ef1 == Effectiveness.NORMAL && ef2 == Effectiveness.NORMAL)
				finalEffectiveness = Effectiveness.NORMAL;
			
			else if(ef1 == Effectiveness.VERY_EFFECTIVE && ef2 == Effectiveness.VERY_EFFECTIVE)
				finalEffectiveness = Effectiveness.ULTRA_EFFECTIVE;
			
			else if(ef1 == Effectiveness.NOT_VERY_EFFECTIVE && ef2 == Effectiveness.NOT_VERY_EFFECTIVE)
				finalEffectiveness = Effectiveness.NOT_EFFECTIVE;
			
			/* Combinaciones de distinta efectividad */
			else if((ef1 == Effectiveness.VERY_EFFECTIVE && ef2 == Effectiveness.NORMAL) ||
					(ef1 == Effectiveness.NORMAL &&  ef2 == Effectiveness.VERY_EFFECTIVE))
				finalEffectiveness = Effectiveness.VERY_EFFECTIVE;
			
			else if((ef1 == Effectiveness.NOT_VERY_EFFECTIVE && ef2 == Effectiveness.NORMAL) ||
					(ef1 == Effectiveness.NORMAL &&  ef2 == Effectiveness.NOT_VERY_EFFECTIVE))
				finalEffectiveness = Effectiveness.NOT_VERY_EFFECTIVE;
			
			else if((ef1 == Effectiveness.NOT_VERY_EFFECTIVE && ef2 == Effectiveness.VERY_EFFECTIVE) ||
					(ef1 == Effectiveness.VERY_EFFECTIVE &&  ef2 == Effectiveness.NOT_VERY_EFFECTIVE))
				finalEffectiveness = Effectiveness.NORMAL;
			else
				finalEffectiveness = ef1;
			
			return finalEffectiveness;
		}	
		else
			return ef1;
	}
	public static TypeEffectiveness getEffectiveness()
	{
		return mInstance;
	}
	
}
