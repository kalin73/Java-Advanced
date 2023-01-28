package customListWithSorter;

public class Sorter {

	public static <T extends Comparable<T>> void sort(CustomList<T> list) {
		boolean sorted = false;

		while (!sorted) {
			sorted = true;
			for (int i = 0; i < list.size() - 1; i++) {
				if (list.get(i).compareTo(list.get(i + 1)) > 0) {
					list.swap(i, i + 1);
					sorted = false;
				}
			}
		}
	}
}
