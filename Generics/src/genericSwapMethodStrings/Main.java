package genericSwapMethodStrings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<String> strings = new ArrayList<>();

		int n = Integer.parseInt(sc.nextLine());

		while (n-- > 0) {
			strings.add(sc.nextLine());
		}

		int index1 = sc.nextInt();
		int index2 = sc.nextInt();
		System.out.println();

		SwapClass.swap(strings, index1, index2);
		SwapClass.print(strings);

		sc.close();
	}

}
