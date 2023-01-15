import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Sum_Numbers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		List<Integer> numbers = Arrays.stream(sc.nextLine().split(", ")).map(Integer::parseInt)
				.collect(Collectors.toList());

		Function<List<Integer>, String> count = x -> "Count = " + x.size();
		Function<List<Integer>, String> sum = x -> "Sum = " + x.stream().mapToInt(Integer::intValue).sum();

		System.out.println(count.apply(numbers) + "\n" + sum.apply(numbers));

		sc.close();
	}

}
