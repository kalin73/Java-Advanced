package genericCountMethodStrings;

import java.util.List;

public class GenericBox<T extends Comparable<T>> {
	T value;

	public GenericBox(T value) {
		this.value = value;
	}

	public static <T extends Comparable<T>> int getCount(List<T> list, T element) {
		int count = 0;

		for (T e : list) {
			if (e.compareTo(element) > 0) {
				count++;
			}
		}

		return count;
	}

	@Override
	public String toString() {
		return value.getClass().getName() + ": " + value;
	}
}
