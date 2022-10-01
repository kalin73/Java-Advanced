package Sets;

import java.util.Scanner;
import java.util.TreeSet;

public class Periodic_Table {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TreeSet<String> elements = new TreeSet<>();
		int n = sc.nextInt();
		sc.nextLine();

		for (int i = 0; i < n; i++) {
			String[] input = sc.nextLine().split(" ");
			for (int k = 0; k < input.length; k++) {
				elements.add(input[k]);
			}

		}
		elements.forEach(x -> System.out.print(x + " "));
		sc.close();
	}

}
