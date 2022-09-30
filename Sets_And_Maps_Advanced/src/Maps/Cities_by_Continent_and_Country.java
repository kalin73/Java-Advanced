package Maps;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Cities_by_Continent_and_Country {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		Map<String, LinkedHashMap<String, List<String>>> continents = new LinkedHashMap<>();
		LinkedHashMap<String, List<String>> countries = new LinkedHashMap<>();
		List<String> cities = new ArrayList<>();

		for (int i = 0; i < n; i++) {

			String[] input = sc.nextLine().split(" ");
			String continent = input[0];
			String country = input[1];
			String city = input[2];

			if (!continents.containsKey(continent)) {
				countries = new LinkedHashMap<>();
				cities = new ArrayList<>();
				cities.add(city);
				countries.put(country, cities);
				continents.put(continent, countries);
				continue;
			}
			if (!continents.get(continent).containsKey(country)) {
				countries = continents.get(continent);
				cities = new ArrayList<>();
				cities.add(city);
				countries.put(country, cities);
				continents.put(continent, countries);
				continue;

			}

			continents.get(continent).get(country).add(city);

		}
		continents.forEach((key, value) -> {
			System.out.println(key + ":");
			value.forEach((k, v) -> {
				String cn = "";
				System.out.print(k + " -> ");
				for (String s : v) {
					cn = cn + String.format("%s, ", s);
				}
				System.out.println(cn.substring(0, cn.length() - 2));
			});

		});
		sc.close();
	}

}
