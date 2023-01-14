import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class Knights_of_Honor {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] input = sc.nextLine().split("\\s+");

		Consumer<String> print = st -> System.out.println("Sir " + st);
		Arrays.stream(input).forEach(print);

		sc.close();
	}

}
