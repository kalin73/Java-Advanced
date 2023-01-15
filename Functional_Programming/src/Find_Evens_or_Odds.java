import java.util.Scanner;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class Find_Evens_or_Odds {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] bounds = sc.nextLine().split(" ");
		int min = Integer.parseInt(bounds[0]);
		int max = Integer.parseInt(bounds[1]);

		String condition = sc.nextLine();

		IntPredicate evenOddFilter = x -> "even".equals(condition) == (x % 2 == 0);
		IntStream.rangeClosed(min, max).filter(evenOddFilter).forEach(x -> System.out.print(x + " "));

		sc.close();
	}
}