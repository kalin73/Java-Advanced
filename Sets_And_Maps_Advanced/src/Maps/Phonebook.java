package Maps;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Phonebook {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] input = sc.nextLine().split("-");
		LinkedHashMap<String, String> phonebook = new LinkedHashMap<>();
		String name = "";
		while (!input[0].equals("search")) {

			phonebook.put(input[0], input[1]);
			input = sc.nextLine().split("-");
		}

		name = sc.nextLine();
		while (!name.equals("stop")) {

			if (phonebook.containsKey(name)) {

				System.out.println(name + " -> " + phonebook.get(name));

			} else {

				System.out.printf("Contact %s does not exist.%n", name);
			}

			name = sc.nextLine();
		}
		sc.close();
	}

}
