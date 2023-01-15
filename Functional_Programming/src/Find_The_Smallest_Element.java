import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Find_The_Smallest_Element {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> numbers = Arrays.stream(sc.nextLine().split("\\s+")).map(Integer::parseInt)
				.collect(Collectors.toList());

		Function<List<Integer>, Integer> smallestValue = x -> {
			int smallestNum = Integer.MAX_VALUE;
			int index = -1;
			for (int i = 0; i < x.size(); i++) {
				if (x.get(i) <= smallestNum) {
					smallestNum = x.get(i);
					index = i;
				}

			}
			return index;
		};
		System.out.println(smallestValue.apply(numbers));
		sc.close();
	}

}
