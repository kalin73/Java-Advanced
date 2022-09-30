package Maps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Product_Shop {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<String, LinkedHashMap<String, Double>> shops = new TreeMap<>();
		String[] input = sc.nextLine().split(", ");
		LinkedHashMap<String, Double> products = new LinkedHashMap<>();

		while (!"Revision".equals(input[0])) {
			String shopName = input[0];
			String product = input[1];
			Double price = Double.parseDouble(input[2]);

			if (!shops.containsKey(shopName)) {
				products = new LinkedHashMap<>();
				products.put(product, price);
				shops.put(shopName, products);
				continue;
			}

			shops.get(shopName).put(product, price);
			input = sc.nextLine().split(", ");
		}

		shops.forEach((key, value) -> {
			System.out.println(key + "->");
			value.forEach((k, v) -> {
				System.out.printf("Product: %s, Price: %.1f%n", k, v);
			});

		});
		sc.close();
	}

}
