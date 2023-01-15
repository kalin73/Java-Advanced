import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Sort_Even_Numbers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Predicate<Integer> evenFilter = x -> x % 2 == 0;
		Comparator<Integer> ascOrder = (first, second) -> first - second;

		List<Integer> list = Arrays.stream(sc.nextLine().split(", "))
				.map(Integer::parseInt)
				.filter(evenFilter)
				.collect(Collectors.toList());
		
		String filtered = list.stream()
				.map(x -> x.toString())
				.collect(Collectors.joining(", "));
		
		String sorted = list.stream()
				.sorted(ascOrder).map(x -> x.toString())
				.collect(Collectors.joining(", "));

		System.out.println(filtered);
		System.out.println(sorted);

		sc.close();
	}

}
