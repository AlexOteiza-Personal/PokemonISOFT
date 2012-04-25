package pokemon;

public enum Effectiveness {
	ULTRA_EFFECTIVE,// <- Solo se puede alcanzar sumando 2 very effective
	VERY_EFFECTIVE,
	NORMAL,
	NOT_VERY_EFFECTIVE,
	NOT_EFFECTIVE, // <- Solo se puede alcanzar sumando 2 not very efective
	NOT_AFFECTED;
}
