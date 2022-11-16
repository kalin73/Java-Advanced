import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Sum_Numbers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		List<Integer> numbers = Arrays
				.stream(sc.nextLine().split(", "))
				.map(Integer::parseInt)
				.collect(Collectors.toList());

		int sum = numbers.stream().mapToInt(x -> x).sum();
		System.out.println("Count = " + numbers.size() + "\nSum = " + sum);

		sc.close();
	}

}
