package genericSwapMethodStrings;

import java.util.List;

public class SwapClass {
	public static <T> void swap(List<T> list, int index1, int index2) {
		T element = list.get(index1);
		list.set(index1, list.get(index2));
		list.set(index2, element);
	}

	public static <T> void print(List<T> list) {
		list.forEach(x -> System.out.println(x.getClass().getName() + ": " + x));
	}
}
