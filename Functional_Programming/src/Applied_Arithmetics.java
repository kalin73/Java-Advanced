import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class Applied_Arithmetics {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> numbers = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt)
				.collect(Collectors.toList());

		UnaryOperator<List<Integer>> add = x -> x.stream().map(e -> e + 1).collect(Collectors.toList());
		UnaryOperator<List<Integer>> multiply = x -> x.stream().map(e -> e * 2).collect(Collectors.toList());
		UnaryOperator<List<Integer>> subtract = x -> x.stream().map(e -> e - 1).collect(Collectors.toList());

		Consumer<List<Integer>> print = x -> x.forEach(e -> System.out.print(e + " "));

		String command = sc.nextLine();

		while (!"end".equals(command)) {

			switch (command) {
			case "add":
				numbers = add.apply(numbers);
				break;

			case "multiply":
				numbers = multiply.apply(numbers);
				break;

			case "subtract":
				numbers = subtract.apply(numbers);
				break;

			case "print":
				print.accept(numbers);
				System.out.println();
				break;

			default:
				break;
			}
			command = sc.nextLine();
		}
		sc.close();
	}

}
