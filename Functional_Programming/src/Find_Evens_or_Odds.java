import java.util.Scanner;
import java.util.function.Predicate;

public class Find_Evens_or_Odds {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] bounds = sc.nextLine().split(" ");
		String condition = sc.nextLine();

		if (condition.equals("even")) {
			print(bounds, x -> x % 2 == 0);

		} else {
			print(bounds, x -> x % 2 != 0);

		}
		sc.close();
	}

	private static void print(String[] bounds, Predicate<Integer> predicate) {
		int min = Integer.parseInt(bounds[0]);
		int max = Integer.parseInt(bounds[1]);

		for (int i = min; i <= max; i++) {
			if (predicate.test(i)) {
				System.out.print(i + " ");
			}
		}
	}
}