import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Count_Uppercase_Words {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		List<String> text = Arrays.stream(sc.nextLine().split(" ")).collect(Collectors.toList());
		text = filterUpperCase(text, x -> Character.isUpperCase(x.charAt(0)));

		System.out.println(text.size());
		print(text, System.out::println);
		sc.close();
	}

	private static List<String> filterUpperCase(List<String> text, Predicate<String> predicate) {
		List<String> upperCaseWords = new ArrayList<>();

		for (String s : text) {
			boolean isUpperCase = predicate.test(s);
			if (isUpperCase) {
				upperCaseWords.add(s);
			}
		}
		return upperCaseWords;
	}

	private static void print(List<String> text, Consumer<String> consumer) {
		for (String s : text) {
			consumer.accept(s);
		}
	}
}
