package customListWithIterator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CustomList<T extends Comparable<T>> implements Iterable<T> {
	private List<T> data;

	public CustomList() {
		data = new ArrayList<>();
	}

	public void add(T element) {
		data.add(element);
	}

	public T remove(int index) {
		return data.remove(index);

	}

	public boolean contains(T element) {
		return data.contains(element);
	}

	public void swap(int index1, int index2) {
		T prev = data.get(index1);
		data.set(index1, data.get(index2));
		data.set(index2, prev);

	}

	public int countGreaterThan(T element) {
		return (int) data.stream().filter(x -> x.compareTo(element) > 0).count();
	}

	public T getMax() {
		return Collections.max(data);
	}

	public T getMin() {
		return Collections.min(data);
	}

	public T get(int index) {
		return this.data.get(index);
	}

	public int size() {
		return this.data.size();
	}

	@Override
	public Iterator<T> iterator() {
		return new CustomListIterator();
	}

	private class CustomListIterator implements Iterator<T> {
		int index = 0;

		@Override
		public boolean hasNext() {
			return index < data.size();
		}

		@Override
		public T next() {
			return data.get(index++);
		}
	}
}
