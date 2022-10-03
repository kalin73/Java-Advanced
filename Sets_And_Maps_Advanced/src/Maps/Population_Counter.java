package Maps;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Population_Counter {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedHashMap<String, LinkedHashMap<String, Long>> countries = storeData(sc);
		List<Entry<String, LinkedHashMap<String, Long>>> list = sorting(countries);
		printResult(list);

	}

	public static LinkedHashMap<String, LinkedHashMap<String, Long>> storeData(Scanner sc) {
		LinkedHashMap<String, LinkedHashMap<String, Long>> countries = new LinkedHashMap<>();
		LinkedHashMap<String, Long> cities = new LinkedHashMap<>();
		String[] input = sc.nextLine().split("\\|");

		while (!input[0].equals("report")) {

			String city = input[0];
			String country = input[1];
			Long count = Long.parseLong(input[2]);

			if (!countries.containsKey(country)) {

				cities = new LinkedHashMap<>();
				cities.put(city, count);
				countries.put(country, cities);
				input = sc.nextLine().split("\\|");
				continue;
			}
			if (!countries.get(country).containsKey(city)) {

				cities = countries.get(country);
				cities.put(city, count);
				countries.put(country, cities);
				input = sc.nextLine().split("\\|");
				continue;
			}
			cities = countries.get(country);
			cities.put(city, cities.get(city) + count);
			countries.put(country, cities);
			input = sc.nextLine().split("\\|");

		}
		return countries;
	}

	public static List<Entry<String, LinkedHashMap<String, Long>>> sorting(
			LinkedHashMap<String, LinkedHashMap<String, Long>> countries) {

		List<Entry<String, LinkedHashMap<String, Long>>> result = countries.entrySet().stream()
				.sorted((a, b) -> Long.compare(b.getValue().values().stream().mapToLong(l -> l).sum(),
						a.getValue().values().stream().mapToLong(i -> i).sum()))
				.collect(Collectors.toList());
		return result;
	}

	public static void printResult(List<Entry<String, LinkedHashMap<String, Long>>> result) {

		for (Entry<String, LinkedHashMap<String, Long>> entry : result) {

			Long sum = entry.getValue().values().stream().mapToLong(x -> x).sum();
			System.out.println(entry.getKey() + " (total population: " + sum + ")");
			entry.getValue().entrySet().stream().sorted((a, b) -> Long.compare(b.getValue(), a.getValue()))
					.forEach(x -> System.out.printf("=>%s: %d%n", x.getKey(), x.getValue()));

		}
	}
}
