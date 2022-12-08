import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Add_VAT {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		List<Double> numbers = Arrays.stream(sc.nextLine().split(", ")).map(x -> Double.parseDouble(x))
				.collect(Collectors.toList());
		filter(numbers, x -> x * 1.2);
		System.out.println("Prices with VAT:");
		print(numbers, x -> System.out.printf("%.2f%n",x));
		sc.close();

	}

	private static void filter(List<Double> nums, Function<Double, Double> function) {
		for (int i = 0; i < nums.size(); i++) {
			nums.set(i, function.apply(nums.get(i)));
		}
	}

	private static void print(List<Double> nums, Consumer<Double> function) {
		for (int i = 0; i < nums.size(); i++) {
			function.accept(nums.get(i));
		}
	}
}
