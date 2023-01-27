package jarOfT;

import java.util.ArrayDeque;

public class Jar<T> {
	private ArrayDeque<T> jar;

	public Jar() {
		this.jar = new ArrayDeque<>();
	}

	public void add(T element) {
		jar.push(element);
	}

	public T remove() {
		return jar.pop();
	}
}
