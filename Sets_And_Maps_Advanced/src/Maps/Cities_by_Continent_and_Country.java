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

		for (int i = 0; i < n; i++) {

			String[] input = sc.nextLine().split(" ");
			String continent = input[0];
			String country = input[1];
			String city = input[2];

			continents.putIfAbsent(continent, new LinkedHashMap<>());
			
			LinkedHashMap<String, List<String>> countries = continents.get(continent);
			
			countries.putIfAbsent(country, new ArrayList<>());
			
			List<String> cities = countries.get(country);
			
			cities.add(city);


		}
		continents.forEach((key, value) -> {
			System.out.println(key + ":");
			value.forEach((k, v) -> {
				String cn = String.join(", ", v);
				System.out.print(k + " -> ");
				System.out.println(cn);
			});

		});
		sc.close();
	}

}
