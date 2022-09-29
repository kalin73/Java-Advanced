package Sets;

import java.util.Scanner;
import java.util.TreeSet;

public class SoftUni_Party {

	public static void main(String[] args) {
		TreeSet<String> vip = new TreeSet<>();
		TreeSet<String> regular = new TreeSet<>();
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();

		while (!input.equals("PARTY")) {
			if (Character.isDigit(input.charAt(0))) {
				vip.add(input);
			} else {
				regular.add(input);
			}
			input = sc.nextLine();
		}
		while (!input.equals("END")) {
			if (Character.isDigit(input.charAt(0))) {
				vip.remove(input);
			} else {
				regular.remove(input);
			}

			input = sc.nextLine();
		}
		int guest = vip.size() + regular.size();
		System.out.println(guest);
		vip.forEach(x -> System.out.println(x));
		regular.forEach(x -> System.out.println(x));
		sc.close();
	}
}
