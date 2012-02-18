package pokemon;

public class PokemonType{
	private Type type1;
	private Type type2;
	
	protected PokemonType(Type type1, Type type2) {
		this.type1 = type1;
		this.type2 = type2;
	}
	
	public Type[] getType(){
		return new Type[] {type1,type2};
	}
	public Type getType1() {
		return type1;
	}
	public void setType1(Type type1) {
		this.type1 = type1;
	}
	public Type getType2() {
		return type2;
	}
	public void setType2(Type type2) {
		this.type2 = type2;
	}
}
