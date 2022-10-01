package Sets;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Sets_of_Elements {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedHashSet<Integer> set1 = new LinkedHashSet<>();
		LinkedHashSet<Integer> set2 = new LinkedHashSet<>();

		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		sc.nextLine();
		
		for (int i = 0; i < n1; i++) {
			set1.add(Integer.parseInt(sc.nextLine()));

		}
		for (int i = 0; i < n2; i++) {
			set2.add(Integer.parseInt(sc.nextLine()));

		}
		Iterator<Integer> it = set1.iterator();
		while (it.hasNext()) {
			int number = it.next();

			if (set2.contains(number)) {
				System.out.print(number + " ");
			}
		}
		sc.close();
	}
}
