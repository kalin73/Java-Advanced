package genericCountMethodStrings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Double> list = new ArrayList<>();
		Double n = Double.parseDouble(sc.nextLine());

		while (n-- > 0) {
			list.add(Double.parseDouble(sc.nextLine()));
		}

		System.out.println(GenericBox.getCount(list, Double.parseDouble(sc.nextLine())));
		sc.close();
	}

}
