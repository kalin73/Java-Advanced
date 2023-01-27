package genericArrayCreator;

public class Main {
	public static void main(String[] args) {
		Integer[] arr = ArrayCreator.create(5, 7);

		for (Integer integer : arr) {
			System.out.print(integer + " ");
		}
	}
}
