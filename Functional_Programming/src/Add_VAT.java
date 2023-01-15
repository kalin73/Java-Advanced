import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Add_VAT {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		List<Double> numbers = Arrays.stream(sc.nextLine().split(", "))
				.map(x -> Double.parseDouble(x))
				.collect(Collectors.toList());

		Function<Double, Double> function = x -> x * 1.2;
		Consumer<List<Double>> consumer = list -> list.stream()
				.map(function)
				.forEach(x -> System.out.printf("%.2f%n", x));

		System.out.println("Prices with VAT:");
		consumer.accept(numbers);

		sc.close();
	}
}
