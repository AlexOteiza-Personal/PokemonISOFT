package pokemon;

import images.ImageData;

import java.io.IOException;

import javax.sound.sampled.Clip;

import pokemon.attacks.AttackData;
import pokemon.attacks.LearnAttackList;
import sounds.SoundData;
/**
 * Contains non-modificable data of the Pokemon
 * @author Alejandro
 * @see Pokemon
 */
public enum PokemonData {
	Bulbasaur(1,"BULBASAUR",Type.NORMAL ,Type.POISON,LearnAttackList.Bulbasaur,new PokemonStats(45,49,49,45),ImageData.getInstance(ImageData.BULBASAUR),SoundData.getInstance(SoundData.BULBASAUR)),
	Ekans	 (2,"EKANS",Type.POISON,null,LearnAttackList.Ekans,new PokemonStats(35,60,44,55),ImageData.getInstance(ImageData.EKANS)),
	Diglett  (3,"DIGLETT",Type.GROUND,null,LearnAttackList.Diglett,new PokemonStats(10,55,25,95),ImageData.getInstance(ImageData.DIGLETT)),
	Rattata  (4,"RATTATA",Type.NORMAL,null,LearnAttackList.Rattata,new PokemonStats(30,56,35,72),ImageData.getInstance(ImageData.RATTATA)),
	Weedle	 (5,"WEEDLE",Type.BUG,Type.POISON,LearnAttackList.Weedle,new PokemonStats(40,35,30,50),ImageData.getInstance(ImageData.WEEDLE)),
	Abra	 (6,"ABRA",Type.PSYCHIC,null,LearnAttackList.Abra,new PokemonStats(25,20,15,90),ImageData.getInstance(ImageData.ABRA)),
	Dodrio	 (7,"DODRIO",Type.NORMAL,Type.FLYING,LearnAttackList.Dodrio,new PokemonStats(60,110,70,100),ImageData.getInstance(ImageData.DODRIO)),
	Pidgey	 (8,"PIDGEY",Type.NORMAL,Type.FLYING,LearnAttackList.Pidgey,new PokemonStats(40,45,40,56),ImageData.getInstance(ImageData.PIDGEY)),
	Arcanine (9,"ARCANINE",Type.FIRE,null,LearnAttackList.Arcanine,new PokemonStats(90,110,80,95), ImageData.getInstance(ImageData.ARCANINE)),
	Mew	     (10,"MEW",Type.PSYCHIC,null,LearnAttackList.Mew,new PokemonStats(100,100,100,100), ImageData.getInstance(ImageData.MEW));
	
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
	
	private SoundData soundData;
	
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
		this(id,name,type1,type2,learnAttackList,baseStats,imageData,null);
	}
	private PokemonData(int id, String name, Type type1, Type type2, LearnAttackList learnAttackList ,
			PokemonStats baseStats,ImageData imageData, SoundData soundData){
		this.id = id;
		this.name = name;
		this.type = new PokemonType(type1,type2);
		this.learnAttackList = learnAttackList;
		this.baseStats = baseStats;
		this.imageData = imageData;
		this.soundData = soundData;
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
	public SoundData getSoundData(){
		return soundData;
	}
}