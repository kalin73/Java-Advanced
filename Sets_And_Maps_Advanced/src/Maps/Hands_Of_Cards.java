package Maps;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Scanner;

public class Hands_Of_Cards {

	public static void main(String[] args) {
		Map<String, LinkedHashSet<String>> map = new LinkedHashMap<>();
		Scanner sc = new Scanner(System.in);
		String[] input = sc.nextLine().split(":");
		LinkedHashSet<String> set = new LinkedHashSet<>();

		while (!input[0].equals("JOKER")) {
			String name = input[0];
			String[] cards = input[1].split(", ");

			if (!map.containsKey(name)) {
				set = new LinkedHashSet<>();
				for (int i = 0; i < cards.length; i++) {
					set.add(cards[i].trim());
				}
				map.put(name, set);
				continue;
			}
			set = map.get(name);
			for (int i = 0; i < cards.length; i++) {
				set.add(cards[i].trim());
			}
			map.put(name, set);
			input = sc.nextLine().split(":");
		}

		calculate(map);
		sc.close();
	}

	public static void calculate(Map<String, LinkedHashSet<String>> map) {

		for (String s : map.keySet()) {
			int sum = 0;
			int digit = 0;
			int n = 0;
			for (String st : map.get(s)) {

				if (Character.isDigit(st.charAt(0)) && st.charAt(0) != '1') {
					digit = Character.getNumericValue(st.charAt(0));

				} else if (st.charAt(0) == 'J') {

					digit = 11;

				} else if (st.charAt(0) == 'Q') {

					digit = 12;

				} else if (st.charAt(0) == 'K') {

					digit = 13;

				} else if (st.charAt(0) == 'A') {

					digit = 14;

				} else if (st.charAt(0) == '1') {

					digit = 10;

				}
				if (st.charAt(1) == 'S' || (st.length() > 2 && st.charAt(2) == 'S')) {

					n = 4;
				} else if (st.charAt(1) == 'H' || (st.length() > 2 && st.charAt(2) == 'H')) {
					n = 3;
				} else if (st.charAt(1) == 'D' || (st.length() > 2 && st.charAt(2) == 'D')) {
					n = 2;
				} else if (st.charAt(1) == 'C' || (st.length() > 2 && st.charAt(2) == 'C')) {
					n = 1;
				}
				sum += digit * n;

			}
			System.out.println(s + ": " + sum);
		}

	}

}
