package Maps;

import java.util.Scanner;
import java.util.TreeMap;

public class Logs_Aggregator {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());

		TreeMap<String, TreeMap<String, Integer>> map = addData(sc, n);
		printResult(map);

	}

	public static TreeMap<String, TreeMap<String, Integer>> addData(Scanner sc, int n) {

		TreeMap<String, TreeMap<String, Integer>> map = new TreeMap<>();
		TreeMap<String, Integer> ips = new TreeMap<>();

		for (int i = 0; i < n; i++) {

			String[] input = sc.nextLine().split(" ");
			String ip = input[0];
			String name = input[1];
			Integer time = Integer.parseInt(input[2]);

			if (!map.containsKey(name)) {

				ips = new TreeMap<>();
				ips.put(ip, time);
				map.put(name, ips);
				continue;
			}
			if (!map.get(name).containsKey(ip)) {

				ips = map.get(name);
				ips.put(ip, time);
				map.put(name, ips);
				continue;
			}

			ips = map.get(name);
			ips.put(ip, ips.get(ip) + time);
			map.put(name, ips);

		}
		return map;
	}

	public static void printResult(TreeMap<String, TreeMap<String, Integer>> map) {

		for (String s : map.keySet()) {

			int sum = map.get(s).values().stream().mapToInt(x -> x).sum();
			System.out.printf("%s: %d [", s, sum);
			int counter = 1;
			for (String st : map.get(s).keySet()) {

				if (counter < map.get(s).size()) {

					System.out.printf("%s, ", st);
					counter++;

				} else {
					System.out.println(st + "]");

				}

			}

		}

	}
}
