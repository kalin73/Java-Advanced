import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Predicate_Party {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<String> guests = Arrays.stream(sc.nextLine().split(" ")).collect(Collectors.toList());

		String[] commands = sc.nextLine().split(" ");

		while (!"Party!".equals(commands[0])) {
			String command = commands[0];

			switch (command) {
			case "Double":
				for (int i = 0; i < guests.size(); i++) {
					if (filterPredicate(commands).test(guests.get(i))) {
						guests.add(i, guests.get(i));
						i++;
					}
				}
				break;

			case "Remove":
				guests.removeIf(filterPredicate(commands));
				break;

			default:
				break;
			}
			commands = sc.nextLine().split(" ");
		}
		if (guests.size() > 0) {
			String result = guests.stream().sorted().collect(Collectors.joining(", ")) + " are going to the party!";
			System.out.println(result);
		} else {
			System.out.println("Nobody is going to the party!");
		}
		sc.close();
	}

	private static Predicate<String> filterPredicate(String[] commands) {
		String condition = commands[1];

		switch (condition) {
		case "StartsWith":
			String prefix = commands[2];
			Predicate<String> startsWith = x -> x.startsWith(prefix);
			return startsWith;

		case "EndsWith":
			String suffix = commands[2];
			Predicate<String> endsWith = x -> x.endsWith(suffix);
			return endsWith;

		case "Length":
			int length = Integer.parseInt(commands[2]);
			Predicate<String> hasLength = x -> x.length() == length;
			return hasLength;

		default:
			throw new IllegalArgumentException();

		}
	}
}
