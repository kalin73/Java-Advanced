package Sets;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class Unique_Usernames {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedHashSet<String> userNames = new LinkedHashSet<>();
		int n = Integer.parseInt(sc.nextLine());

		for (int i = 0; i < n; i++) {

			userNames.add(sc.nextLine());

		}
		userNames.forEach(x -> System.out.println(x));
		sc.close();
	}

}
