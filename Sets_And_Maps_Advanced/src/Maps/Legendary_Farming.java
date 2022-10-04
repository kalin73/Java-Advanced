package Maps;

import java.util.Scanner;
import java.util.TreeMap;

public class Legendary_Farming {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		boolean crafted = true;

		TreeMap<String, Integer> items = new TreeMap<>();
		TreeMap<String, Integer> junk = new TreeMap<>();
		items.put("shards", 0);
		items.put("fragments", 0);
		items.put("motes", 0);

		int quant = 0;
		String material = "";
		String item = "";

		while (crafted) {
			String[] materials = sc.nextLine().toLowerCase().split(" ");
			for (int i = 0; i < materials.length; i += 2) {

				quant = Integer.parseInt(materials[i]);
				material = materials[i + 1].toLowerCase();

				if (items.get(material) != null
						&& (material.equals("shards") || material.equals("fragments") || material.equals("motes"))) {

					items.put(material, items.get(material) + quant);

				} else if (material.equals("shards") || material.equals("fragments") || material.equals("motes")) {
					items.put(material, quant);

				} else {
					if (junk.get(material) != null) {
						junk.put(material, junk.get(material) + quant);

					} else {
						junk.put(material, quant);
					}
				}

				if (material.equals("shards")) {
					if (items.get(material) >= 250) {

						crafted = false;
						items.put(material, items.get(material) - 250);
						item = "Shadowmourne obtained!";
						break;
					}

				} else if (material.equals("fragments")) {
					if (items.get(material) >= 250) {

						crafted = false;
						items.put(material, items.get(material) - 250);
						item = "Valanyr obtained!";
						break;
					}

				} else if (material.equals("motes")) {
					if (items.get(material) >= 250) {

						crafted = false;
						items.put(material, items.get(material) - 250);
						item = "Dragonwrath obtained!";
						break;
					}
				}
			}
		}
		System.out.println(item);

		items.entrySet().stream().sorted((fs, se) -> Integer.compare(se.getValue(), fs.getValue()))
				.forEach(x -> System.out.println(x.getKey() + ": " + x.getValue()));

		junk.forEach((key, value) -> System.out.println(key + ": " + value));

		sc.close();
	}
}
