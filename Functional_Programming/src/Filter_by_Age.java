import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Filter_by_Age {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());

		Map<String, Integer> ppl = new LinkedHashMap<>();

		add(sc, n, ppl);

		String condition = sc.nextLine();
		Integer age = Integer.parseInt(sc.nextLine());
		String format = sc.nextLine();

		ppl = filter(condition, age, ppl);
		print(format, ppl);

		sc.close();
	}

	private static void add(Scanner sc, int n, Map<String, Integer> ppl) {

		for (int i = 0; i < n; i++) {
			String[] input = sc.nextLine().split(", ");
			ppl.put(input[0], Integer.parseInt(input[1]));
		}
	}

	private static Map<String, Integer> filter(String condition, int ageFilter, Map<String, Integer> ppl) {

		Map<String, Integer> map = new LinkedHashMap<>();

		for (String key : ppl.keySet()) {
			Integer value = ppl.get(key);

			if (condition.equals("younger")) {
				if (value <= ageFilter) {
					map.put(key, value);
				}
			} else {
				if (ppl.get(key) >= ageFilter) {
					map.put(key, value);

				}
			}
		}
		return map;
	}

	private static void print(String format, Map<String, Integer> ppl) {

		for (String key : ppl.keySet()) {
			if (format.equals("name")) {
				System.out.println(key);

			} else if (format.equals("age")) {
				System.out.println(ppl.get(key));

			} else {
				System.out.println(key + " - " + ppl.get(key));
			}
		}

	}

}
