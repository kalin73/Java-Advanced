package Maps;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class User_Logs {

	public static void main(String[] args) {
		TreeMap<String, LinkedHashMap<String, Integer>> map = new TreeMap<>();
		Scanner sc = new Scanner(System.in);
		String[] input = sc.nextLine().split(" ");
		collectIps(sc, input, map);
		printResult(map);

		sc.close();
	}

	public static void collectIps(Scanner sc, String[] input, TreeMap<String, LinkedHashMap<String, Integer>> map) {
		LinkedHashMap<String, Integer> ips = new LinkedHashMap<>();
		while (!input[0].equals("end")) {
			String[] ip = input[0].split("=");
			String[] user = input[2].split("=");

			if (!map.containsKey(user[1])) {

				ips = new LinkedHashMap<>();
				ips.put(ip[1], 1);
				map.put(user[1], ips);
				input = sc.nextLine().split(" ");
				continue;
			}
			if (!map.get(user[1]).containsKey(ip[1])) {

				ips = map.get(user[1]);
				ips.put(ip[1], 1);
				map.put(user[1], ips);
				input = sc.nextLine().split(" ");
				continue;
			}
			ips = map.get(user[1]);
			ips.put(ip[1], ips.get(ip[1]) + 1);
			map.put(user[1], ips);
			input = sc.nextLine().split(" ");
		}
	}

	public static void printResult(TreeMap<String, LinkedHashMap<String, Integer>> map) {
		map.forEach((key, value) -> {

			System.out.println(key + ":");
			int count = 1;
			for (String s : value.keySet()) {

				System.out.print(s + " => " + value.get(s));
				if (count < value.size()) {
					System.out.print(", ");
				} else {
					System.out.println(".");
				}
				count++;
			}
		});
	}
}
