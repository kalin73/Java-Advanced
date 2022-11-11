package linkedListTraversal;

import java.util.Iterator;
import java.util.LinkedList;

public class LnkdList<T> implements Iterable<Integer> {

	private LinkedList<Integer> list;

	public LnkdList() {
		this.list = new LinkedList<>();
	}

	public int size() {
		return list.size();
	}

	public void add(Integer n) {
		list.addLast(n);
	}

	public boolean remove(Integer n) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) == n) {
				list.remove(i);
				return true;
			}
		}
		return false;
	}

	@Override
	public Iterator<Integer> iterator() {

		return new listComparator();
	}

	private final class listComparator implements Iterator<Integer> {
		private int counter = 0;

		@Override
		public boolean hasNext() {
			if (counter < list.size()) {
				return true;
			}
			return false;
		}

		@Override
		public Integer next() {
			counter++;
			return list.get(counter - 1);
		}

	}

}
