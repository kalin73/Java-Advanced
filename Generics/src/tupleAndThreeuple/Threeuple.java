package tupleAndThreeuple;

public class Threeuple<T, E, K> extends Tuple<T, E> {
	private K value3;

	public Threeuple(T value1, E value2, K value3) {
		super(value1, value2);
		this.value3 = value3;
	}

	@Override
	public String toString() {
		return super.toString() + " -> " + value3;
	}
}
