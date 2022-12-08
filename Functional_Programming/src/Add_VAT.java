import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Add_VAT {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		List<Double> numbers = Arrays.stream(sc.nextLine().split(", ")).map(x -> Double.parseDouble(x))
				.collect(Collectors.toList());

		Function<Double, Double> function = x -> x * 1.2;
		System.out.println("Prices with VAT:");

		numbers.forEach(x -> {
			Double result = function.apply(x);
			System.out.printf("%.2f%n", result);
		});

		sc.close();

	}
}
