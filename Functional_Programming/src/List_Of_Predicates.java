import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class List_Of_Predicates {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		List<Integer> numbers = Arrays.stream(sc.nextLine().split(" "))
				.map(Integer::parseInt)
				.collect(Collectors.toList());

		IntPredicate isDevisible = x -> {
			for (Integer i : numbers) {
				if (x % i != 0) {
					return false;
				}
			}
			return true;
		};

		IntStream.rangeClosed(1, n)
				 .filter(isDevisible)
				 .forEach(x -> System.out.print(x + " "));

		sc.close();
	}

}
