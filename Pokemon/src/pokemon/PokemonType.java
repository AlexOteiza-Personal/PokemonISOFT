package pokemon;

public class PokemonType {
	private Type type1;
	private Type type2;
	
	public PokemonType(Type type1, Type type2) {
		this.type1 = type1;
		this.type2 = type2;
	}
	public Type getType1() {
		return type1;
	}
	public Type getType2() {
		return type2;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof PokemonType)
		{
			PokemonType objType = (PokemonType)obj;
			return type1 == objType.type1 && type2 == objType.type2;
		}
		else
			return false;
	}
	@Override
	public int hashCode() {
		int hash = type1.hashCode();
		if(type2!=null)
			hash += type2.hashCode();
		return hash;
	}
}
