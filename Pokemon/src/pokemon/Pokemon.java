package pokemon;
import pokemon.imagedata.ImageData;

public class Pokemon {
	
	private int id;
	private String name;
	private String nickname = null;
	private PokemonType type;
	private PokemonStats stats;
	private ImageData imageData;
	
	
	public Pokemon(int id,int level)
	{
		PokemonData data = PokemonList.getPokemonData(id, level);
		this.id = data.getId();
		this.name = data.getName();
		this.type = data.getType();
		this.stats = data.getStats();
		this.imageData = data.getImageData();
	}
	
	public String toString()
	{
		return "Pokemon id:" + id + "\n" + "Nombre: " + name + "\nTipo: " +type.getType1() + " " + type.getType2()
				+ "\nAtaque: "+ stats.getAttack()+"\nDefensa: "+ stats.getDefence() + "\nVelocidad: " + stats.getSpeed();
				//+ "\nAtaque Esp: "+ stats.getSpAttack() +"\nDefensa Esp: " + stats.getSpDefence(); 
	}
	
	/*
	 * Getters
	 */
	public int getId()
	{
		return this.id;
	}
	public String getName()
	{
		return this.name;
	}
	public String getNickname()
	{
		return this.nickname;
	}
	public PokemonType getPokemonType()
	{
		return this.type;
	}
	public ImageData getImageData()
	{
		return this.imageData;
	}
	/*
	 * Setters
	 */
	public boolean setNickname(String nickname)
	{
		if(nickname.length()>14)
			return false;
		else
		{
			this.nickname = nickname;
			return true;
		}
		
	}
}


