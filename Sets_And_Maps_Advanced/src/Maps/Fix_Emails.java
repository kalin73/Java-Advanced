package Maps;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Fix_Emails {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		String email = "";
		LinkedHashMap<String, String> emails = new LinkedHashMap<>();

		while (!name.equals("stop")) {

			email = sc.nextLine();

			if (!email.toLowerCase().contains(".uk") && !email.toLowerCase().contains(".com")
					&& !email.toLowerCase().contains(".us")) {
				emails.put(name, email);
			}

			name = sc.nextLine();
		}

		emails.entrySet().forEach(x -> System.out.printf("%s -> %s%n", x.getKey(), x.getValue()));
		sc.close();
	}

}
