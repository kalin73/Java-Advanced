package Maps;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Srbsko_Unleashed {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedHashMap<String, LinkedHashMap<String, Integer>> map = new LinkedHashMap<>();
		int n = 0;
		String[] tickets = null;

		String input = sc.nextLine();

		while (!input.substring(0, 3).equals("End")) {
			String name = "";
			String venue = "";
			Integer profit = 0;
			for (int i = 0; i < input.length() - 1; i++) {

				if (input.charAt(i) == ' ' && input.charAt(i + 1) == '@') {
					name = input.substring(0, i);
					n = i + 2;

				} else if (input.charAt(i) == ' ' && Character.isDigit(input.charAt(i + 1))) {
					venue = input.substring(n, i);
					tickets = input.substring(i + 1, input.length()).split(" ");
					break;
				}

			}

			if (!"".equals(name) && !"".equals(venue) && tickets.length > 1) {
				int ticketPrice = Integer.parseInt(tickets[0]);
				int ticketCount = Integer.parseInt(tickets[1]);
				profit = ticketCount * ticketPrice;
				add(map, name, venue, profit);
			}

			input = sc.nextLine();
		}
		print(map);
		sc.close();
	}

	public static void add(LinkedHashMap<String, LinkedHashMap<String, Integer>> map, String name, String venue,
			Integer profit) {
		LinkedHashMap<String, Integer> singers = new LinkedHashMap<>();
		if (!map.containsKey(venue)) {

			singers = new LinkedHashMap<>();
			singers.put(name, profit);
			map.put(venue, singers);
			return;

		}
		if (!map.get(venue).containsKey(name)) {

			singers = map.get(venue);
			singers.put(name, profit);
			map.put(venue, singers);
			return;
		}

		singers = map.get(venue);
		singers.put(name, singers.get(name) + profit);
		map.put(venue, singers);

	}

	public static void print(LinkedHashMap<String, LinkedHashMap<String, Integer>> map) {

		for (String s : map.keySet()) {
			System.out.println(s);

			map.get(s).entrySet().stream().sorted((fs, se) -> Integer.compare(se.getValue(), fs.getValue()))
					.forEach(x -> System.out.printf("#  %s -> %d%n", x.getKey(), x.getValue()));
		}

	}
}
