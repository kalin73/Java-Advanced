import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Predicate;

public class Filter_by_Age {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());

		Map<String, Integer> ppl = new LinkedHashMap<>();
		add(sc, n, ppl);

		String condition = sc.nextLine();
		Integer age = Integer.parseInt(sc.nextLine());
		String format = sc.nextLine();

		Predicate<Integer> olderThan = x -> x >= age;
		Predicate<Integer> youngerThan = x -> x <= age;

		for (String key : ppl.keySet()) {
			if (condition.equals("older")) {
				if (olderThan.test(ppl.get(key))) {
					print(format, key, ppl.get(key));
				}
			} else {
				if (youngerThan.test(ppl.get(key))) {
					print(format, key, ppl.get(key));
				}
			}
		}
		sc.close();
	}

	private static void add(Scanner sc, int n, Map<String, Integer> ppl) {
		for (int i = 0; i < n; i++) {
			String[] input = sc.nextLine().split(", ");
			ppl.put(input[0], Integer.parseInt(input[1]));
		}
	}

	private static void print(String format, String key, Integer value) {
		if (format.equals("name")) {
			System.out.println(key);

		} else if (format.equals("age")) {
			System.out.println(value);

		} else {
			System.out.println(key + " - " + value);
		}
	}
}
