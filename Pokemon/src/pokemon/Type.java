package pokemon;
/**
 * An enum containing the Type of Pokemon or Attack
 * @author Alejandro
 *
 */
public enum Type {
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
	private String name;
	private Type(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return this.name;
	}
}
