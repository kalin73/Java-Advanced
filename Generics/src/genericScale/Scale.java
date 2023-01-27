package genericScale;

public class Scale<T extends Comparable<T>> {
	private T left;
	private T right;

	public Scale(T left, T right) {
		this.left = left;
		this.right = right;
	}

	public T getHeavier() {
		int value = left.compareTo(right);
		
		if (value > 0) {
			return left;
			
		} else if (value < 0) {
			return right;
			
		}
		return null;
	}

}
