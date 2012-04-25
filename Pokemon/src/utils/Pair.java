package utils;

public class Pair<K> {
	public Object o1;
	public Object o2;

	public Pair(Object o1, Object o2) {
		this.o1 = o1;
		this.o2 = o2;
	}

	public static boolean same(Object o1, Object o2) {
		return o1 == null ? o2 == null : o1.equals(o2);
	}

	Object getFirst() {
		return o1;
	}

	Object getSecond() {
		return o2;
	}

	void setFirst(Object o) {
		o1 = o;
	}

	void setSecond(Object o) {
		o2 = o;
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof Pair))
			return false;
		Pair p = (Pair) obj;
		return same(p.o1, this.o1) && same(p.o2, this.o2);
	}
}
