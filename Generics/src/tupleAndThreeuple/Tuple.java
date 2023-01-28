package tupleAndThreeuple;

public class Tuple<T, E> {
	private T value1;
	private E value2;

	public Tuple(T value1, E value2) {
		this.value1 = value1;
		this.value2 = value2;
	}

	@Override
	public String toString() {
		return value1 + " -> " + value2;
	}
}
