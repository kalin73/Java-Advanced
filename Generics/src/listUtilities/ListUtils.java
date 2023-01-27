package listUtilities;

import java.util.List;

public class ListUtils {
	public static <T extends Comparable<T>> T getMin(List<T> list) {
		ensureNotEmpty(list);

		T min = list.get(0);

		for (T element : list) {
			if (element.compareTo(min) < 0) {
				min = element;
			}
		}
		return min;
	}

	public static <T extends Comparable<T>> T getMax(List<T> list) {
		ensureNotEmpty(list);

		T max = list.get(0);

		for (T element : list) {
			if (element.compareTo(max) > 0) {
				max = element;
			}
		}
		return max;
	}

	private static <T> void ensureNotEmpty(List<T> list) {
		if (list.size() == 0 || list == null) {
			throw new IllegalArgumentException();
		}
	}
}
