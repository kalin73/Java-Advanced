package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterable<String> {

	private List<String> list;
	private ListIterator it = new ListIterator();

	public ListyIterator(String... names) {
		create(names);
	}

	public List<String> getList() {
		return list;
	}

	private void create(String... name) {
		list = new ArrayList<>(Arrays.asList(name));
	}

	public boolean move() {

		return it.setCounter();

	}

	public void print() {
		if (list.get(it.getCounter()) == null) {
			throw new NullPointerException("Invalid Operation!");
		}
		System.out.println(list.get(it.getCounter()));
	}

	public boolean hasNext() {
		return it.hasNext();
	}

	public void printAll() {
		if (list.size() == 0) {
			throw new NullPointerException("Invalid Operation!");
		}
		this.list.forEach(x -> System.out.print(x + " "));
		System.out.println();

	}

	@Override
	public Iterator<String> iterator() {

		return new ListIterator();
	}

	private final class ListIterator implements Iterator<String> {
		private int counter = 0;

		@Override
		public boolean hasNext() {
			if (list.size() - 1 > counter) {
				return true;
			}
			return false;
		}

		@Override
		public String next() {

			counter++;
			return list.get(counter - 1);
		}

		public int getCounter() {
			return counter;
		}

		public boolean setCounter() {
			boolean valid = counter + 1 < list.size();
			if (valid) {
				this.counter++;
				return true;
			}
			return false;
		}

	}

}
