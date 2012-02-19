package pokemon;

import java.io.IOException;

import pokemon.imagedata.ImageData;
import pokemon.imagedata.ImageInvalidSizeException;
/**
 * Contains non-modificable data of the Pokemon
 * @author Alejandro
 * @see Pokemon
 */
public enum PokemonData {
	Bulbasaur(1,"Bulbasaur",
			Type.GRASS ,Type.POISON,
			new ImageData(null,"/images/pokemon/front/001.png",null)
			);
	/** The Pokemon id */
	private int id;
	/** Pokemon name */
	private String name;
	/** First Pokemon type */
	private Type type1;
	/** Second Pokemon type */
	private Type type2;
	/** Pokemon initial Stats */
	private PokemonStats iniStats;
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
	private PokemonData(int id, String name, Type type1, Type type2,
			ImageData imageData){
		this.id = id;
		this.name = name;
		this.type1 = type1;
		this.type2 = type2;
		this.imageData = imageData;
	}

	/**
	 * Returns the Pokemon's id
	 * @return an integer containing the Pokemon's id
	 */
	public int getId() {
		return id;
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
		return type1;
	}
	/**
	 * Returns the Pokemon's second type
	 * @return a Type object containing Pokemon's second type
	 */
	public Type getType2() {
		return type2;
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
	 * @return a PokemonStats object containing the Pokemon's initial stats values
	 */
	public PokemonStats getIniStats() {
		return iniStats;
	}

}