import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class Custom_Min_Function {

	public static void main(String[] args) {
		Function<Integer[], Integer> func = x -> Arrays.stream(x).min((f, s) -> f.compareTo(s)).orElse(0);
		Scanner sc = new Scanner(System.in);
		Integer[] input = Arrays.stream(sc.nextLine().split("\\s+")).map(Integer::parseInt).toArray(Integer[]::new);
		System.out.println(func.apply(input));

		sc.close();

	}

}
