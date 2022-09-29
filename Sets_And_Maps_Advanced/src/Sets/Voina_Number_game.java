package Sets;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Voina_Number_game {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedHashSet<Integer> player1 = new LinkedHashSet<>(
				Arrays.stream(sc.nextLine().split(" ")).map(x -> Integer.parseInt(x)).collect(Collectors.toList()));
		LinkedHashSet<Integer> player2 = new LinkedHashSet<>(
				Arrays.stream(sc.nextLine().split(" ")).map(x -> Integer.parseInt(x)).collect(Collectors.toList()));

		int counter = 1;
		while (counter <= 50) {

			if (player1.isEmpty()) {
				System.out.println("Second player win!");
				return;
			} else if (player2.isEmpty()) {
				System.out.println("First player win!");
				return;
			}
			int p1 = player1.iterator().next();
			player1.remove(p1);
			int p2 = player2.iterator().next();
			player2.remove(p2);

			if (p1 > p2) {

				player1.add(p1);
				player1.add(p2);

			} else if (p1 < p2) {

				player2.add(p1);
				player2.add(p2);
			}

			counter++;
		}
		if (player1.size() > player2.size()) {

			System.out.println("First player win!");
		} else if (player1.size() < player2.size()) {

			System.out.println("Second player win!");
		} else {
			System.out.println("Draw!");
		}
	}

}
