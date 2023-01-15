import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Count_Uppercase_Words {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Predicate<String> predicate = x -> Character.isUpperCase(x.charAt(0));
		Consumer<List<String>> consumer = x -> x.stream().forEach(System.out::println);

		List<String> text = Arrays.stream(sc.nextLine().split(" ")).filter(predicate).collect(Collectors.toList());

		System.out.println(text.size());
		consumer.accept(text);

		sc.close();
	}
}
