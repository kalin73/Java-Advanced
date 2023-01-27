package genericBox;

public class GenericBox<T> {
	T value;

	public GenericBox(T value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return value.getClass().getName() + ": " + value;
	}
}
