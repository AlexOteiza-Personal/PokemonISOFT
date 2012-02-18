package pokemon;

import pokemon.imagedata.ImageData;

public class PokemonData {
	private int id;
	private String name;
	private PokemonType type;
	private PokemonStats stats;
	private PokemonStatsGrow grow;
	private ImageData imageData;

	protected PokemonData(int id, String name, PokemonType type, 
			PokemonStats stats, ImageData imageData) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.stats = stats;
		this.imageData = imageData;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public PokemonType getType() {
		return type;
	}

	public PokemonStats getStats() {
		return stats;
	}

	public ImageData getImageData() {
		return imageData;
	}
	public PokemonStatsGrow getPokemonStatsGrow(){
		return grow;
	}
}
