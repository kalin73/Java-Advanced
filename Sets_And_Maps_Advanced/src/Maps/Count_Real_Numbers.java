package Maps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Count_Real_Numbers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<Double, Integer> map = new LinkedHashMap<>();

		double[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToDouble(x -> Double.parseDouble(x)).toArray();

		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i]) + 1);
			} else {
				map.put(arr[i], 1);
			}

		}
		map.forEach((key, value) -> {
			System.out.printf("%.1f -> %d%n", key, value);
		});
	}

}
