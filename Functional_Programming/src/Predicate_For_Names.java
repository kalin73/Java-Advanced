import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class Predicate_For_Names {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		List<String> names = Arrays.stream(sc.nextLine().split(" ")).collect(Collectors.toList());

		Predicate<String> namePredicate = x -> x.length() <= n;
		UnaryOperator<List<String>> filter = x -> x.stream().filter(namePredicate).collect(Collectors.toList());
		Consumer<List<String>> printer = x -> x.forEach(e -> System.out.println(e));

		names = filter.apply(names);
		printer.accept(names);
		sc.close();
	}

}
