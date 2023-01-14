import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Reverse_And_Exclude {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> numbers = Arrays.stream(sc.nextLine().split(" "))
				.map(Integer::parseInt)
				.collect(Collectors.toList());
		
		Collections.reverse(numbers);
		int n = Integer.parseInt(sc.nextLine());

		Predicate<Integer> predicate = x -> x % n == 0;

		numbers.removeIf(predicate);
		numbers.forEach(x -> System.out.print(x + " "));

		sc.close();

	}
}
