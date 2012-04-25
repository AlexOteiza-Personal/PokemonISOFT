package pokemon;

import images.ImageData;

import java.io.IOException;

import pokemon.attacks.AttackData;
import pokemon.attacks.LearnAttackList;
/**
 * Contains non-modificable data of the Pokemon
 * @author Alejandro
 * @see Pokemon
 */
public enum PokemonData {
	Bulbasaur(1,"BULBASAUR",Type.NORMAL ,Type.POISON,LearnAttackList.Bulbasaur,new PokemonStats(45,49,49,45),new ImageData(null,"/images/pokemon/front/001.png","/images/pokemon/back/001.png")),
	Ekans	 (2,"EKANS",Type.POISON,null,LearnAttackList.Ekans,new PokemonStats(35,60,44,55),new ImageData(null,"/images/pokemon/front/002.png","/images/pokemon/back/002.png")),
	Diglett  (3,"DIGLETT",Type.GROUND,null,LearnAttackList.Diglett,new PokemonStats(10,55,25,95),new ImageData(null,"/images/pokemon/front/003.png","/images/pokemon/back/003.png")),
	Rattata  (4,"RATTATA",Type.NORMAL,null,LearnAttackList.Rattata,new PokemonStats(30,56,35,72),new ImageData(null,"/images/pokemon/front/004.png","/images/pokemon/back/004.png")),
	Weedle	 (5,"WEEDLE",Type.BUG,Type.POISON,LearnAttackList.Weedle,new PokemonStats(40,35,30,50),new ImageData(null,"/images/pokemon/front/005.png","/images/pokemon/back/005.png")),
	Abra	 (6,"ABRA",Type.PSYCHIC,null,LearnAttackList.Abra,new PokemonStats(25,20,15,90),new ImageData(null,"/images/pokemon/front/006.png","/images/pokemon/back/006.png")),
	Dodrio	 (7,"DODRIO",Type.NORMAL,Type.FLYING,LearnAttackList.Dodrio,new PokemonStats(60,110,70,100),new ImageData(null,"/images/pokemon/front/007.png","/images/pokemon/back/007.png")),
	Pidgey	 (8,"PIDGEY",Type.NORMAL,Type.FLYING,LearnAttackList.Pidgey,new PokemonStats(40,45,40,56),new ImageData(null,"/images/pokemon/front/008.png","/images/pokemon/back/008.png")),
	Arcanine (9,"ARCANINE",Type.FIRE,null,LearnAttackList.Arcanine,new PokemonStats(90,110,80,95),new ImageData(null,"/images/pokemon/front/009.png","/images/pokemon/back/009.png")),
	Mew	     (10,"MEW",Type.PSYCHIC,null,LearnAttackList.Mew,new PokemonStats(100,100,100,100),new ImageData(null,"/images/pokemon/front/010.png","/images/pokemon/back/010.png"));
	
	/** The Pokemon id */
	private int id;
	/** Pokemon name */
	private String name;
	/** First Pokemon type */
	private PokemonType type;
	/** Pokemon Base stats */
	private PokemonStats baseStats;
	/** Pokemon Attack data */
	private LearnAttackList learnAttackList;
	/** Pokemon Imagedata containing images */
	private ImageData imageData;
	
	/**
	 * Creates a new Pokemon data with the given values
	 * @param id Pokemon id, an integer greater than 0
	 * @param name Pokemon name  
	 * @param type1 First Pokemon type
	 * @param type2 Second Pokemon type
	 * @param imageData Pokemon image data
	 */
	private PokemonData(int id, String name, Type type1, Type type2, LearnAttackList learnAttackList ,
			PokemonStats baseStats,ImageData imageData){
		this.id = id;
		this.name = name;
		this.type = new PokemonType(type1,type2);
		this.learnAttackList = learnAttackList;
		this.baseStats = baseStats;
		this.imageData = imageData;
	}

	/**
	 * Returns the Pokemon's id
	 * @return an integer containing the Pokemon's id
	 */
	public int getId() {
		return id;
	}
	public String getIdString() {
		int ciphers = 3;
		int tmpid = id;
		String idString = "";
		while(tmpid !=0)
		{
			ciphers--;
			tmpid = tmpid/10;
		}
		for (int i = 0; i < ciphers; i++) {
			idString += "0";
		}
		idString += id;
		return idString;
	}
	/**
	 * Returns the Pokemon's name
	 * @return a String containing Pokemon's name
	 */
	public String getName() {
		return name;
	}
	/**
	 * Returns the Pokemon's first type
	 * @return a Type object containing Pokemon's first type
	 */
	public Type getType1() {
		return type.getType1();
	}
	/**
	 * Returns the Pokemon's second type
	 * @return a Type object containing Pokemon's second type
	 */
	public Type getType2() {
		return type.getType2();
	}
	/**
	 * Returns the Pokemon's image data
	 * @return an ImageData object containing the Pokemon's image data 
	 */
	public ImageData getImageData() {
		return imageData;
	}
	/**
	 * Returns the Pokemon's initial stats
	 * @return a PokemonStats object containing the Pokemon's base stats values
	 */
	
	public PokemonStats getBaseStats() {
		return baseStats;
	}
	
	public PokemonType getType(){
		return this.type;
	}
	
	public LearnAttackList getLearnAttackList() {
		return learnAttackList;
	}
}