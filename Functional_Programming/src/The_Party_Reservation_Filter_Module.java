import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class The_Party_Reservation_Filter_Module {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<String> names = Arrays.stream(sc.nextLine().split(" ")).collect(Collectors.toList());
		Map<String, Predicate<String>> filters = new HashMap<>();

		String[] commands = sc.nextLine().split(";");
		while (!"Print".equals(commands[0])) {
			String command = commands[0];
			String parameter = commands[2];

			switch (command) {
			case "Add filter":
				filters.put(parameter, filterPredicate(commands));
				break;

			case "Remove filter":
				filters.remove(parameter);
				break;

			default:
				break;
			}
			commands = sc.nextLine().split(";");
		}

		if (filters.size() > 0) {
			for (String key : filters.keySet()) {
				names.removeIf(filters.get(key));
			}
		}
		names.forEach(x -> System.out.print(x + " "));
		sc.close();
	}

	private static Predicate<String> filterPredicate(String[] commands) {
		String condition = commands[1];

		switch (condition) {
		case "Starts with":
			String prefix = commands[2];
			return x -> x.startsWith(prefix);

		case "Ends with":
			String suffix = commands[2];
			return x -> x.endsWith(suffix);

		case "Length":
			int length = Integer.parseInt(commands[2]);
			return x -> x.length() == length;

		case "Contains":
			String content = commands[2];
			return x -> x.contains(content);

		default:
			throw new IllegalArgumentException();

		}
	}
}
