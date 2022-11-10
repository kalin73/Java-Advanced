package stackIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Stack<T> implements Iterable<Integer> {
	private List<Integer> stack;

	public void push(Integer... n) {
		if (stack == null) {
			this.stack = new ArrayList<>();
		}
		for (Integer i : n) {
			stack.add(i);
		}

	}

	public void pop() {

		if (stack.size() < 1 || stack.get(0) == null) {
			throw new NullPointerException("No elements");
		}
		int index = stack.size() - 1;
		this.stack.remove(index);
	}

	@Override
	public Iterator<Integer> iterator() {
		return new StackIterator();
	}

	private final class StackIterator implements Iterator<Integer> {
		private int counter = stack.size();

		@Override
		public boolean hasNext() {
			counter--;
			if (counter >= 0) {
				return true;
			}
			return false;
		}

		@Override
		public Integer next() {

			return stack.get(counter);

		}

	}
}
