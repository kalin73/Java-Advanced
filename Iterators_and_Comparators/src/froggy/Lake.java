package froggy;

import java.util.Iterator;

public class Lake<I> implements Iterable<Integer> {
	private int[] lake;

	public Lake(int... n) {
		this.lake = n;
	}
	
	public int length() {
		return lake.length;
	}

	@Override
	public Iterator<Integer> iterator() {
		return new Frog();
	}

	private final class Frog implements Iterator<Integer> {
		private int counter = -1;

		@Override
		public boolean hasNext() {
			counter++;
			if (counter < lake.length) {
				return true;
			}
			return false;
		}

		@Override
		public Integer next() {
			return lake[counter];
		}

	}
}
