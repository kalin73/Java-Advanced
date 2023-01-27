package jarOfT;

public class Main {

	public static void main(String[] args) {
		Jar<Integer> jarOfIntegers = new Jar<>();
		Jar<String> jarOfStrings = new Jar<>();

		jarOfIntegers.add(5);
		jarOfStrings.add("Pickle");

		System.out.println(jarOfIntegers.remove());
		System.out.println(jarOfStrings.remove());

	}

}
